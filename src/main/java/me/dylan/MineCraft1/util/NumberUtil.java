package me.dylan.MineCraft1.util;

import java.util.Random;

public class NumberUtil {
    public static final Random RNG = new Random();


    public static int rnd(int upper) {
        //static tool not tied to an object.
        return RNG.nextInt(upper);
    }

    public static boolean rnd() {
        return RNG.nextBoolean();
    }
}