package org.usc.mongodb;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;

/**
 *
 * @author ShunLi
 */
public class Demo1 {
    public static void main(String[] args) throws UnknownHostException, MongoException {
        // Collection
        DBCollection coll = DBUtils.getCollection("testCollection");

        // for test,clear collection first.
        coll.drop();

        // insert
        BasicDBObject doc = new BasicDBObject();
        doc.put("name", "MongoDB");
        doc.put("type", "database");
        doc.put("count", 1);

        BasicDBObject info = new BasicDBObject();

        info.put("x", 203);
        info.put("y", 102);

        doc.put("info", info);

        coll.insert(doc);

        // select findOne
        DBObject myDoc = coll.findOne();

        DBUtils.showTitle("findOne");
        System.out.println(myDoc);

        // mutil insert
        for (int i = 0; i < 100; i++) {
            coll.insert(new BasicDBObject().append("i", i));
        }

        // counting
        DBUtils.showTitle("mutil insert");
        System.out.println(coll.getCount());

        DBUtils.showTitle("Using a Cursor to Get All the Documents");
        DBCursor cur = coll.find();

        while (cur.hasNext()) {
            System.out.println(cur.next());
        }

        DBUtils.showTitle("Getting A Single Document with A Query");
        BasicDBObject query = new BasicDBObject();

        query.put("i", 71);

        cur = coll.find(query);

        while (cur.hasNext()) {
            System.out.println(cur.next());
        }

        //
        query.clear();
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put("$ne", 30);
        criteria.put("$gt", 10);
        query.put("i", new BasicDBObject(criteria).append("$lte", 50));

        DBUtils.showTitle("Getting A Single Document with mutil Query ");
        cur = coll.find(query);

        while (cur.hasNext()) {
            System.out.println(cur.next());
        }

        DBUtils.showTitle("Getting A Set of Documents With a Query");
        query = new BasicDBObject();

        query.put("i", new BasicDBObject("$gt", 50)); // e.g. find all where i > 50

        cur = coll.find(query);

        while (cur.hasNext()) {
            System.out.println(cur.next());
        }
    }

}
