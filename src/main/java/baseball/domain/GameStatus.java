package baseball.domain;

public enum GameStatus {
    CREATE(0),
    PROCEEDING(1),
    END(2);

    private final int codeOfGame;

    GameStatus(int codeOfGame) {
        this.codeOfGame = codeOfGame;
    }
}
