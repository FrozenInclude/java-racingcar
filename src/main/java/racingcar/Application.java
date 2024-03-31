package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input=readLine();

        String[] parsed=input.split(",");
        Car[] carlist=new Car[parsed.length];

        for (int i = 0; i < parsed.length; i++) {
            carlist[i]=new Car();
            String name=parsed[i].trim();
            if(name.isEmpty()||name.length()>5)throw new IllegalArgumentException("잘못된 입력 입니다!");
            else carlist[i].name = parsed[i];
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int n;
        try {
            n = Integer.parseInt(readLine());
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력 입니다!");
        }

        System.out.println("\n실행 결과");

        while(n-->0){
            for(Car arr:carlist)
            {
                arr.move();
                arr.print_move();
            }
            System.out.println();
        }
    }
}
