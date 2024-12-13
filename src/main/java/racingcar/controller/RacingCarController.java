package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    public void run(){
        Cars cars = getCars();

        int attemptCount = getAttemptCount();
        moveCars(attemptCount, cars);

        List<String> winnerNames = cars.getWinnersName();
        String winnerString = getWinnerString(winnerNames);

        OutputView.getInstance().printWinners(winnerString);
    }

    public Cars getCars(){
        return retry(() ->{
            String input = getInput();
            return createCars(input);
        });
    }

    public String getWinnerString(List<String> winnerNames){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < winnerNames.size() ; i ++){
            sb.append(winnerNames.get(0)).append(",");
        }
        String ret = sb.toString();
        return ret.substring(0, ret.length() - 1);
    }

    public Cars createCars(String input){
        return new Cars(input);
    }

    public void moveCars(int attemptCount, Cars cars){
        while (attemptCount-- > 0) {
            cars.moveCars();
            printCurStatus(cars);
        }
    }

    public void printCurStatus(Cars cars){
        OutputView.getInstance().println(getStatusString(cars.getCars()));
    }

    public String getStatusString(List<Car> carList){
        StringBuilder sb = new StringBuilder();
        for(Car car : carList){
            sb.append(car.getName()).append(" : ").append(dashString(car.getLen())).append("\n");
        }

        return sb.append("\n").toString();
    }

    public String dashString(int len){
        String result = "";
        for(int i = 0 ; i < len ; i ++){
            result += '-';
        }
        return result;
    }

    public String getInput(){
        OutputView.getInstance().printInputPrompt();
        return InputView.getInstance().readConsoleInput();
    }

    public int getAttemptCount(){
        return retry(() -> {
            OutputView.getInstance().printAttemptCount();
            return InputView.getInstance().readConsoleInt();
        });
    }

    // 에러 발생 시 재 시도
    private static <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.getInstance().printException(e);
            }
        }
    }
}
