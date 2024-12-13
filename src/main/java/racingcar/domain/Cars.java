package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();
    public Cars(String input){
        String[] names = input.split(",");
        createCars(names);
    }

    public void createCars(String[] names){
        for(String name : names){
            cars.add(new Car(name));
        }
    }

    public void moveCars(){
        for(Car car : cars){
            car.move();
        }
    }

    public List<String> getWinnersName(){
        int maxLen = Integer.MIN_VALUE;
        List<String> winnerNameList = new ArrayList<>();
        for(Car car : cars){
            if(car.getLen() > maxLen){
                winnerNameList.clear();
                winnerNameList.add(car.getName());
                maxLen = car.getLen();
            }
            else if(car.getLen() == maxLen){
                winnerNameList.add(car.getName());
            }
        }

        return winnerNameList;
    }
    public List<Car> getCars() {
        return cars;
    }

}
