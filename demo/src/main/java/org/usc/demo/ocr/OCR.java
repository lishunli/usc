package org.usc.demo.ocr;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OCR {
    protected transient final static Logger logger = LoggerFactory.getLogger("OCR");
    private static String TESSERACT_PTAH = new File("D:\\Tool\\Tesseract-OCR").getAbsolutePath();

    public static String read(byte[] image) throws Exception {
        File file = new File(TESSERACT_PTAH + "/img", System.nanoTime() + ".jpg");
        // System.out.println(file);
        FileOutputStream output = new FileOutputStream(file);
        IOUtils.write(image, output);

        String randCode = read(file);
        randCode = randCode.replaceAll("\\s", "");

        IOUtils.closeQuietly(output);
        // FileUtils.deleteQuietly(file);
        return randCode;
    }

    public static String read(File imageFile) throws Exception {
        String result = "";
        File outputFile = new File(imageFile.getParent(), imageFile.getName());

        List<String> cmd = new ArrayList<String>();
        cmd.add(TESSERACT_PTAH + "\\tesseract");
        cmd.add("");
        cmd.add(outputFile.getName());
        // cmd.add(LANG_OPTION);
        // cmd.add("verify");
        // cmd.add("eng");
        // cmd.add("nobatch");
        // cmd.add("digits");

        ProcessBuilder pb = new ProcessBuilder();
        pb.directory(imageFile.getParentFile());

        cmd.set(1, imageFile.getName());
        pb.command(cmd);
        pb.redirectErrorStream(true);
        Process process = pb.start();

        int w = process.waitFor();
        logger.debug("Exit value = {}", w);

        File file = new File(outputFile.getAbsolutePath() + ".txt");
        if (w == 0) {
            result = FileUtils.readFileToString(file);
        } else {
            String msg;
            switch (w) {
            case 1:
                msg = "Errors accessing files. There may be spaces in your image's filename.";
                break;
            case 29:
                msg = "Cannot recognize the image or its selected region.";
                break;
            case 31:
                msg = "Unsupported image format.";
                break;
            default:
                msg = "Errors occurred.";
            }
            System.err.println("验证码获取失败：" + msg);
            // throw new RuntimeException(msg);
        }

        // FileUtils.deleteQuietly(file);

        return result.trim();
    }

}
