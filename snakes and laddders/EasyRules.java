public class EasyRules implements VariableRulesInterface {

    public int getDiceThrow() {
        return 6; // always favorable
    }

    public int move(int currentPosition, int dice, Board board) {
        int next = currentPosition + dice;
        return board.applySnakesAndLadders(next);
    }
}