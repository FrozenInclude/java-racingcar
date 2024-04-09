package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Racing {
    private final List<Car> players;
    private int simulationCount;

    public Racing() {
        this.players = new ArrayList<Car>();
        this.simulationCount = 0;
    }

    public void runGame() {
        input();
        simulateRace(simulationCount);
        displayWinner();
    }

    private void input() {
        String input;
        String[] parsedInput;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        input = readLine();
        parsedInput = input.split(",");
        for (String name : parsedInput) {
            String trimmedName = name.trim();
            if (trimmedName.isEmpty() || trimmedName.length() > 5) {
                throw new IllegalArgumentException("잘못된 입력 입니다!");
            } else {
                Car player = new Car(trimmedName);
                players.add(player);
            }
        }

        System.out.println("시도할 회수는 몇회인가요?");
        try {
            simulationCount = Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력 입니다!");
        }
    }

    private void simulateRace(int n) {
        while (n-- > 0) {
            for (Car arr : players) {
                arr.move();
                System.out.println(arr.toString());
            }
        }
    }

    private void displayWinner() {
        System.out.print("최종 우승자 : ");

        List<String> winnerNames = getWinnerNames();
        for (int i = 0; i < winnerNames.size(); i++) {
            System.out.print(winnerNames.get(i));
            if (i == winnerNames.size() - 1) {
                System.out.println();
            } else {
                System.out.print(", ");
            }
        }
    }

    private List<String> getWinnerNames() {
        int bestMove = players.stream()
                .mapToInt(Car::getMovement)
                .max().getAsInt();

        return players.stream()
                .filter(car -> car.getMovement() == bestMove)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
