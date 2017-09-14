package imie.tp.galactic.ws.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class FakeUtils {
    private static final Random rd = new Random();

    public static int randomInt(int min, int max) {
        return rd.nextInt(max - min) + min;
    }

    public static <T> T randomItem(T[] source) {
        return source[rd.nextInt(source.length-1)];
    }

    public static <T> T randomItem(Collection<T> source) {
        ArrayList<T> ordered = new ArrayList<>(source);
        return ordered.get(rd.nextInt(ordered.size()-1));
    }

    public static String randomChars(String chars) {
        return "" + chars.charAt(rd.nextInt(chars.length() - 1));
    }
}
