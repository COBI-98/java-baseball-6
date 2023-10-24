package baseball.domain;

import baseball.util.ComputerRandomGameNumber;

public class Computer {

    private String computerGameNumber;

    public Computer(ComputerRandomGameNumber computerRandomGameNumber) {

        this.computerGameNumber = computerRandomGameNumber.getComputerGameNumber();
    }

    public String getComputerGameNumber() {
        return computerGameNumber;
    }
}