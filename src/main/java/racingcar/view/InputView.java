package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static InputView instance;

    private InputView() {
    }

    public static synchronized InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public String readConsoleInput() {
        return Console.readLine();
    }

    public int readConsoleInt(){
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

}
