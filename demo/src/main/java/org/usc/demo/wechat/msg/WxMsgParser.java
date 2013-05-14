package org.usc.demo.wechat.msg;

public enum WxMsgParser {
    TEXT {
        @Override
        public WxMsg parseMsg(String message) {
            return new TextWxMsg();
        }
    },
    EVENT {
        @Override
        public WxMsg parseMsg(String message) {
            return new EventWxMsg();
        }
    },
    IMAGE {
        @Override
        public WxMsg parseMsg(String message) {
            return new ImageWxMsg();
        }
    },
    LINK {
        @Override
        public WxMsg parseMsg(String message) {
            return new LinkWxMsg();
        }
    },
    LOCATION {
        @Override
        public WxMsg parseMsg(String message) {
            return new LocationWxMsg();
        }
    };

    public abstract WxMsg parseMsg(String message);
}
