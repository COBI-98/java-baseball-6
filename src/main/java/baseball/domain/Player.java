package baseball.domain;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Player {
    private PlayerNumber playerNumber;
    private int retryNumber;
    private PlayerStatus playerStatus;

    public Player() {
        this.playerStatus = PlayerStatus.CREATE;
    }

    public Player(String playerNumber) {
        this.playerNumber = new PlayerNumber(playerNumber);
        this.playerStatus = PlayerStatus.PROCEEDING;
    }

    public Player(int retryNumber) {
        this.retryNumber = retryNumber;
    }

    public void setRetryNumber(int retryNumber) {
        this.retryNumber = retryNumber;
    }

    public int getRetryNumber() {
        return retryNumber;
    }

    public String getPlayerNumber() {
        return playerNumber.number();
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

}
