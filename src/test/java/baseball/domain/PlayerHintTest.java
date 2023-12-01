package baseball.domain;

import java.util.EnumMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayerHintTest {

    @DisplayName("ballAndStrikeResultHint() : 플레이어는 숫자를 입력하고 힌트를 얻을 수 있다.")
    @ParameterizedTest
    @CsvSource({"0,0,낫싱"
            , "1,0,1스트라이크", "2,0,2스트라이크"
            , "0,1,1볼", "1,1,1볼 1스트라이크"
            , "0,2,2볼", "1,2,2볼 1스트라이크"
            , "0,3,3볼", "3,0,3스트라이크"})
    void ballAndStrikeResultHint_success(int strikeCount, int ballCount, String hintResult) throws Exception {
        //given
        Map<HintResult, Integer> strikeAndBallMap = new EnumMap<>(HintResult.class);
        strikeAndBallMap.put(HintResult.STRIKE, strikeCount);
        strikeAndBallMap.put(HintResult.BALL, ballCount);

        //when
        PlayerHint playerHint = new PlayerHint(strikeAndBallMap);

        // then
        Assertions.assertThat(playerHint.getPlayerHint()).isEqualTo(hintResult);
    }
}