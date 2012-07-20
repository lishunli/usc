package org.usc.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author ShunLi
 */
public class RandomTest {

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(10));
        System.out.println(random.nextDouble());

        Map<String,Double> rateMap = new HashMap<String, Double>() ;

//        rateMap.


        List<Double> rate = Arrays.asList(0.1, 0.2, 0.3, 0.4);



    }

}
