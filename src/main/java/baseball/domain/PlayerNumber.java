package baseball.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public record PlayerNumber(String number) {

    private static int MAX_NUMBER_COUNT = 3;
    public PlayerNumber {
        validateRangeFromNumber(number);
        validateCharacterFromNumber(number);
        validateDuplicateFromNumber(number);
    }

    public static void validateRangeFromNumber(String word) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(입력값 3자리수)");
        if (word.length() != MAX_NUMBER_COUNT) {
        }
    }

    public static void validateCharacterFromNumber(String word) {
        if (!IntStream.range(0, word.length()).
                allMatch(index -> Character.isDigit(word.charAt(index)))) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(자연수가 아닌 수가 존재합니다.)");
        }
    }

    public static void validateDuplicateFromNumber(String word) {
        Set<Character> set = IntStream.range(0, word.length())
                .mapToObj(word::charAt)
                .collect(Collectors.toSet());

        if (set.size() != word.length()) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(중복된 숫자가 존재합니다.)");
        }
    }
}
