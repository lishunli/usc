package org.usc.demo.wechat.util;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.usc.demo.wechat.msg.AbstractMsg;
import org.usc.demo.wechat.reply.AbstractReply;

/**
 *
 * @author Shunli
 */
public class XmlUtil {
    public static AbstractMsg unmarshal(String message, Class<? extends AbstractMsg> childClass) {
        try {
            JAXBContext jaxbCtx = JAXBContext.newInstance(AbstractMsg.class, childClass);
            Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();

            return (AbstractMsg) unmarshaller.unmarshal(new StringReader(message));
        } catch (Exception e) {
        }

        return null;
    }

    public static void marshal(AbstractReply reply, Class<? extends AbstractReply> childClass) {
        try {
            JAXBContext jaxbCtx = JAXBContext.newInstance(childClass);
            Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            // TODO-Shunli: don't need in production
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(reply, System.out);
        } catch (Exception e) {
        }
    }
}
