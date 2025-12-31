package subway.controller;

import java.util.Arrays;
import java.util.function.Consumer;

public enum StationMenu {
    REGISTER("1", "역 등록", SubwayController::registerStation),
    DELETE("2", "역 삭제", SubwayController::deleteStation),
    SEARCH("3", "역 조회", SubwayController::searchStations),
    BACK("B", "돌아가기", SubwayController::goBack);

    private final String command;
    private final String description;
    private final Consumer<SubwayController> action;

    StationMenu(String command, String description, Consumer<SubwayController> action) {
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
