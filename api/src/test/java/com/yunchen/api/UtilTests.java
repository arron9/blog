package com.yunchen.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
//@SpringBootTest
//@RunWith(SpringRunner.class)
public class UtilTests {
    private static final Pattern PARAMS_PATTERN = Pattern.compile("\\{#(.*?)#}");

    @Test
    public void testPattern() {
        Matcher matcher = PARAMS_PATTERN.matcher("this is a {#param#}, it's very cool. my name is {#name#}, nice to meet you");
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}
