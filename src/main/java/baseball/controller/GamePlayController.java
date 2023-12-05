package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.GameStatus;
import baseball.domain.HintResult;
import baseball.domain.Player;
import baseball.domain.PlayerHint;
import baseball.util.ComputerNumberMaker;
import baseball.util.ComputerRandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.Map;

public class GamePlayController {

    private static Computer computer;
    private final InputView inputView;
    private final OutputView outputView;

    public GamePlayController() {
        inputView = new InputView();
        outputView = new OutputView();
        outputView.printCreateController();
    }

    public void startGame() {
        GameStatus gameStatus;
        do {
            ComputerNumberMaker computerNumberMaker = new ComputerNumberMaker(new ComputerRandomNumberGenerator());
            computer = new Computer(computerNumberMaker.makeComputerNumber());
            play();
            gameStatus = GameStatus.findByGameCode(inputView.inputRetryNumber());
        } while (gameStatus != GameStatus.FINISH);

    }

    private void play() {
        Player player = inputPlayerNumber();
        Map<HintResult, Integer> hintResultIntegerMap = computer.calculateBallAndStrikeCount(player);
        PlayerHint playerHint = new PlayerHint(hintResultIntegerMap);

        if (playerHint.hasHintCorrectAnswer()) {
            outputView.printThreeStrikeResult(playerHint.getPlayerHint());
            return;
        }

        outputView.printNotThreeStrikeResult(playerHint.getPlayerHint());
        play();
    }

    private Player inputPlayerNumber() {
        return new Player(inputView.inputPlayerNumber());
    }

}
