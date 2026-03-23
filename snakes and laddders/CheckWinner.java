public class CheckWinner {
    public boolean check(Player player, int boardSize) {
        return player.getPosition() == boardSize;
    }
}