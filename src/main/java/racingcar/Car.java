package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {
    private int movement=0;
    public String name;

    public void move(){
        int rnum=pickNumberInRange(0,9);
        if(rnum>4)movement++;
    }
    public void print_move(){
        int loop=movement;
        System.out.print(name+" : ");
        while (loop-->0)
            System.out.print('-');
        System.out.println();
    }
}
