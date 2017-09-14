package imie.tp.galactic.ws.utils;

import com.github.javafaker.Faker;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.general.Player;

import java.util.ArrayList;
import java.util.Random;

public class PlanetFaker {

    private static final String[] planets = new String[] {
            "Mercure", "Vénus", "Terre", "Mars", "Jupiter",
                    "Saturne", "Uranus", "Neptune", "Pluton"};

    private static final int MIN_X_COORD = 0;
    private static final int MAX_X_COORD = 100;
    
    private static final int MIN_Y_COORD = 0;
    private static final int MAX_Y_COORD = 100;
    
    private static final int MIN_ORB_SPACE = 10;
    private static final int MAX_ORB_SPACE = 20;
    
    private static final int MIN_GND_SPACE = 25;
    private static final int MAX_GND_SPACE = 40;
    
    private static final int MIN_AVL_IRON = 4500;
    private static final int MAX_AVL_IRON = 6000;
    
    private static final int MIN_AVL_PLUT = 1800;
    private static final int MAX_AVL_PLUT = 3200;
    
    private static final int MIN_AVL_GOLD = 2500;
    private static final int MAX_AVL_GOLD = 3000;
    
    private static final int MIN_STK_IRON = 18000;
    private static final int MAX_STK_IRON = 25000;
    
    private static final int MIN_STK_PLUT = 2500;
    private static final int MAX_STK_PLUT = 4000;
    
    private static final int MIN_STK_GOLD = 6500;
    private static final int MAX_STK_GOLD = 8500;



    private static final Faker faker = new Faker();

    public static Planet makePlanet() {

        return new Planet(
                FakeUtils.randomInt(MIN_X_COORD, MAX_X_COORD),
                FakeUtils.randomInt(MIN_Y_COORD, MAX_Y_COORD),
                FakeUtils.randomInt(MIN_ORB_SPACE, MAX_ORB_SPACE),
                FakeUtils.randomInt(MIN_GND_SPACE, MAX_GND_SPACE),
                FakeUtils.randomInt(MIN_AVL_IRON, MAX_AVL_IRON),
                FakeUtils.randomInt(MIN_AVL_PLUT, MAX_AVL_PLUT),
                FakeUtils.randomInt(MIN_AVL_GOLD, MAX_AVL_GOLD),
                FakeUtils.randomInt(MIN_STK_IRON, MAX_STK_IRON),
                FakeUtils.randomInt(MIN_STK_PLUT, MAX_STK_PLUT),
                FakeUtils.randomInt(MIN_STK_GOLD, MAX_STK_GOLD),
                fakePlanetName(),
                new ArrayList<>(),
                new Player(fakePseudo(), fakeHashPass())
        );
    }



    public static Planet makePlanet(Player player) {

        return new Planet(
                FakeUtils.randomInt(MIN_X_COORD, MAX_X_COORD),
                FakeUtils.randomInt(MIN_Y_COORD, MAX_Y_COORD),
                FakeUtils.randomInt(MIN_ORB_SPACE, MAX_ORB_SPACE),
                FakeUtils.randomInt(MIN_GND_SPACE, MAX_GND_SPACE),
                FakeUtils.randomInt(MIN_AVL_IRON, MAX_AVL_IRON),
                FakeUtils.randomInt(MIN_AVL_PLUT, MAX_AVL_PLUT),
                FakeUtils.randomInt(MIN_AVL_GOLD, MAX_AVL_GOLD),
                FakeUtils.randomInt(MIN_STK_IRON, MAX_STK_IRON),
                FakeUtils.randomInt(MIN_STK_PLUT, MAX_STK_PLUT),
                FakeUtils.randomInt(MIN_STK_GOLD, MAX_STK_GOLD),
                fakePlanetName(),
                new ArrayList<>(),
                player
        );
    }

    private static String fakePlanetName() {
        return new StringBuilder()
                .append(FakeUtils.randomItem(planets))
                .append(" ")
                .append(FakeUtils.randomInt(0, 9999))
                .toString();
    }

    private static String fakePseudo() {
        return new StringBuilder()
                .append(faker.name().firstName().toLowerCase())
                .append(FakeUtils.randomInt(0, 9999))
                .toString();
    }

    private static String fakeHashPass() {
        final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!#&+-";
        int len = FakeUtils.randomInt(6, 12);
        String hash = "";

        for (int i = 0; i < len; i++) {
            hash += FakeUtils.randomChars(CHARS);
        }

        return hash;
    }
}
