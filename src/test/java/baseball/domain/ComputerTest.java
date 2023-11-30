package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import baseball.util.ComputerRandomGameNumber;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @DisplayName("constructor() : 컴퓨터는 3자리의 수를 생성한다.")
    @Test
    void computer_constructor_success() throws Exception{
        //given
        Computer computer = new Computer(new ComputerRandomGameNumber(List.of(1,2,3)));

        //when //then
        assertThat(computer.getComputerGameNumber()).isEqualTo("123");
    }
}