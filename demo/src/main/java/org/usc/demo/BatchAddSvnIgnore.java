package org.usc.demo;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.commons.io.filefilter.PrefixFileFilter;
import org.apache.commons.lang3.StringUtils;

import com.google.common.io.Resources;

/**
 *
 * @author Shunli
 */
public class BatchAddSvnIgnore {

    public static void main(String[] args) {
        String path = "D:\\Source\\XLActGroup\\dubbox-2.8.3";

        File directory = new File(path);

        ProcessBuilder pb = new ProcessBuilder();
        String svnIgnoresFileName = "";
        try {
            File svnIgnoresFile = new File(Resources.getResource("mvn_ignores.svnprops").toURI());
            svnIgnoresFileName = svnIgnoresFile.getPath();
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }

        if (StringUtils.isEmpty(svnIgnoresFileName)) {
            return;
        }

        Iterator<File> iterateFiles = FileUtils.iterateFilesAndDirs(directory, FalseFileFilter.INSTANCE, new PrefixFileFilter("dubbo-"));
        while (iterateFiles.hasNext()) {
            File file = iterateFiles.next();

            try {
                System.out.println("svn propset svn:ignore -F " + svnIgnoresFileName + " " + file.getName() + ",on " + file.getParentFile());
                pb.directory(file.getParentFile());
                pb.command("svn", "propset", "svn:ignore", "-F", svnIgnoresFileName, file.getName());
                pb.start();

                TimeUnit.MILLISECONDS.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
