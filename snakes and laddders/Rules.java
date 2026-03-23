public class Rules {
    VariableRulesInterface rule;

    public Rules(VariableRulesInterface rule) {
        this.rule = rule;
    }

    public int getDiceThrow() {
        return rule.getDiceThrow();
    }

    public int move(int current, int dice, Board board) {
        int next = current + dice;
        next = board.applySnakesAndLadders(next);
        return next;
    }
}