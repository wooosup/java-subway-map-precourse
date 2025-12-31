package subway.controller;

import java.util.Arrays;
import java.util.function.Consumer;

public enum MainMenu {
    STATION("1", "역 관리", SubwayController::runStationMenu),
    LINE("2", "노선 관리", SubwayController::runLineMenu),
    SECTION("3", "구간 관리", SubwayController::runSectionMenu),
    SUBWAY("4", "지하철 노선도 출력", SubwayController::runSubwayList);

    private final String command;
    private final String description;
    private final Consumer<SubwayController> action;

    MainMenu(String command, String description, Consumer<SubwayController> action) {
        this.command = command;
        this.description = description;
        this.action = action;
    }

    public static void run(String input, SubwayController controller) {
        Arrays.stream(values())
                .filter(menu -> menu.command.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 선택 할 수 없는 메뉴입니다."))
                .action.accept(controller);
    }
}
