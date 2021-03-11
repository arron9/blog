package com.yunchen.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.*;

@Slf4j
public class RestTemplateUtils {
    public static RestTemplate getInstance() {
        RestTemplate restTemplate = new RestTemplate();

        List<MediaType> mediaTypes = Arrays.asList(
                MediaType.parseMediaType("text/html; charset=utf-8"),
                MediaType.parseMediaType("text/plain; charset=utf-8"),
                MediaType.parseMediaType("application/octet-stream")
        );

        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        jsonConverter.setSupportedMediaTypes(mediaTypes);
        restTemplate.getMessageConverters().add(jsonConverter);

        return restTemplate;
    }

    public static <T> URI getFullUrl(String baseUrl, Map<String, T> urlParams) {
        StringBuilder sb = new StringBuilder();

        for (String key : urlParams.keySet()) {
            T value = urlParams.get(key);
            if (value == null) {
                continue;
            }

            sb.append(key).append("=").append(urlEncode(value.toString())).append("&");
        }

        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            sb.insert(0, baseUrl + (baseUrl.indexOf("?") > 0 ? "&" : "?"));
        }

        try {
            return new URI(sb.toString());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> MultiValueMap<String, T> convert(Map<String, T> params) {
        MultiValueMap<String, T> map = new LinkedMultiValueMap<>();

        for (String key : params.keySet()) {
            map.add(key, params.get(key));
        }

        return map;
    }

    public static <T> String getSign(Map<String, T> params, String signKey, boolean encode) {
        return getSign(params, "", signKey, encode);
    }

    public static <T> String getSign(Map<String, T> params, String body, String signKey, boolean encode) {
        return getSign(new TreeMap<>(params), body, signKey, encode);
    }

    public static <T> String getSign(SortedMap<String, T> sortedParams, String body, String signKey, boolean encode) {
        StringBuilder sb = new StringBuilder();
        for (String key : sortedParams.keySet()) {
            if (key.equals("sign")) {
                continue;
            }

            T value = sortedParams.get(key);
            if (value == null) {
                continue;
            }

            sb.append(key).append("=").append(encode ? urlEncode(value.toString()) : value.toString());
        }

        log.info("sign param str: " + sb.toString());
        sb.append(body).append(signKey);

        return HashUtils.md5(sb.toString());
    }

    public static <T> String getSignWithoutKey(List<T> list, String signKey, boolean encode) {
        StringBuilder sb = new StringBuilder();

        list.sort(null);
        for (T value : list) {
            if (value == null) {
                continue;
            }

            sb.append(encode ? urlEncode(value.toString()) : value.toString());
        }

        log.info("sign param str: " + sb.toString());
        sb.insert(0, signKey);

        return HashUtils.md5(sb.toString());
    }

    public static String urlEncode(String str) {
        try {
            str = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            //
        }

        return str;
    }
}
