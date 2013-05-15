package org.usc.demo.wechat.msg;

import org.usc.demo.wechat.util.XmlUtil;

/**
 *
 * @author Shunli
 */
public enum MsgParser {
    TEXT {
        @Override
        public Class<? extends AbstractMsg> getMsgClass() {
            return TextMsg.class;
        }
    },
    EVENT {
        @Override
        public Class<? extends AbstractMsg> getMsgClass() {
            return EventMsg.class;
        }
    },
    IMAGE {
        @Override
        public Class<? extends AbstractMsg> getMsgClass() {
            return ImageMsg.class;
        }
    },
    LINK {
        @Override
        public Class<? extends AbstractMsg> getMsgClass() {
            return LinkMsg.class;
        }
    },
    LOCATION {
        @Override
        public Class<? extends AbstractMsg> getMsgClass() {
            return LocationMsg.class;
        }
    };

    public abstract Class<? extends AbstractMsg> getMsgClass();

    public AbstractMsg parseMsg(String message) {
        return XmlUtil.unmarshal(message, getMsgClass());
    }
}
