package org.usc.demo.wechat;

import java.io.File;
import java.net.URL;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.usc.demo.wechat.msg.AbstractMsg;
import org.usc.demo.wechat.msg.MsgType;
import org.usc.demo.wechat.util.EnumUtil;

/**
 *
 * @author Shunli
 */
public class Push {
    public static void main(String[] args) throws Exception {
        URL resource = new Push().getClass().getClassLoader().getResource("wechat/push");

        Collection<File> listFiles = FileUtils.listFiles(new File(resource.toURI()), null, false);
        for (File file : listFiles) {
            parsePushMsg(FileUtils.readFileToString(file));
        }
    }

    private static void parsePushMsg(String message) {
        Validate.notEmpty(message);

        String msgType = getMsgType(message);
        MsgType wxMsgType = EnumUtil.getEnumFromString(MsgType.class, msgType);
        Validate.notNull(wxMsgType, "don't support '%s' type message.", msgType);

        AbstractMsg wxMsg = wxMsgType.parseMsg(message);

        System.out.println(ToStringBuilder.reflectionToString(wxMsg));
    }

    private static String getMsgType(String message) {
        return StringUtils.substringBetween(message, "<MsgType><![CDATA[", "]]></MsgType>");
    }
}
