public class Main {
    public static void main(String[] args) {
        GameController game = GameFactory.generateGame(10, 2, Difficulty.BASIC);
        game.startGame();
    }
}