package chapter2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExerciseTest {
    @Test
    public void Test1(){
        int x = 5;
        System.out.println(x > 2 ? x < 4 ? 10 : 8 : 7);
    }

    @Test
    public void Test2(){
        byte a = 10, b = 20;
//        byte sum = (byte)a + b;

    }

    @Test
    public void Test3(){
        int x = 0;
        String s = null;
//        if (x == s) {
//            System.out.println("success");
//        }
    }

    @Test
    public void Test4(){
        do {
            int y = 1;
            System.out.println(y++ + " ");
        } while (true);
    }

    @Test
    public void Test5(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(14);
        for (Integer x : list) {
            System.out.println(x + ", ");
            break;
        }
    }

    @Test
    public void Test6(){
        for (int i = 0; i < 10; ) {
            i = i++;
            System.out.println("Hello World");
        }
    }

    @Test
    public void Test7(){
        int count = 0;
        ROW_LOOP: for(int row = 1; row <=3; row++)
            for(int col = 1; col <=2 ; col++) {
                if(row * col % 2 == 0) continue ROW_LOOP;
                count++;
            }
        System.out.println(count);
    }

    @Test
    public void Test8(){
        String str = "";
        for (int i = 0; i < 10; i++) {
            str += i + ",";
        }

        System.out.println(str);

        String str2 = "Hello world";
        for (int i = 0; i < str2.length(); i++) {
            System.out.println(str2.charAt(i));
        }
    }
}
