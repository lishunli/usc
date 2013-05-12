package org.usc.demo.bug;
import java.util.ArrayList;
import java.util.List;

public class UsHighDemo {

    public static void main(String[] args) throws Exception {
        UsHighDemo demo = new UsHighDemo();
        demo.test();
    }

    private void test() throws Exception {
        int count = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < count; i++) {
            new Thread(new ConsumeCPUTask()).start();
        }

        for (int i = 0; i < 200; i++) {
            new Thread(new NotConsumeCPUTask()).start();
        }

    }
}

class ConsumeCPUTask implements Runnable {

    @Override
    public void run() {
        String str = "dsdajfejwklajkeuioanjfuaeskldashi3ueijaksejfriesaiefji"
                + "easfklaejfiajlj;laes'dasdaskjfadksjkdasjfkldjaskasdsda;flkasldfkdsjkljdaskfjfa'fea"
                + "adfkajeklfjkakldasjjfe#lkjaleskfas;';aefhkaiejkjekafjkejkjaefljjafjek;"
                + "dasfhejajefkljekasjaejfalejlak;";

        float i = 0.002f;
        float j = 232.13243f;

        while (true) {
            j = i * j;
            str.indexOf("#");

            List<String> list = new ArrayList<String>();
            for (int k = 0; k < 10000; k++) {
                list.add(str + String.valueOf(k));
            }
            list.contains("iii");
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

class NotConsumeCPUTask implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10000000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
