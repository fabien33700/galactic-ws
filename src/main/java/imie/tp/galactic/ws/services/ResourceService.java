package imie.tp.galactic.ws.services;

import imie.tp.galactic.ws.core.InMemoryModel;

public interface ResourceService {
    default void save() {
        getModel().saveModel();
    }

    InMemoryModel getModel();
}
