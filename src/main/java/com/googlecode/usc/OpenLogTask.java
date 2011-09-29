package com.googlecode.usc;

import java.io.IOException;

/**
 *
 * @author ShunLi
 */
class OpenLogTask extends java.util.TimerTask {
    @Override
    public void run() {
        try {
            Runtime.getRuntime().exec("notepad.exe " + System.getProperty("user.dir") + "\\log\\copier.log");
        } catch (IOException e) {
        }
    }
}
