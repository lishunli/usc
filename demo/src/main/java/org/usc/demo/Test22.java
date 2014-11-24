package org.usc.demo;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Splitter;

/**
 *
 * @author Shunli
 */
public class Test22 {
    public static void main(String[] args) {
        String channel = "TY1";
        System.out.println(getChannelGiftId(channel));

        // String gifts = "OFFICAL=1,TY=2,MEDIA=3";
        // Map<String, String> giftsMap = Splitter.on(",").withKeyValueSeparator("=").split(gifts);
        // System.out.println(giftsMap);
        //
        //
        // String giftId = giftsMap.get(StringUtils.upperCase(channel));
        //
        // Optional<String> fromNullable = Optional.fromNullable(giftId);
        // if (fromNullable.isPresent()) {
        // System.out.println("hi");
        // } else {
        // System.out.println("world");
        // }
        // System.out.println(fromNullable.or("xxx"));
        // // Objects.firstNonNull(first, second)
        // System.out.println(giftId);
        //
        // if (StringUtils.isEmpty(giftId)) {
        // System.out.println(giftsMap.get(DEFAULT_GIFT_KEY));
        // } else {
        // System.out.println(giftId);
        // }
    }

    private static String DEFAULT_GIFT_KEY = "OFFICAL";

    private static String getChannelGiftId(String channel) {
        String gifts = "OFFICAL=1,TY=2,MEDIA=3";
        Map<String, String> giftsMap = Splitter.on(",").withKeyValueSeparator("=").split(gifts);

        String giftId = giftsMap.get(StringUtils.upperCase(channel));
        if (StringUtils.isEmpty(giftId)) {
            return giftsMap.get(DEFAULT_GIFT_KEY);
        }

        return giftId;
    }
}
