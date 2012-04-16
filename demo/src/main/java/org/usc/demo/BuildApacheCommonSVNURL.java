package org.usc.demo;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Shunli
 */
public class BuildApacheCommonSVNURL {
    public static void main(String[] args) {
        List<String> commons = Arrays.asList(
                "attributes", "bcel", "beanutils", "betwixt", "bsf", "chain", "cli", "codec",
                "collections", "commons-build", "commons-build-plugin", "commons-nightly",
                "commons-parent", "commons-sandbox-parent", "commons-site", "commons-skin",
                "compress", "configuration", "csv", "daemon", "dbcp", "dbutils", "digester",
                "discovery", "el", "email", "exec", "fileupload", "functor", "httpclient",
                "io", "jci", "jcs", "jelly", "jexl", "jxpath", "lang", "launcher", "logging",
                "math", "modeler", "net", "ognl", "pool", "primitives", "proxy", "sanselan",
                "scxml", "validator", "vfs");

        System.out.println("#----------------------Checkout------------------------#");
        String checkoutTpt = "svn checkout http://svn.apache.org/repos/asf/commons/proper/%1$s/trunk %1$s";
        for (String common : commons) {
            System.out.println(String.format(checkoutTpt, common));
        }

        System.out.println("#----------------------Update------------------------#");
        String updateTpt = "cd ../%s";
        for (String common : commons) {
            System.out.println(String.format(updateTpt, common));
            System.out.println("svn update");
        }

    }
}
