package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.GameStatus;
import baseball.domain.Player;
import baseball.service.GameNumberValidateService;
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
    private static Player player;

    private final GameNumberValidateService gameNumberValidateService = new GameNumberValidateService();
    private final PlayerHintUtil playerHintUtil = new PlayerHintUtil();
    private final OutputView outputView = new OutputView();

    public GamePlayController() {
        outputView.printCreateController();
    }


    public void gameInit() {
        GameStatus gameStatus;
        player = new Player();
        do {
            computer = new Computer(new ComputerRandomGameNumber());
            play();
            gameStatus = GameStatus.findByGameCode(InputView.setRetryNumber());
        }while(gameStatus != GameStatus.FINISH);

    }

    private void play(){
        inputPlayerNumber();
        boolean gameStatus = hintResult(calculateBallAndStrikeCount(
                computer.getComputerGameNumber(), player.getPlayerNumber()));

        if (gameStatus){
            outputView.printThreeStrikeResult(THREE_STRIKE);
            return;
        }

        outputView.printNotThreeStrikeResult(playerHintUtil.getPlayerHint());
        play();
    }

    private static void inputPlayerNumber() {
        player = new Player(InputView.setPlayerNumber());
    }

    public List<Integer> calculateBallAndStrikeCount(String computerNumber, String playerNumber) {

        return gameNumberValidateService.calculateGameNumber(
                computerNumber, playerNumber);
    }

    public boolean hintResult(List<Integer> ballAndStrikeCountList) {
        playerHintUtil.ballAndStrikeResultHint(ballAndStrikeCountList);

        return ballAndStrikeCountList.get(STRIKE_INDEX) == THREE_STRIKE;
    }

}
