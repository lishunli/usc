package org.usc.demo.compression;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author lan
 */
public final class ZipUtil {
    private final static String EXCLUDED_WORD = ".svn | target | .classpath | .project | .settings";

    /**
     * 打包文件
     *
     * @param files
     *            文件或文件夹的集合
     * @param out
     *            输出的zip文件
     */
    public static void zip(File[] files, File out) {
        Map<String, File> map = new HashMap<String, File>();
        String parent = FilenameUtils.getBaseName(out.getName());

        for (File f : files) {
            list(f, parent, map);
        }

        if (!map.isEmpty()) {
            try {
                ZipArchiveOutputStream zaos = new ZipArchiveOutputStream(out);
                for (Map.Entry<String, File> entry : map.entrySet()) {
                    File file = entry.getValue();
                    ZipArchiveEntry zae = new ZipArchiveEntry(file, entry.getKey());
                    zaos.putArchiveEntry(zae);
                    InputStream is = new FileInputStream(file);
                    byte[] b = new byte[1024 * 5];
                    int i = -1;
                    while ((i = is.read(b)) != -1) {
                        zaos.write(b, 0, i);
                    }
                    is.close();
                    zaos.closeArchiveEntry();
                }
                zaos.finish();
                zaos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally{

            }
        }
    }

    private static void list(File f, String parent, Map<String, File> map) {
        String name = f.getName();
        if (parent != null) {
            name = parent + "/" + name;// 设置在zip包里的相对路径
        }
        // is exclude?
        if (!isExcluded(f)) {
            if (f.isFile()) {
                map.put(name, f);
            } else if (f.isDirectory()) {
                for (File file : f.listFiles()) {
                    list(file, name, map);
                }
            }
        }

    }

    /**
     * is exclude?
     *
     * @param f
     * @return
     */
    private static boolean isExcluded(File f) {
        for (String key : getExcludedKeys(EXCLUDED_WORD)) {
            if (key.equalsIgnoreCase(f.getName())) {
                return true;
            }

        }
        return false;
    }

    protected static List<String> getExcludedKeys(String excludedWord) {
        List<String> excludedKeys = new ArrayList<String>();
        if (StringUtils.isNotBlank(excludedWord)) {
            excludedKeys.addAll(Arrays.asList(excludedWord.split("\\s\\|\\s")));
        }
        return excludedKeys;
    }
}
