package imie.tp.galactic.ws.utils;

import com.github.javafaker.Faker;
import imie.tp.galactic.ws.model.enums.UnityTypeEnum;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.general.Player;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class PlanetFaker {

    private static final String[] planets = new String[] {
            "Mercure", "Vénus", "Terre", "Mars", "Jupiter",
                    "Saturne", "Uranus", "Neptune", "Pluton"};

    private static final int MIN_X_COORD = 1;
    private static final int MAX_X_COORD = 20;
    
    private static final int MIN_Y_COORD = 1;
    private static final int MAX_Y_COORD = 20;
    
    private static final int MIN_ORB_SPACE = 15;
    private static final int MAX_ORB_SPACE = 20;
    
    private static final int MIN_GND_SPACE = 30;
    private static final int MAX_GND_SPACE = 40;
    
    private static final int MIN_AVL_IRON = 1800;
    private static final int MAX_AVL_IRON = 2200;
    
    private static final int MIN_AVL_PLUT = 1000;
    private static final int MAX_AVL_PLUT = 1200;
    
    private static final int MIN_AVL_GOLD = 1500;
    private static final int MAX_AVL_GOLD = 1700;
    
    private static final int MIN_STK_IRON = 18000;
    private static final int MAX_STK_IRON = 25000;
    
    private static final int MIN_STK_PLUT = 3000;
    private static final int MAX_STK_PLUT = 4000;
    
    private static final int MIN_STK_GOLD = 7500;
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
                new Player(fakePseudo())
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
        return FakeUtils.randomItem(planets) +
                " " +
                FakeUtils.randomInt(0, 9999);
    }

    private static String fakePseudo() {
        return faker.name().firstName().toLowerCase() +
                FakeUtils.randomInt(0, 9999);
    }

    public static Planet makePlanetWithAllGatherUnitiesAndShed() {
        Planet pr = makePlanet();
        try {
            pr.getUnities().add(UnityFaker.makeUnity(pr, UnityTypeEnum.GOLD_SHED));
            pr.getUnities().add(UnityFaker.makeUnity(pr, UnityTypeEnum.IRON_SHED));
            pr.getUnities().add(UnityFaker.makeUnity(pr, UnityTypeEnum.PLUTONIUM_SHED));

            pr.getUnities().add(UnityFaker.makeUnity(pr, UnityTypeEnum.GOLD_MINE));
            pr.getUnities().add(UnityFaker.makeUnity(pr, UnityTypeEnum.IRON_MINE));
            pr.getUnities().add(UnityFaker.makeUnity(pr, UnityTypeEnum.PLUTONIUM_FACTORY));

            pr.getUnities()
                    .forEach(u -> u.setCreationDate(LocalDateTime.now().minusDays(5)));
        } catch (ReflectiveOperationException ignored) { }

        return pr;
    }
}
