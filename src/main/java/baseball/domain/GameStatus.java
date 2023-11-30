package baseball.domain;

import static baseball.message.ErrorMessages.INVALID_INPUT_RETRY_FORMAT;

import java.util.Arrays;

public enum GameStatus {
    RESTART(1),
    FINISH(2);

    private final int codeOfGame;

    GameStatus(int codeOfGame) {
        this.codeOfGame = codeOfGame;
    }

    public static GameStatus findByGameCode(int retryCode){
        return Arrays.stream(GameStatus.values())
                .filter(game -> game.hasGameCode(retryCode))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_INPUT_RETRY_FORMAT.getMessage()));
    }

    private boolean hasGameCode(int retryCode) {
        return codeOfGame == retryCode;
    }
}
