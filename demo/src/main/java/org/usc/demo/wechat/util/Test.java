package org.usc.demo.wechat.util;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.usc.demo.wechat.Push;
import org.usc.demo.wechat.msg.AbstractMsg;
import org.usc.demo.wechat.msg.TextMsg;
import org.usc.demo.wechat.reply.ArticleDetail;
import org.usc.demo.wechat.reply.MusicDetail;
import org.usc.demo.wechat.reply.MusicReply;
import org.usc.demo.wechat.reply.NewsReply;
import org.usc.demo.wechat.reply.TextReply;

/**
 *
 * @author Shunli
 */
@SuppressWarnings("unused")
public class Test {
    public static void main(String[] args) throws Exception {
//        unmarshalTextMsg();
//        marshalTextReply();
        marshalMusicReply();
//        marshalNewsReply();
    }

    private static void marshalTextReply() throws Exception {
        System.out.println("\n" + StringUtils.center(" marshalTextReply ", 80, "="));

        TextReply wxPeply = new TextReply();
        wxPeply.setContent("中文测试test");
        wxPeply.setCreateTime(1368590592L);
        wxPeply.setFromUserName("gh_5b2229334c42");
        wxPeply.setToUserName("ol_e_joFnsa1UMeRtSJIA4BjQFWU");
        wxPeply.setFuncFlag(0);
        wxPeply.setMsgType("text");

        XmlUtil.marshal(wxPeply, TextReply.class);
    }

    private static void marshalMusicReply() throws Exception {
        System.out.println("\n" + StringUtils.center(" marshalMusicReply ", 80, "="));

        MusicDetail musicDetail = new MusicDetail();
        musicDetail.setDescription("i love it");
        musicDetail.sethQMusicUrl("http://zhangmenshiting.baidu.com/data2/music/8382776/1010926165600320.mp3?xcode=285d2800236ed221da42e1f1a4fa697b");
        musicDetail.setMusicUrl("http://zhangmenshiting.baidu.com/data2/music/7306953/1010926165600128.mp3?xcode=285d2800236ed221ac5cb01b8744315c");
        musicDetail.setTitle("想\r把\r\n我\n唱\t给&#xD;你 听 - 老狼,小柯,曹芳,王筝.mp3");

        MusicReply wxPeply = new MusicReply();
        wxPeply.setMusicDetail(musicDetail);
        wxPeply.setCreateTime(1368590592L);
        wxPeply.setFromUserName("gh_5b2229334c42");
        wxPeply.setToUserName("ol_e_joFnsa1UMeRtSJIA4BjQFWU");
        wxPeply.setFuncFlag(1);
        wxPeply.setMsgType("music");

        XmlUtil.marshal(wxPeply, MusicReply.class);
    }

    private static void marshalNewsReply() throws Exception {
        System.out.println("\n" + StringUtils.center(" marshalNewsReply ", 80, "="));

        ArticleDetail articleDetail1 = new ArticleDetail();
        articleDetail1.setDescription("i love it 1");
        articleDetail1.setUrl("http://rh.xunlei.com/act/huogai/");
        articleDetail1.setPicUrl("http://img.mygame.xunlei.com/act/rh/huogai/S1151291042846805145.jpg");
        articleDetail1.setTitle("美女1.jpg");

        ArticleDetail articleDetail2 = new ArticleDetail();
        articleDetail2.setDescription("i love it 2");
        articleDetail2.setUrl("http://rh.xunlei.com/act/huogai/");
        articleDetail2.setPicUrl("http://img.mygame.xunlei.com/act/rh/huogai/S1151291035226339250.jpg");
        articleDetail2.setTitle("美女2.jpg");

        List<ArticleDetail> articles = Arrays.asList(articleDetail1, articleDetail2);

        NewsReply wxPeply = new NewsReply();
        wxPeply.setArticles(articles);
        wxPeply.setArticleCount(articles.size());
        wxPeply.setCreateTime(1368590592L);
        wxPeply.setFromUserName("gh_5b2229334c42");
        wxPeply.setToUserName("ol_e_joFnsa1UMeRtSJIA4BjQFWU");
        wxPeply.setFuncFlag(1);
        wxPeply.setMsgType("news");

        XmlUtil.marshal(wxPeply, NewsReply.class);
    }
    private static void unmarshalTextMsg() throws Exception {
        System.out.println("\n" + StringUtils.center(" unmarshalTextMsg ", 80, "="));

        URL resource = new Push().getClass().getClassLoader().getResource("wechat/push");
        File f = new File(resource.getFile(), "text.txt");

        AbstractMsg msg = XmlUtil.unmarshal(FileUtils.readFileToString(f, "utf-8"), TextMsg.class);
        System.out.println(ToStringBuilder.reflectionToString(msg, ToStringStyle.MULTI_LINE_STYLE));
    }
}
