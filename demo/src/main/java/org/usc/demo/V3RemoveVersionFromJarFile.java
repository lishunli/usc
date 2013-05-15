package org.usc.demo;

import java.io.File;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

/**
 *
 * @author Shunli
 */
public class V3RemoveVersionFromJarFile {

    public static void main(String[] args) throws Exception {
        String jarFolder = "E:\\Source\\XLAct\\V3\\youxi-act-rh\\trunk\\youxi-act-rh-web\\target\\youxi-act-rh\\WEB-INF\\lib";

        IOFileFilter fileFilter = new IOFileFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return false;
            }

            @Override
            public boolean accept(File file) {
                return file.getName().startsWith("youxi");
            }
        };

        Iterator<File> iterateFiles = FileUtils.iterateFiles(new File(jarFolder), fileFilter, TrueFileFilter.INSTANCE);
        while (iterateFiles.hasNext()) {
            File srcFile = iterateFiles.next();
            String fileName = srcFile.getName();

            String regex = "(-\\d|\\.\\d|-SNAPSHOT)";
            String destFileName = fileName.replaceAll(regex, "");

            if (!fileName.equals(destFileName)) {
                FileUtils.moveFile(srcFile, new File(srcFile.getParent(), destFileName));
                System.out.println(fileName + " ==> " + destFileName);
            }
        }

    }

}
