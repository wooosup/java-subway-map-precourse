package subway.controller;

import java.util.List;
import subway.domain.Line;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {

    private final InputView inputView;
    private final OutputView outputView;

    public SubwayController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        while (true) {
            try {
                outputView.printMain();
                String input = inputView.readFunction();
                if ("Q".equals(input)) break;

                MainMenu.run(input, this);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    public void runStationMenu() {
        outputView.printStationManage();
        String input = inputView.readFunction();

        StationMenu.run(input, this);
    }

    public void runLineMenu() {
        outputView.printLineManage();
        String input = inputView.readFunction();

        LineMenu.run(input, this);
    }

    public void runSectionMenu() {
        outputView.printSectionsManage();
        String input = inputView.readFunction();

        SectionMenu.run(input, this);
    }

    public void runSubwayList() {
//        List<Line> lines = lineService.findAll();
//        outputView.subwayList(lines);
    }

    public void registerStation() {
        String name = inputView.inputStationName();
//        stationService.addStation(name);
//        outputView.printInfo("지하철 역이 등록되었습니다.");
    }

    public void deleteStation() {
        String name = inputView.inputStationName();
//        stationService.deleteStation(name);
//        outputView.printInfo("지하철 역이 삭제되었습니다.");
    }

    public void searchStations() {
//        List<Station> stations = stationService.findAllStationNames();
//        outputView.printStations(stations);
    }

    // 1. 노선 관련 메서드
    public void registerLine() {
        // 노선 등록 로직...
    }
    public void deleteLine() {
        // 노선 삭제 로직...
    }
    public void searchLines() {
        // 노선 조회 로직...
    }

    // 2. 구간 관련 메서드
    public void registerSection() {
        // 구간 등록 로직...
    }
    public void deleteSection() {
        // 구간 삭제 로직...
    }

    public void goBack() {
        return;
    }

}
