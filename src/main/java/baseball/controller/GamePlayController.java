package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.GameStatus;
import baseball.domain.Player;
import baseball.util.ComputerRandomGameNumber;
import baseball.util.PlayerHintUtil;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GamePlayController {

    private static final int STRIKE_INDEX = 1;
    private static final int THREE_STRIKE = 3;
    private static final String STRIKE = "스트라이크";

    private static Computer computer;
    private final PlayerHintUtil playerHintUtil = new PlayerHintUtil();
    private final OutputView outputView = new OutputView();

    public GamePlayController() {
        outputView.printCreateController();
    }

    public void startGame() {
        GameStatus gameStatus;
        do {
            computer = new Computer(new ComputerRandomGameNumber());
            play();
            gameStatus = GameStatus.findByGameCode(InputView.inputRetryNumber());
        }while(gameStatus != GameStatus.FINISH);

    }

    private void play(){
        Player player = inputPlayerNumber();
        boolean gameStatus = hintResult(computer.calculateBallAndStrikeCount(player));

        if (gameStatus){
            outputView.printThreeStrikeResult(THREE_STRIKE);
            return;
        }

        outputView.printNotThreeStrikeResult(playerHintUtil.getPlayerHint());
        play();
    }

    private static Player inputPlayerNumber() {
        return new Player(InputView.inputPlayerNumber());
    }

    public boolean hintResult(List<Integer> ballAndStrikeCountList) {
        playerHintUtil.ballAndStrikeResultHint(ballAndStrikeCountList);

        return ballAndStrikeCountList.get(STRIKE_INDEX) == THREE_STRIKE;
    }

}
