package baseball.domain;

import baseball.util.ComputerRandomGameNumber;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Computer {

    private static final int NUMBER_LENGTH = 3;

    private String computerGameNumber;

    public Computer() {
    }

    public Computer(ComputerRandomGameNumber computerRandomGameNumber) {
        this.computerGameNumber = computerRandomGameNumber.getComputerGameNumber();
    }

    public String getComputerGameNumber() {
        return computerGameNumber;
    }


    public List<Integer> calculateBallAndStrikeCount(Player player) {
        List<Integer> ballAndStrikeCountList = new ArrayList<>();
        int ballIndex = calculateBallCount(computerGameNumber, player.getPlayerNumber());
        int strikeIndex = calculateStrikeCount(computerGameNumber, player.getPlayerNumber());
        ballAndStrikeCountList.add(ballIndex);
        ballAndStrikeCountList.add(strikeIndex);

        return ballAndStrikeCountList;
    }

    private int calculateBallCount(String computerNumber, String playerNumber) {
        int ballCount = 0;
        for (int computerPlace = 0; computerPlace < NUMBER_LENGTH; computerPlace++) {
            if (isBallCheck(computerNumber.charAt(computerPlace), computerPlace, playerNumber)){
                ballCount++;
            }
        }

        return ballCount;
    }

    private boolean isBallCheck(char computerPlaceNumber, int computerPlace, String playerNumber) {
        for (int playerPlace = 0; playerPlace < NUMBER_LENGTH; playerPlace++) {
            if (computerPlaceNumber == playerNumber.charAt(playerPlace) && computerPlace != playerPlace) {
                return true;
            }
        }
        return false;
    }

    private int calculateStrikeCount(String computerGameNumber, String playerNumber) {
        int strikeCount = 0;
        for (int place = 0; place < NUMBER_LENGTH; place++) {
            if (isStrikeCheck(computerGameNumber.charAt(place), playerNumber.charAt(place))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private boolean isStrikeCheck(char computerPlaceNumber, char playerPlaceNumber) {
        return computerPlaceNumber == playerPlaceNumber;
    }
}