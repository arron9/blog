package com.yunchen.common.Consts;

/**
 * wangpeng(kikoroc@gmail.com)
 * 18/6/23
 */
public class Consts {

    public static final String ACCESS_TOKEN_FIELD = "access_token";

    public static final String AUTHED_ACCOUNT = "authed_account";

    public static class Rpc{
        public static final long EXPIRE_TIME = 2*60*1000L;
        public static final String HEADER_RPC_NONCE = "rpc_nonce";
        public static final String HEADER_RPC_TIMESTAMP = "rpc_ts";
        public static final String HEADER_RPC_SIGN = "rpc_sign";
    }

    public static class WebSocket{
        public static final String ABILITY_TEST = "suishi_websocket_abilityTest";
    }
}
