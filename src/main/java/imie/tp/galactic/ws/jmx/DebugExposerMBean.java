package imie.tp.galactic.ws.jmx;

import java.util.Map;
import java.util.Set;

public interface DebugExposerMBean {
    void doResetModel();
    Map<String, String> getTokenPairs();
    Set<String> getPlayersPseudo();
}
