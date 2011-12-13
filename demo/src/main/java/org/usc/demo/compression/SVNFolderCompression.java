package org.usc.demo.compression;

import java.io.File;
import java.util.Timer;

import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author ShunLi
 */
public class SVNFolderCompression {
    public static void main(String[] args) {
        // String svnFolder = "D:/Data/jdbcdslog-exp";
        String svnFolder = "D:/MSSE/";

        String clearSVNFolder = FilenameUtils.getFullPathNoEndSeparator(svnFolder);

        File[] files = new File(clearSVNFolder).listFiles();
        File out = new File(clearSVNFolder + ".zip");

        Timer timer = new Timer();
        timer.schedule(new PrintTimerTask(), 0, 1000);

        ZipUtil.zip(files, out);

        timer.cancel();
        System.out.println("\nZip => " + out + " completed.");
    }
}

class PrintTimerTask extends java.util.TimerTask {
    int count;

    @Override
    public void run() {
        System.out.print("·");
        if ((++count) % 60 == 0) { // 60s = 1min
            System.out.println();
        }
    }
}
