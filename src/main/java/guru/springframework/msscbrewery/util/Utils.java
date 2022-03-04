package guru.springframework.msscbrewery.util;

import java.util.Random;

public class Utils {

    public static Long getRandomLong(){

         return (long) new Random().nextInt(10000);
    }



    public static void main(String[] args){

        System.out.println("Random Longs: "+ Utils.getRandomLong());

    }


}
