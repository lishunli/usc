package org.usc.demo;

import java.io.File;
import java.net.InetAddress;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.net.InetAddresses;

/**
 *
 * @author Shunli
 */
public class PingGoogle {

    public static void main(String[] args) throws Exception {
        Splitter splitter = Splitter.on("\t").omitEmptyStrings().trimResults();
        List<String> allIps = Lists.newArrayList();

        for (String ips : FileUtils.readLines(new File("C:/Users/Shunli/Downloads/google_ips.txt"))) {
            List<String> splitToList = splitter.splitToList(ips);
            for (String ip : splitToList) {
                if (InetAddresses.isInetAddress(ip)) {
                    allIps.add(ip);
                }
            }
        }

        System.out.println(allIps);
//        int threadSize = 500;
//
//        ExecutorService exec = Executors.newFixedThreadPool(threadSize);
//        for (List<String> ips : ListUtil.doSubList(allIps, threadSize)) {
//            exec.execute(new PingThread(ips));
//        }
//        exec.shutdown();

        // for (String ip : splitToList) {
        // if (InetAddresses.isInetAddress(ip)) {
        // // boolean status = InetAddress.getByName(ip).isReachable(100);
        // // if (status) {
        // // System.out.println(ip + "==>" + status);
        // //
        // //
        // //
        // // }
        // }
        //
        //
        // // System.out.println(string+"==>"+InetAddresses.isInetAddress(ipString));
        // }

        // System.out.println(splitToList);
        // System.out.println(Splitter.onPattern("((?:(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d)\\.){3}(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d))").splitToList(ips));

    }

}

class PingThread extends Thread {
    private List<String> ips;

    public PingThread(List<String> ips) {
        this.ips = ips;
    }

    @Override
    public void run() {
        for (String ip : ips) {
            try {
                if (InetAddress.getByName(ip).isReachable(5000)) {
                    System.out.println(ip);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
