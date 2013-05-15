package org.usc.demo.wechat.msg;

import org.usc.demo.wechat.util.XmlUtil;

/**
 *
 * @author Shunli
 */
public enum MsgType {
    TEXT("text") {
        @Override
        public Class<? extends AbstractMsg> getMsgClass() {
            return TextMsg.class;
        }
    },
    EVENT("event") {
        @Override
        public Class<? extends AbstractMsg> getMsgClass() {
            return EventMsg.class;
        }
    },
    IMAGE("image") {
        @Override
        public Class<? extends AbstractMsg> getMsgClass() {
            return ImageMsg.class;
        }
    },
    LINK("link") {
        @Override
        public Class<? extends AbstractMsg> getMsgClass() {
            return LinkMsg.class;
        }
    },
    LOCATION("location") {
        @Override
        public Class<? extends AbstractMsg> getMsgClass() {
            return LocationMsg.class;
        }
    };

    private String type;

    private MsgType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public abstract Class<? extends AbstractMsg> getMsgClass();

    public AbstractMsg parseMsg(String message) {
        return XmlUtil.unmarshal(message, getMsgClass());
    }
}
