package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {
    private  final  String name;
    private int movement;

    public  Car(String name){
        this.name = name;
        this.movement = 0;
    }

    @Override
    public String toString() {
        return name+" : "+"-".repeat(movement);
    }
    public void move(){
        if(pickNumberInRange(0,9) >= 4){
            movement++;
        }
    }
    public int getMovement(){
        return movement;
    }
    public String getName(){
        return name;
    }
}
