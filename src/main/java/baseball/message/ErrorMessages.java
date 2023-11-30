package baseball.message;

public enum ErrorMessages {
    INVALID_INPUT_FORMAT("[ERROR] 숫자만 입력 가능합니다."),
    INVALID_INPUT_RETRY_FORMAT("[ERROR] 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

    private String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}