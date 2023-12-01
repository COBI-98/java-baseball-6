package baseball.domain;

import static baseball.message.ErrorMessages.INVALID_DUPLICATION_NUMBER;
import static baseball.message.ErrorMessages.INVALID_NUMBER_FORMAT;
import static baseball.message.ErrorMessages.INVALID_NUMBER_RANGE;

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
        if (word.length() != MAX_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }

    public static void validateCharacterFromNumber(String word) {
        if (!IntStream.range(0, word.length()).
                allMatch(index -> Character.isDigit(word.charAt(index)))) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    public static void validateDuplicateFromNumber(String word) {
        Set<Character> set = IntStream.range(0, word.length())
                .mapToObj(word::charAt)
                .collect(Collectors.toSet());

        if (set.size() != word.length()) {
            throw new IllegalArgumentException(INVALID_DUPLICATION_NUMBER.getMessage());
        }
    }
}
