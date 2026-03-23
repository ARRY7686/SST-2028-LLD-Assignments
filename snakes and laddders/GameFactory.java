public class GameFactory {
    public static GameController generateGame(int n, int players, Difficulty difficulty) {
        return new GameController(n, players, difficulty);
    }
}