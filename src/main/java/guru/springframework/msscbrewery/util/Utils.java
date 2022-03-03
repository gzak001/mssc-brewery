package guru.springframework.msscbrewery.util;

import java.util.Random;

public class Utils {

    public static Long getRandomLong(){
        return new Random().nextLong();
    }
}
