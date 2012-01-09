package com.googlecode.usc.mongodb.morphia;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;

/**
 *
 * @author ShunLi
 */
public class HotelDAO extends BasicDAO<Hotel, String> {
    public HotelDAO(Morphia morphia, Mongo mongo, String dbName) {
        super(mongo, morphia, dbName);
    }
}
