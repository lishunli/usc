package org.usc.demo.observer;

/**
 *
 * @author ShunLi
 */
public class Event {
    public String eventType;
    public String content;

    public Event() {
        super();
    }

    public Event(String eventType) {
        this.eventType = eventType;
    }

    public Event(String eventType, String content) {
        this.eventType = eventType;
        this.content = content;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
