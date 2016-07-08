package chapter3;

import org.junit.Test;

import java.util.ArrayList;

public class CoreJavaApis {
    @Test
    public void Test(){
        ArrayList list = new ArrayList();

        list.add("along");
        list.add(Boolean.TRUE);

        ArrayList<String> birds = new ArrayList<String>();
        birds.add("hawk");
        System.out.println(birds.size());
        birds.set(0, "robin");
        System.out.println(birds);
        birds.set(1, "robin");


        System.out.println(list);
    }
}
