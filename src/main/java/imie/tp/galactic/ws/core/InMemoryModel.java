package imie.tp.galactic.ws.core;

import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.general.Player;
import imie.tp.galactic.ws.services.game.ModelStorageService;
import imie.tp.galactic.ws.utils.FakeUtils;
import imie.tp.galactic.ws.utils.PlanetFaker;
import imie.tp.galactic.ws.utils.UnityFaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class InMemoryModel {

    private static final Logger logger = LoggerFactory.getLogger(InMemoryModel.class);

    private Universe universe;

    private GameLoopThread thread;

    private final ModelStorageService storage;

    @Autowired
    public InMemoryModel(ModelStorageService storage) {
        this.storage = storage;
    }


    @PostConstruct
    public void init() {
        this.universe =  new Universe();
        final Path path = Paths.get("model.ser");

        boolean exists = false;
        try {
            exists = Files.exists(path) && Files.size(path) > 0;
        } catch (IOException ignored) {}

        if (!exists) {
            logger.warn("Aucun modèle trouvé : génération d'un nouveau modèle");
            buildModel();
        } else {
            loadModel();
        }
        buildModel();

        thread = new GameLoopThread(this);
        thread.start();
    }

    private void loadModel() {
        try {
            this.universe = (Universe) storage.load();
        } catch (RuntimeException e) {
            logger.warn("Le chargement du modèle a échoué, génération d'un nouveau modèle.");
            buildModel();
        }

        logger.info("Chargement du modèle OK");


    }

    private void buildModel() {
        universe.getPlanets().add(PlanetFaker.makePlanetWithAllGatherUnitiesAndShed());

       for (int i = 0; i < FakeUtils.randomInt(1, 4); i++) {
            Planet p = PlanetFaker.makePlanet();
            Player o = p.getOwner();
            o.getPlanets().add(p);
            universe.getPlanets().add(p);
            universe.getPlayers().add(o);

            for (int j = 0; j < FakeUtils.randomInt(3, 6); j++) {
                try {
                    p.getUnities().add(UnityFaker.makeUnity(p));
                } catch (ReflectiveOperationException e) {
                    logger.warn("Erreur création d'unité", e);
                }
            }
        }

        saveModel();
    }

    public void saveModel() {
        storage.save(getUniverse());
    }


    public Universe getUniverse() {
        return universe;
    }

}
