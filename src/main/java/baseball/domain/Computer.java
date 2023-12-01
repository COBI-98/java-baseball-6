package baseball.domain;

import baseball.util.ComputerRandomGameNumber;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

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


    public Map<HintResult, Integer> calculateBallAndStrikeCount(Player player) {
        Map<HintResult, Integer> ballAndStrikeResultMap = new EnumMap<>(HintResult.class);
        int ballIndex = calculateBallCount(computerGameNumber, player.getPlayerNumber());
        int strikeIndex = calculateStrikeCount(computerGameNumber, player.getPlayerNumber());
        ballAndStrikeResultMap.put(HintResult.BALL, ballIndex);
        ballAndStrikeResultMap.put(HintResult.STRIKE, strikeIndex);

        return ballAndStrikeResultMap;
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