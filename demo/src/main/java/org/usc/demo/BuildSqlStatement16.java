package org.usc.demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author Shunli
 */
public class BuildSqlStatement16 {
    private static String tpl = "INSERT INTO `consumeserver` VALUES (null, '%s', '%s', 'lishunli', now(), '', '');";

    public static void main(String[] args) throws IOException {
        String allServer = FileUtils.readFileToString(new File("D:/New/000047.js"));

        Map<String, String> servers = new HashMap<String, String>();
        JSONArray jsonArray = JSON.parseArray(allServer);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject parseObject = JSON.parseObject(jsonArray.get(i).toString());

            String serverId = parseObject.getString("serverid");
            String serverName = parseObject.getString("servername");

            if (servers.containsKey(serverId)) {
                servers.put(serverId, servers.get(serverId) + "&" + serverName);
            } else {
                servers.put(serverId, serverName);
            }
        }

        List<String> results = new ArrayList<String>();
        for (Entry<String, String> entry : servers.entrySet()) {
            results.add(String.format(tpl, entry.getKey(), entry.getValue()));
        }

        System.out.println(servers);
        Collections.sort(results);
        System.out.println(results);

         org.apache.commons.io.FileUtils.writeLines(new File("D://servers3.sql"), results);
        System.out.println("over");
    }
}
