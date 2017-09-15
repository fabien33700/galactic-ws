package imie.tp.galactic.ws.services.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class ModelStorageService {

    private Logger logger = LoggerFactory.getLogger(ModelStorageService.class);

    public void save(Object model) {

        try (FileOutputStream file = new FileOutputStream("model.ser");
             ObjectOutputStream oos = new ObjectOutputStream(file)) {
            oos.writeObject(model);
            oos.flush();
        } catch (final java.io.IOException e) {
            logger.error("Erreur sérialisation : ", e);
        }
    }

    public Object load() throws RuntimeException {
        logger.info("Chargement du modèle ...");
        Object model;
        try (FileInputStream file = new FileInputStream("model.ser");
             ObjectInputStream ois = new ObjectInputStream(file)) {
            model = ois.readObject();
        } catch (final IOException | ClassNotFoundException e) {
            logger.error("Erreur chargement modèle : ", e.getMessage());
            throw new RuntimeException("Erreur lors du chargement du modèle" + e.getMessage());
        }
        return model;
    }
}
