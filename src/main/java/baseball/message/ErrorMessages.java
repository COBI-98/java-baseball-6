package baseball.message;

public enum ErrorMessages {
    INVALID_INPUT_FORMAT("[ERROR] 숫자만 입력 가능합니다."),
    INVALID_INPUT_RETRY_FORMAT("[ERROR] 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요"),
    INVALID_NUMBER_RANGE("잘못된 값을 입력하셨습니다.(입력값 3자리수)"),
    INVALID_NUMBER_FORMAT("잘못된 값을 입력하셨습니다.(자연수가 아닌 수가 존재합니다.)"),
    INVALID_DUPLICATION_NUMBER("잘못된 값을 입력하셨습니다.(중복된 숫자가 존재합니다.)") ;

    private String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}