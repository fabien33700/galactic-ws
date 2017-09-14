package imie.tp.galactic.ws.jmx;

import imie.tp.galactic.ws.core.InMemoryModel;
import imie.tp.galactic.ws.model.general.Player;
import imie.tp.galactic.ws.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DebugExposer implements DebugExposerMBean {
    private final InMemoryModel inMemoryModel;
    private final LoginService loginService;

    @Autowired
    public DebugExposer(InMemoryModel inMemoryModel, LoginService loginService) {
        this.inMemoryModel = inMemoryModel;
        this.loginService = loginService;
    }

    @Override
    public void doResetModel() {
        inMemoryModel.buildModel();
    }

    @Override
    public Map<String, String> getTokenPairs() {
        Map<String, String> map = new HashMap<>();
        for (Map.Entry<String, Player> e :
                loginService.getTokenPairs().entrySet()) {
            map.put(e.getKey(), e.getValue().getPseudo());
        }
        return map;
    }

    @Override
    public Set<String> getPlayersPseudo() {
        return inMemoryModel
                .getUniverse()
                .getPlayers()
                .stream()
                .map(Player::toString)
                .collect(Collectors.toSet());
    }
}
