package org.usc.demo.wechat.util;

import java.io.File;
import java.io.StringReader;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.usc.demo.wechat.Push;
import org.usc.demo.wechat.msg.EventWxMsg;
import org.usc.demo.wechat.msg.WxMsg;

public class XmlUtil {
    public static void main(String[] args) throws Exception {

        // JAXBContext jaxbCtx = JAXBContext.newInstance(WxMsg.class);
        //
        // TextWxMsg msg = new TextWxMsg();
        // msg.setFromUserName("lishunli");
        // msg.setContent("test");
        //
        // Marshaller marshaller = jaxbCtx.createMarshaller();
        // marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        //
        // marshaller.marshal(msg, System.out);
        //
        // URL resource = new Push().getClass().getClassLoader().getResource("wechat/push");
        // File f = new File(resource.getFile(), "text.txt");
        //
        // Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
        // TextWxMsg dest = (TextWxMsg) unmarshaller.unmarshal(f);
        // System.out.println(ToStringBuilder.reflectionToString(dest));
        URL resource = new Push().getClass().getClassLoader().getResource("wechat/push");
        File f = new File(resource.getFile(), "event.txt");

        JAXBContext jaxbCtx = JAXBContext.newInstance(EventWxMsg.class);
        Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
        WxMsg dest = (WxMsg) unmarshaller.unmarshal(f);
        System.out.println(ToStringBuilder.reflectionToString(dest));
    }

    public static WxMsg unmarshal(String message) {
        try {
            JAXBContext jaxbCtx = JAXBContext.newInstance(WxMsg.class);
            Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();

            return (WxMsg) unmarshaller.unmarshal(new StringReader(message));
        } catch (Exception e) {
        }

        return null;
    }
}
