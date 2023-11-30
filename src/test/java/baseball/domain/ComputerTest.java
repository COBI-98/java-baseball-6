package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import baseball.util.ComputerRandomGameNumber;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ComputerTest {

    private static final int BALL_INDEX = 0;
    private static final int STRIKE_INDEX = 1;

    @DisplayName("constructor() : 컴퓨터는 3자리의 수를 생성한다.")
    @Test
    void computer_constructor_success() throws Exception{
        //given
        Computer computer = new Computer(new ComputerRandomGameNumber(List.of(1,2,3)));

        //when //then
        assertThat(computer.getComputerGameNumber()).isEqualTo("123");
    }

    @DisplayName("calculateBallAndStrikeCount() : 컴퓨터가 사용자의 자리 수를 비교한다. (볼)")
    @ParameterizedTest
    @CsvSource({"123,0", "456,0", "345,1", "314,2", "312,3"})
    void gameNumberPlaceValidateBall(String playerNumber, int ballCount) throws Exception {
        //given
        Computer computer = new Computer(new ComputerRandomGameNumber(List.of(1, 2, 3)));
        Player player = new Player(playerNumber);
        //when
        List<Integer> ballAndStrikeList = computer.calculateBallAndStrikeCount(player);

        //then
        Assertions.assertThat(ballAndStrikeList.get(BALL_INDEX)).isEqualTo(ballCount);
    }

    @DisplayName("컴퓨터와 사용자의 자리 수를 비교해 숫자를 비교한다. (스트라이크)")
    @ParameterizedTest
    @CsvSource({"456,0", "453,1", "423,2", "123,3"})
    void gameNumberPlaceValidateStrike(String playerNumber, int strikeCount) throws Exception {
        //given
        Computer computer = new Computer(new ComputerRandomGameNumber(List.of(1, 2, 3)));
        Player player = new Player(playerNumber);
        //when
        List<Integer> ballAndStrikeList = computer.calculateBallAndStrikeCount(player);

        //then
        Assertions.assertThat(ballAndStrikeList.get(STRIKE_INDEX)).isEqualTo(strikeCount);
    }
}