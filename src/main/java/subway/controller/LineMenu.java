package subway.controller;

import java.util.Arrays;
import java.util.function.Consumer;

public enum LineMenu {
    REGISTER("1", "노선 등록", SubwayController::registerLine),
    DELETE("2", "노선 삭제", SubwayController::deleteLine),
    SEARCH("3", "노선 조회", SubwayController::searchLines),
    BACK("B", "돌아가기", SubwayController::goBack);

    private final String command;
    private final String description;
    private final Consumer<SubwayController> action;

    LineMenu(String command, String description, Consumer<SubwayController> action) {
        this.command = command;
        this.description = description;
        this.action = action;
    }

    public static void run(String input, SubwayController controller) {
        Arrays.stream(values())
                .filter(menu -> menu.command.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다."))
                .action.accept(controller);
    }
}