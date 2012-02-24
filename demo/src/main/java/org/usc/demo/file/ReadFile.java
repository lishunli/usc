package org.usc.demo.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 *
 * @author ShunLi
 */
public class ReadFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:/Serveur_20110826.txt");

        LineNumberReader reader = new LineNumberReader(new InputStreamReader(fis));

        String content = null;
        while ((content = reader.readLine()) != null) {
            System.out.println(content.substring(0, 960));
        }

        reader.close();
        fis.close();

    }

}
