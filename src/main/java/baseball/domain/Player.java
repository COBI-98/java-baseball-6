package baseball.domain;

public class Player {
    private PlayerNumber playerNumber;

    public Player() {
    }

    public Player(String playerNumber) {
        this.playerNumber = new PlayerNumber(playerNumber);
    }

    public String getPlayerNumber() {
        return playerNumber.number();
    }

}
