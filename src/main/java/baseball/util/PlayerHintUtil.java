package baseball.util;

import java.util.List;

public class PlayerHintUtil {

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOT_THING = "낫싱";
    private static final String SPACING = " ";
    private static final int BALL_INDEX = 0;
    private static final int STRIKE_INDEX = 1;
    private static final int THREE = 3;

    private static String playerHint;

    public PlayerHintUtil(List<Integer> ballAndStrikeCount) {
        this.playerHint = ballAndStrikeResultHint(ballAndStrikeCount);
    }

    public String ballAndStrikeResultHint(List<Integer> ballAndStrikeCount) {
        int ballCount = ballAndStrikeCount.get(BALL_INDEX);
        int strikeCount = ballAndStrikeCount.get(STRIKE_INDEX);

        if (ballCount == 0 && strikeCount == 0) {
            return NOT_THING;
        }
        if (ballCount == 0 && strikeCount != 0) {
            return strikeCount + STRIKE;
        }
        if (ballCount != 0 && strikeCount == 0) {
            return ballCount + BALL;
        }

        return ballCount + BALL + SPACING + strikeCount + STRIKE;
    }

    public boolean hasHintCorrectAnswer(){
        return playerHint.equals(THREE + STRIKE);
    }

    public static String getPlayerHint() {
        return playerHint;
    }

}
