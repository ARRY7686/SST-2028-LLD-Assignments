public class GameController {
    int n;
    int x;
    Difficulty difficulty;

    Board board;
    TurnHandler turnHandler;
    CheckWinner checkWinner;
    Rules rules;

    public GameController(int n, int x, Difficulty difficulty) {
        this.n = n;
        this.x = x;
        this.difficulty = difficulty;

        this.board = new Board(n);
        this.rules = RulesFactory.getRules(difficulty);
        this.turnHandler = new TurnHandler(x);
        this.checkWinner = new CheckWinner();
    }

    public void startGame() {
        while (true) {
            Player player = turnHandler.nextTurn();

            int dice = rules.getDiceThrow();
            int newPosition = rules.move(player.getPosition(), dice, board);

            player.setPosition(newPosition);

            if (checkWinner.check(player, board.getSize())) {
                System.out.println(player.getName() + " wins!");
                break;
            }
        }
    }
}