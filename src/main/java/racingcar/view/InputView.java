package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String userInput = Console.readLine();

        String[] carNames = userInput.split(",");

        if (!validateCarName(carNames)) {
            throw new IllegalArgumentException("입력된 자동차 이름이 올바르지 않습니다.");
        }

        return carNames;
    }

    public int getMoveCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        String userInput = Console.readLine();
        if (!validateMoveCountString(userInput)) {
            throw new IllegalArgumentException("이동 횟수 입력이 올바르지 않습니다.");
        }

        return Integer.parseInt(userInput);
    }

    private boolean validateMoveCountString(String userInput) {
        if (userInput.isBlank() || !userInput.matches("\\d+")) {
            return false;
        }
        return true;
    }


    private boolean validateCarName(String[] carNames) {
        for (String carName : carNames) {
            if (carName.isBlank() || carName.length() > 5) {
                return false;
            }
        }

        return true;
    }
}
