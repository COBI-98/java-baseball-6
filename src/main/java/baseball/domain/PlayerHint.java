package baseball.domain;

import static baseball.domain.HintResult.BALL;
import static baseball.domain.HintResult.NOT_THING;
import static baseball.domain.HintResult.STRIKE;

import java.util.Map;

public class PlayerHint {

    private static final String SPACING = " ";
    private static final int THREE = 3;
    private static String playerHint;

    public PlayerHint(Map<HintResult, Integer> ballAndStrikeMap) {
        this.playerHint = ballAndStrikeResultHint(ballAndStrikeMap);
    }

    public String ballAndStrikeResultHint(Map<HintResult, Integer> ballAndStrikeMap) {
        Integer ballCount = ballAndStrikeMap.get(HintResult.BALL);
        Integer strikeCount = ballAndStrikeMap.get(STRIKE);

        if (ballCount == 0 && strikeCount == 0) {
            return NOT_THING.getTitle();
        }
        if (ballCount == 0 && strikeCount != 0) {
            return strikeCount + STRIKE.getTitle();
        }
        if (ballCount != 0 && strikeCount == 0) {
            return ballCount + BALL.getTitle();
        }

        return ballCount + BALL.getTitle() + SPACING + strikeCount + STRIKE.getTitle();
    }

    public boolean hasHintCorrectAnswer() {
        return playerHint.equals(THREE + STRIKE.getTitle());
    }

    public static String getPlayerHint() {
        return playerHint;
    }
}
