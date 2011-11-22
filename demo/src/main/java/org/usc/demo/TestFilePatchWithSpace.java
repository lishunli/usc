package org.usc.demo;

import java.io.File;
import java.net.URISyntaxException;

public class TestFilePatchWithSpace {

    public static void main(String[] args) throws URISyntaxException {
        System.out.println(TestFilePatchWithSpace.class.getClassLoader().getResource("org").toURI().getPath());
        System.out.println( new File(TestFilePatchWithSpace.class.getClassLoader().getResource("org/").toURI().getPath() + "text.txt"));
        String filePath = TestFilePatchWithSpace.class.getClassLoader().getResource("org").toURI().getPath() ;//"D:/test file path/Test/bin/org";
        String fileName = "test.txt";
        File file = new File(filePath, fileName);

        System.out.println(filePath);
        System.out.println(TestFilePatchWithSpace.class.getClassLoader().getResource("org").getPath());
        System.out.println(file.getAbsolutePath());

        System.out.println(new File("/mnt"));
        System.out.println(file.exists());

        File fileDir = new File("/mnt");
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        System.out.println(new File("/mnt","text.txt"));


    }

}
