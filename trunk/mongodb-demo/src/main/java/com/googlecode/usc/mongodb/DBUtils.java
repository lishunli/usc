package com.googlecode.usc.mongodb;

import java.net.UnknownHostException;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 *
 * @author ShunLi
 */
public class DBUtils {
    public static Mongo getMongoInstance() {
        Mongo m = null;
        try {
            m = new Mongo();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return m;
    }

    public static DBCollection getCollection(String collectionName) {
        Mongo m = getMongoInstance();

        DB db = m.getDB("mydb");

        // show collections
        Set<String> colls = db.getCollectionNames();

        for (String s : colls) {
            System.out.println(s);
        }

        // collection
        DBCollection coll = db.getCollection(collectionName);

        return coll;
    }

    public static void showTitle(String title) {
        System.out.println(StringUtils.center(" " + title + " ", 80, "="));
    }

}
