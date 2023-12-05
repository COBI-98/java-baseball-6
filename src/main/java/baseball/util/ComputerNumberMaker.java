package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ComputerNumberMaker {

    private static final int MAX_NUMBER_LENGTH = 3;

    private final RandomUtils randomUtils;

    public ComputerNumberMaker(RandomUtils randomUtils) {
        this.randomUtils = randomUtils;
    }

    public String makeComputerNumber(){
        Set<Integer> numbers = new HashSet<>();

        while(numbers.size() < MAX_NUMBER_LENGTH){
            numbers.add(randomUtils.generate());
        }

        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
