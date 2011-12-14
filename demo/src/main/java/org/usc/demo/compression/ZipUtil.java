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
    private final static String EXCLUDED_WORD = ".svn | target | target-eclipse | .classpath | .project | .settings | build.bat";
    private final static int BUFFER_SIZE = 128;

    private static boolean init = false;
    private static List<String> excludedKeys = new ArrayList<String>();

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
            ZipArchiveOutputStream zos = null;
            try {
                zos = new ZipArchiveOutputStream(out);

                for (Map.Entry<String, File> entry : map.entrySet()) {
                    File file = entry.getValue();

                    ZipArchiveEntry ze = new ZipArchiveEntry(file, entry.getKey());
                    zos.putArchiveEntry(ze);

                    if (file.isFile()) {
                        InputStream is = new FileInputStream(file);
                        byte[] b = new byte[BUFFER_SIZE];
                        int i = -1;
                        while ((i = is.read(b)) != -1) {
                            zos.write(b, 0, i);
                        }
                        is.close();
                    }

                    zos.closeArchiveEntry();
                }

                zos.finish();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                if (zos != null) {
                    try {
                        zos.close();
                    } catch (IOException e) { /* swallow */
                    }
                }
            }
        }
    }

    protected static void list(File f, String parent, Map<String, File> map) {
        String name = f.getName();

        if (parent != null) {
            name = parent + "/" + name;// set zip parent location.
        }
        // is exclude?
        if (!isExcluded(f)) {
            if (f.isFile()) {
                map.put(name, f);
            } else if (f.isDirectory()) {
                File[] subFiles = f.listFiles();

                if (subFiles.length > 0) {
                    for (File file : subFiles) {
                        list(file, name, map);
                    }
                } else { // empty directory
                    map.put(name, f);
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
    protected static boolean isExcluded(File f) {
        initExcludedKeys(EXCLUDED_WORD);

        for (String key : excludedKeys) {
            if (key.equalsIgnoreCase(f.getName())) {
                return true;
            }

        }
        return false;
    }

    protected static void initExcludedKeys(String excludedWord) {
        if (!init) {
            if (StringUtils.isNotBlank(excludedWord)) {
                excludedKeys.addAll(Arrays.asList(excludedWord.split("\\s\\|\\s")));
            }
            init = true;
        }
    }
}
