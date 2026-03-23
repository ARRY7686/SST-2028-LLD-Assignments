import java.util.Random;

public class AdvancedRules implements VariableRulesInterface {
    Random rand = new Random();

    public int getDiceThrow() {
        int val = rand.nextInt(6) + 1;
        if (val == 6) return val * 2; // bonus
        return val;
    }

    public int move(int currentPosition, int dice, Board board) {
        int next = currentPosition + dice;

        // example: capture rule (send back if collision)
        if (next > board.getSize()) {
            return currentPosition;
        }

        return board.applySnakesAndLadders(next);
    }
}