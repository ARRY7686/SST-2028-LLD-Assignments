import java.util.*;

public class Board {
    int n;
    Map<Integer, Integer> snakes;
    Map<Integer, Integer> ladders;

    public Board(int n) {
        this.n = n;
        this.snakes = Snakes.generate(n);
        this.ladders = Ladders.generate(n);
    }

    public int getSize() {
        return n * n;
    }

    public int applySnakesAndLadders(int position) {
        if (snakes.containsKey(position)) {
            return snakes.get(position);
        }
        if (ladders.containsKey(position)) {
            return ladders.get(position);
        }
        return position;
    }
}