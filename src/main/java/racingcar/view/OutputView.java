package racingcar.view;

public class OutputView {
    private static final String EXCEPTION_PREFIX = "[ERROR] ";
    private static final String INPUT_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT = "시도할 횟수는 몇 회인가요?";
    private static final String WINNER_PROMPT_FORMAT = "최종 우승자 : %s\n";
    private static OutputView instance;

    private OutputView() {
    }

    public static synchronized OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void println(String string){
        System.out.println(string);
    }

    public void printException(Exception e){
        System.out.println(EXCEPTION_PREFIX + e.getMessage());
    }

    public void printInputPrompt(){
        System.out.println(INPUT_PROMPT);
    }

    public void printAttemptCount(){
        System.out.println(ATTEMPT_COUNT);
    }

    public void printWinners(String winnerString){
        System.out.printf(WINNER_PROMPT_FORMAT, winnerString);
    }
}


