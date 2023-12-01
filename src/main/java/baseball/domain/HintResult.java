package baseball.domain;

import java.util.Arrays;

public enum HintResult {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOT_THING("낫싱");

    private String title;

    HintResult(String title) {
        this.title = title;
    }

    public static HintResult findByHintResult(String title){

        return Arrays.stream(HintResult.values())
                .filter(hintResult -> hintResult.hasTitle(title))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하지않는 형식"));
    }

    private boolean hasTitle(String hintTitle) {
        return title.equals(hintTitle);
    }

    public String getTitle() {
        return title;
    }
}
