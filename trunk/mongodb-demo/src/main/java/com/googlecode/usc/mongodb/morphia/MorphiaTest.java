package com.googlecode.usc.mongodb.morphia;

import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.googlecode.usc.mongodb.DBUtils;
import com.mongodb.Mongo;

/**
 *
 * @author ShunLi
 */
public class MorphiaTest {

    public static void main(String[] args) {
        Mongo mongo = DBUtils.getMongoInstance();
        Morphia morphia = new Morphia();
        morphia.map(Hotel.class).map(Address.class);
        Datastore ds = morphia.createDatastore(mongo, "testDB");

        DBUtils.showTitle("Persisting POJOs");

        Hotel hotel = new Hotel();
        hotel.setName("My Hotel");
        hotel.setStars(4);

        Address address = new Address();
        address.setStreet("123 Some street");
        address.setCity("Some city");
        address.setPostCode("123 456");
        address.setCountry("Some country");

        // set address
        hotel.setAddress(address);

        // Save the POJO
        ds.save(hotel);

        DBUtils.showTitle("Loading a Hotel from Mongo is also simple");

        ObjectId hotelId = ds.find(Hotel.class).get().getId();// new ObjectId("4f0aae1f0654a18ad6aa76e7"); // the ID of the hotel we want to load

        // and then map it to our Hotel object
        System.out.println(ds.get(Hotel.class, hotelId));

        DBUtils.showTitle("Using a query is just as simple as loading Hotel");

        // it is easy to get four-star hotels.
        List<Hotel> fourStarHotels = ds.find(Hotel.class, "stars >=", 4).asList();
        // or
        fourStarHotels = ds.find(Hotel.class).field("stars").greaterThanOrEq(4).asList();

        System.out.println(fourStarHotels);

        DBUtils.showTitle("Data Access Object (DAO) Support");
        HotelDAO dao = new HotelDAO(morphia, mongo, "testDB");
        System.out.println(dao.find().asList());

    }
}
