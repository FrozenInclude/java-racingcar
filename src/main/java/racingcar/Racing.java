package racingcar;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Racing {
    private List<Car> players;
    private int simulationCount;

    public void runGame(){
        input();
        simulation(simulationCount);
        displayWinner();
    }
    private  void input(){
        String input;
        String[] parsed;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        input=readLine();
        parsed=input.split(",");
        for(int i = 0; i < parsed.length; i++) {
            String name=parsed[i].trim();
            if(name.isEmpty()||name.length()>5){
                throw new IllegalArgumentException("잘못된 입력 입니다!");
            }
            else{
                Car player=new Car(name);
                players.add(player);
            }
        }

        System.out.println("시도할 회수는 몇회인가요?");
        try {
            simulationCount = Integer.parseInt(readLine());
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력 입니다!");
        }
    }
    private void simulation(int n) {
        while (n-- > 0) {
            for (Car arr : players) {
                arr.move();
                System.out.println(arr.toString());
            }
        }
    }
    private void displayWinner(){
        List<String> winnerNames = getWinnerNames();

        System.out.print("최종 우승자 : ");
        for(int i=0;i<winnerNames.size();i++){
            System.out.print(winnerNames.get(i));
            if(i==winnerNames.size()-1){
                System.out.println();
            }
            else{
                System.out.print(", ");
            }
        }
    }
    private List<String> getWinnerNames() {
        List<String> winnerNames = new ArrayList<String>();
        int best_move = -1;

        for (Car i : players) {
            if (i.getMovement() >= best_move) {
                if (!(i.getMovement() == best_move)){
                    winnerNames.clear();
                }
                winnerNames.add(i.getName());
                best_move = i.getMovement();
            }
        }
        return  winnerNames;
    }
}
