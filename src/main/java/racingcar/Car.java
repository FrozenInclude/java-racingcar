package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {
    private int movement=0;
    public String name;

    @Override
    public String toString() {
        return name+" : "+"-".repeat(movement)+"\n";
    }
    public void move(){
        int rnum=pickNumberInRange(0,9);
        if(rnum>=4)movement++;
    }
    public int getMovement(){
        return movement;
    }
}
