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

    private static final int MAX_X_COORD = 10;
    private static final int MAX_Y_COORD = 10;
    private static final int MAX_ORB_SPACE = 20;
    private static final int MAX_GND_SPACE = 40;
    private static final int MAX_AVL_IRON = 1500;
    private static final int MAX_AVL_PLUT = 600;
    private static final int MAX_AVL_GOLD = 900;
    private static final int MAX_STK_IRON = 25000;
    private static final int MAX_STK_PLUT = 4000;
    private static final int MAX_STK_GOLD = 8500;

    private static final Faker faker = new Faker();

    public static Planet makePlanet() {

        return new Planet(
                FakeUtils.randomInt(1, MAX_X_COORD),
                FakeUtils.randomInt(1, MAX_Y_COORD),
                FakeUtils.randomInt(1, MAX_ORB_SPACE),
                FakeUtils.randomInt(1, MAX_GND_SPACE),
                FakeUtils.randomInt(1, MAX_AVL_IRON),
                FakeUtils.randomInt(1, MAX_AVL_PLUT),
                FakeUtils.randomInt(1, MAX_AVL_GOLD),
                FakeUtils.randomInt(1, MAX_STK_IRON),
                FakeUtils.randomInt(1, MAX_STK_PLUT),
                FakeUtils.randomInt(1, MAX_STK_GOLD),
                fakePlanetName(),
                new ArrayList<>(),
                new Player(fakePseudo())
        );
    }

    public static Planet makePlanet(Player player) {

        return new Planet(
                FakeUtils.randomInt(1, MAX_X_COORD),
                FakeUtils.randomInt(1, MAX_Y_COORD),
                FakeUtils.randomInt(1, MAX_ORB_SPACE),
                FakeUtils.randomInt(1, MAX_GND_SPACE),
                FakeUtils.randomInt(1, MAX_AVL_IRON),
                FakeUtils.randomInt(1, MAX_AVL_PLUT),
                FakeUtils.randomInt(1, MAX_AVL_GOLD),
                FakeUtils.randomInt(1, MAX_STK_IRON),
                FakeUtils.randomInt(1, MAX_STK_PLUT),
                FakeUtils.randomInt(1, MAX_STK_GOLD),
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
}
