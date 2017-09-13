package imie.tp.galactic.ws.core;

import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.services.ModelStorageService;
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
import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryModel {

    private static final Logger logger = LoggerFactory.getLogger(InMemoryModel.class);

    private List<Planet> universe;

    private final ModelStorageService storage;

    @Autowired
    public InMemoryModel(ModelStorageService storage) {
        this.storage = storage;
    }

    @PostConstruct
    public void init() {
        this.universe =  new ArrayList<>();
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
    }

    private void loadModel() {
        try {
            this.universe = (List<Planet>) storage.load();
        } catch (RuntimeException e) {
            logger.warn("Le chargement du modèle a échoué, génération d'un nouveau modèle.");
            buildModel();
        }

    }

    private void buildModel() {
        for (int i = 0; i < FakeUtils.randomInt(4, 8); i++) {
            Planet p = PlanetFaker.makePlanet();
            universe.add(p);

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


    public List<Planet> getUniverse() {
        return universe;
    }
}
