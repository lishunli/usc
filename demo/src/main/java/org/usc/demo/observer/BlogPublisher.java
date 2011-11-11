package org.usc.demo.observer;


public class BlogPublisher extends AbstractPublisher {

    private String blogJavaName;

    public String getBlogJavaName() {
        return blogJavaName;
    }

    public BlogPublisher(String blogJavaName) {
        this.blogJavaName = blogJavaName;
    }
}
