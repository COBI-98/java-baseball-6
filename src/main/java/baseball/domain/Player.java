package baseball.domain;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
