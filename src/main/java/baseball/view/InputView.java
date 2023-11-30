package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String setPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static int setRetryNumber() {
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
