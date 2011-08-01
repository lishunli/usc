package org.usc.demo.observer;

import org.junit.Test;

public class TestCase {

    @Test
    public void register() {
        Reader reader = new Reader();

        WeiboPublisher weiboPublisher = new WeiboPublisher("lishunli");
        weiboPublisher.addObserver(reader);
        weiboPublisher.publish();

        BlogJavaPublisher blogJavaPublisher = new BlogJavaPublisher("lishunli");
        blogJavaPublisher.addObserver(reader);
        blogJavaPublisher.publish();

    }

}
