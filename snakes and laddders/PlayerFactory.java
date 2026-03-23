import java.util.*;

public class PlayerFactory {
    public static List<Player> createPlayers(int count) {
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            players.add(new Player("Player " + i));
        }
        return players;
    }
}