package org.usc.demo;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.scannotation.AnnotationDB;

/**
 *
 * @author ShunLi
 */
public class ScanAnnotaionClass {

    public static void main(String[] args) throws IOException {
        List<String> projectClasspath = Arrays.asList("D:/MSSE/mss-app/mss-app-main/primary/target/classes", "C:/Documents and Settings/slli/.m2/repository/com/taifook/mtss/mss-e/mss-app/mss-app-main-base-api/1.1-SNAPSHOT/mss-app-main-base-api-1.1-SNAPSHOT.jar");
        ArrayList<File> projectClasspathFiles = new ArrayList<File>(projectClasspath.size());
        for (String path : projectClasspath) {
            projectClasspathFiles.add(new File(path));
        }

        URL[] urls = FileUtils.toURLs(projectClasspathFiles.toArray(new File[0]));

        AnnotationDB db = new AnnotationDB();
        db.scanArchives(urls);

        Set<String> className = db.getAnnotationIndex().get(javax.persistence.Entity.class.getName());
        for (String name : className) {
            System.out.println("<class>" + name + "</class>");
        }
    }
}
