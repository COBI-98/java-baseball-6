package baseball.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerNumberTest {

    @DisplayName("constructor() :  서로 다른 3개의 숫자 생성 ")
    @Test
    void playerNumber_constructor_success() throws Exception {
        //given
        PlayerNumber playerNumber = new PlayerNumber("123");

        //when //then
        assertThat(playerNumber.number()).isEqualTo("123");
    }

    @DisplayName("validateRangeFromNumber() : 3자리 수가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "1234", " ", ""})
    void validateRangeFromNumber_fail(String playerNumber) throws Exception {
        //given parameter

        // when // then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Player(playerNumber))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("잘못된 값을 입력하셨습니다.(입력값 3자리수)")
        );
    }

    @DisplayName("validateCharacterFromNumber() : 자연수가 아닌 문자가 존재하는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"0z3", "-11", "z12", "#$#", "1 2", " 12", "   "})
    void validateCharacterFromNumber_fail(String playerNumber) throws Exception {
        //given parameter

        //when //then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Player(playerNumber))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("잘못된 값을 입력하셨습니다.(자연수가 아닌 수가 존재합니다.)")
        );
    }

    @DisplayName("validateDuplicateFromNumber() : 서로 다른 3개의 숫자가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"122", "333"})
    void validateDuplicateFromNumber_fail(String playerNumber) throws Exception {
        //given parameter

        //when //then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Player(playerNumber))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("잘못된 값을 입력하셨습니다.(중복된 숫자가 존재합니다.)")
        );
    }
}