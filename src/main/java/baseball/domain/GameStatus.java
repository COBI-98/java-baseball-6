package baseball.domain;

import baseball.util.ComputerRandomGameNumber;
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
                .orElseThrow(() -> new IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요"));
    }

    private boolean hasGameCode(int retryCode) {
        return codeOfGame == retryCode;
    }
}
