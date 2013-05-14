package org.usc.demo.wechat.msg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({ WxMsg.class })
public class EventWxMsg extends WxMsg {
    @XmlElement(name = "Event")
    private String event;

    @XmlElement(name = "EventKey")
    private String eventKey;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
}
