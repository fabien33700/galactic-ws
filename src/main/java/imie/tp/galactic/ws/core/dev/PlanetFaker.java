package imie.tp.galactic.ws.core.dev;

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

    private static final Random rd = new Random();
    private static final Faker faker = new Faker();

    public static Planet makePlanet() {

        return new Planet(
            rd.nextInt(MAX_X_COORD - 1) + 1,
            rd.nextInt(MAX_X_COORD - 1) + 1,
            rd.nextInt(MAX_ORB_SPACE - 1) + 1,
            rd.nextInt(MAX_GND_SPACE - 1) + 1,
            rd.nextInt(MAX_AVL_IRON - 1) + 1,
            rd.nextInt(MAX_AVL_PLUT - 1) + 1,
            rd.nextInt(MAX_AVL_GOLD - 1) + 1,
            rd.nextInt(MAX_STK_IRON - 1) + 1,
            rd.nextInt(MAX_STK_PLUT - 1) + 1,
            rd.nextInt(MAX_STK_GOLD - 1) + 1,
            fakePlanetName(),
            new ArrayList<>(),
            new Player(fakePseudo())
        );
    }

    private static String fakePlanetName() {
        return planets[rd.nextInt(planets.length-1)] + " " + rd.nextInt(9999);
    }

    private static String fakePseudo() {
        return faker.name().firstName().toLowerCase() + rd.nextInt(9999);
    }
}
