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
    public static DBCollection getCollection(String collectionName) throws UnknownHostException, MongoException {
        Mongo m = new Mongo("localhost", 27017);

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
