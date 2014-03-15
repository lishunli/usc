package org.usc.demo.guava.cache;

/**
 *
 * @author Shunli
 */
public class SupplierTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Supplier1 supplier1 = SupplierFactory.getInstance(Supplier1.class);
        System.out.println(supplier1.get());
        System.out.println(supplier1.get());
        supplier1.refresh();
        System.out.println(supplier1.get());
        System.out.println(supplier1.get());

        Supplier2 instance2 = SupplierFactory.getInstance(Supplier2.class);
        System.out.println(instance2.get());
        System.out.println(instance2.get());
        instance2.refresh();

        while (true) {
            System.out.println(instance2.get());
        }
    }
}
