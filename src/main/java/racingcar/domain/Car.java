package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private int len = 0;
    private String name;

    public Car(String name){
        validateName(name);
        this.name = name;
    }
    public void move(){
        int rand = Randoms.pickNumberInRange(0, 9);
        if(rand >= 4){
            len ++;
        }
    }

    public void validateName(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException("이름의 길이는 5자 이하여야 합니다.");
        }
    }

    public int getLen() {
        return len;
    }

    public String getName() {
        return name;
    }
}
