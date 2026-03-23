import java.util.*;

public class TurnHandler {
    private Queue<Player> players;

    public TurnHandler(int playerCount) {
        this.players = new LinkedList<>(PlayerFactory.createPlayers(playerCount));
    }

    public Player nextTurn() {
        Player current = players.poll();
        players.offer(current);
        return current;
    }
}