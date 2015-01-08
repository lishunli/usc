package org.usc.demo;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.base.Function;
import com.google.common.collect.Ordering;

/**
 *
 * @author Shunli
 */
public class FetchSevers {
    public static final ResponseHandler<String> UTF8_CONTENT_HANDLER = new ResponseHandler<String>() {
        @Override
        public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
            final StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() >= 300) {
                throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
            }

            final HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity, "UTF-8");
            }

            return StringUtils.EMPTY;
        }
    };

    public static void main(String[] args) throws Exception {
        String url = "http://mygame.xunlei.com/jsdata/gameservers/netgame/000047.js";
        String json = Request.Get(url).execute().handleResponse(UTF8_CONTENT_HANDLER);
        json = StringUtils.removeStart(json, "var webgameSingleGameServers=");

        List<Server> servers = JSON.parseArray(json, Server.class);
        for (Server server : Ordering.usingToString().sortedCopy(servers)) {
            System.out.println(server);
        }

        System.out.println("\n" + StringUtils.repeat("=", 40) + "\n");

        List<Server> sortedCopy = Ordering.natural().onResultOf(new Function<Server, String>() {
            public String apply(Server server) {
                return StringUtils.substring(server.getServerName(), 4);
            }
        }).sortedCopy(servers);

        for (Server server : sortedCopy) {
            System.out.println(server);
        }
    }
}

class Server {
    @JSONField(name = "serverid")
    private String serverId;

    @JSONField(name = "servername")
    private String serverName;

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
