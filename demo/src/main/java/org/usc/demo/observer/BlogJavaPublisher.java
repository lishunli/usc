package org.usc.demo.observer;

import java.util.Observable;

public class BlogJavaPublisher extends Observable {

    private String blogJavaName;

    public String getBlogJavaName() {
        return blogJavaName;
    }

    public BlogJavaPublisher(String blogJavaName) {
        this.blogJavaName = blogJavaName;
    }

    public void publish() {
        setChanged();
        notifyObservers(this);
    }

}
