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
    private final static String EXCLUDED_WORD = ".svn | target | target-eclipse | .classpath | .project | .settings";

    /**
     * zip folder
     *
     * @param files
     *            file array
     * @param out
     *            zip file
     */
    public static void zip(File[] files, File out) {
        Map<String, File> map = new HashMap<String, File>();
        String parent = FilenameUtils.getBaseName(out.getName());

        for (File f : files) {
            list(f, parent, map);
        }

        if (!map.isEmpty()) {
            ZipArchiveOutputStream zipOutput = null;
            try {
                zipOutput = new ZipArchiveOutputStream(out);
                for (Map.Entry<String, File> entry : map.entrySet()) {
                    File file = entry.getValue();

                    ZipArchiveEntry zipArchiveEntry = new ZipArchiveEntry(file, entry.getKey());
                    zipOutput.putArchiveEntry(zipArchiveEntry);

                    InputStream is = new FileInputStream(file);
                    byte[] b = new byte[128];
                    int i = -1;
                    while ((i = is.read(b)) != -1) {
                        zipOutput.write(b, 0, i);
                    }

                    is.close();
                    zipOutput.closeArchiveEntry();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    zipOutput.finish();
                    zipOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void list(File f, String parent, Map<String, File> map) {
        String name = f.getName();

        if (parent != null) {
            name = parent + "/" + name;// set zip parent location.
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
