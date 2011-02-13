package com.haitong.utils;

/**
 *
 * @author ShunLi
 */
public class Decryption implements Code {

    public String changeCode(String orginCode) {
        StringBuffer buffer = new StringBuffer();

        for(int i = 0,j =1;i<orginCode.length();i++){
            buffer.append((char)(orginCode.charAt(i) - (j++)));
        }

        return buffer.toString();
    }

}
