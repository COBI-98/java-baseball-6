package baseball.domain;

public enum HintResult {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOT_THING("낫싱");

    private String title;

    HintResult(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
