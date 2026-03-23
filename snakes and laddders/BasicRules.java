import java.util.Random;

public class BasicRules implements VariableRulesInterface {
    Random rand = new Random();

    public int getDiceThrow() {
        return rand.nextInt(6) + 1;
    }

    public int move(int currentPosition, int dice, Board board) {
        int next = currentPosition + dice;
        return board.applySnakesAndLadders(next);
    }
}