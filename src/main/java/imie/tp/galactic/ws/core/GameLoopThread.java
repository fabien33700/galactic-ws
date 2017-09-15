package imie.tp.galactic.ws.core;

import imie.tp.galactic.ws.model.constants.GameConstants;
import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.general.Unity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameLoopThread extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(GameLoopThread.class);
    private static final long UPDATE_DELAY = GameConstants.REFRESH_DELAY;

    private final InMemoryModel inMemoryModel;

    public GameLoopThread(InMemoryModel inMemoryModel) {
        super();
        this.inMemoryModel = inMemoryModel;
        logger.info("Thread de jeu principal initialisé.");
    }

    @Override
    public void run() {
        try {
            for(;;) {
                Thread.sleep(UPDATE_DELAY);
                processUniverse();
                inMemoryModel.saveModel();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start() {
        long timeOffset = System.currentTimeMillis() -
                inMemoryModel.getUniverse().getLastTimestamp();
        long tickOffset = timeOffset / UPDATE_DELAY;
        processUniverse(tickOffset);
        super.start();

    }

    private void processUniverse() {
        processUniverse(1);
    }

    private synchronized void processUniverse(long offset) {
        float ratio = (float) offset * (float) UPDATE_DELAY / (float) (60 * 1000);

        inMemoryModel.getUniverse().tick(ratio);

        for (Planet planet : inMemoryModel.getUniverse().getPlanets()) {
            for (Unity unity : planet.getUnities()) {
                if (unity instanceof GameLoopComponent) {
                    ((GameLoopComponent) unity).tick(ratio);
                }
            }
        }

    }
}
