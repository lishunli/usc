package org.usc.demo.wechat.msg;

import org.usc.demo.wechat.util.XmlUtil;

public enum WxMsgParser {
    TEXT {
        @Override
        public WxMsg parseMsg(String message) {
            return XmlUtil.unmarshal(message);
        }
    },
    EVENT {
        @Override
        public WxMsg parseMsg(String message) {
            return XmlUtil.unmarshal(message);
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
