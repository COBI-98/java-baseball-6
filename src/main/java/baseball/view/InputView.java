package baseball.view;

import static baseball.message.ErrorMessages.INVALID_INPUT_FORMAT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_GAME_NUMBER = "숫자를 입력해주세요 : ";

    public String inputPlayerNumber() {
        System.out.print(INPUT_GAME_NUMBER);
        return Console.readLine();
    }

    public int inputRetryNumber() {
        String inputRetryNumber = Console.readLine();
        return convertToInt(inputRetryNumber);
    }

    private static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT.getMessage());
        }
    }
}
