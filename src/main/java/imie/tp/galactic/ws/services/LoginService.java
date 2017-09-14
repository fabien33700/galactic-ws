package imie.tp.galactic.ws.services;

import imie.tp.galactic.ws.core.InMemoryModel;
import imie.tp.galactic.ws.exceptions.UnauthorizedException;
import imie.tp.galactic.ws.model.general.Player;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class LoginService {

    private final HashMap<String, Player> tokenPairs;
    private InMemoryModel inMemoryModel;

    @Autowired
    public LoginService(InMemoryModel inMemoryModel) {
        this.tokenPairs = new HashMap<>();
        this.inMemoryModel = inMemoryModel;
    }


    public String authenticationAttempt(String pseudo, String hashPass) {
        Set<Player> players = inMemoryModel.getUniverse().getPlayers();
        Player toConnect = players.stream()
                .filter(p ->
                        p.getPseudo().equals(pseudo) &&
                        p.getHashPass().equals(hashPass))
                .findFirst()
                .orElseThrow(UnauthorizedException::new);

        String token = generateToken(toConnect.getPseudo(), toConnect.getHashPass());
        tokenPairs.put(token, toConnect);

        return new StringBuilder()
                .append("Token=")
                .append(token)
                .toString();
    }

    private String generateToken(String pseudo, String hashPass) {
        return DigestUtils.sha1Hex(pseudo + hashPass);
    }

    /*static String mixStrings(String... strings) {
        StringBuilder result = new StringBuilder();
        Stream<String> stringStream = Arrays.stream(strings);

        Map<String, Boolean> completed = stringStream
            .distinct()
            .collect(Collectors.toMap(
                s -> s,
                s -> s.trim().length() > 0
            ));

        int i = 0;

        while (!completed
                .values()
                .stream()
                .reduce(Boolean::logicalAnd)
                .get())
        {
            for (String string : strings) {
                if (i >= string.length()) {
                    completed.put(string, true);
                } else {
                    result.append(string.substring(i, i+1));
                }

            }
            i++;
        }

        return result.toString();
    }*/

    public boolean hasToken(String token) {
        return tokenPairs.containsKey(token);
    }

    public HashMap<String, Player> getTokenPairs() {
        return tokenPairs;
    }

    public Player getRequestPlayer(HttpServletRequest req) {
        String authHeader = req.getHeader(HttpHeaders.AUTHORIZATION);

        if (authHeader != null && authHeader.length() > 0) {
            if (authHeader.contains("=")) {
                String token = authHeader.split("=")[1];
                if (tokenPairs.containsKey(token)) {
                    return tokenPairs.get(token);
                }
            }
        }

        return null;
    }
}
