package subway.controller;

import java.util.List;
import subway.domain.Line;
import subway.domain.Station;
import subway.service.LineService;
import subway.service.SectionService;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {

    private final InputView inputView;
    private final OutputView outputView;
    private final StationService stationService;
    private final LineService lineService;
    private final SectionService sectionService;

    public SubwayController(InputView inputView, OutputView outputView, StationService stationService,
                            LineService lineService, SectionService sectionService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.stationService = stationService;
        this.lineService = lineService;
        this.sectionService = sectionService;
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
        List<Line> lines = lineService.findAll();
        outputView.subwayList(lines);
    }

    public void registerStation() {
        String name = inputView.inputStationName();
        stationService.addStation(name);
        outputView.printInfo("지하철 역이 등록되었습니다.");
    }

    public void deleteStation() {
        String name = inputView.deleteStation();
        stationService.deleteStation(name);
        outputView.printInfo("지하철 역이 삭제되었습니다.");
    }

    public void searchStations() {
        List<Station> stations = stationService.findAll();
        outputView.printStations(stations);
    }

    // 1. 노선 관련 메서드
    public void registerLine() {
        String name = inputView.addLine();
        String firstStation = inputView.lineOfFirstStation();
        String lastStation = inputView.lineOfLastStation();
        lineService.addLine(name, firstStation, lastStation);

        outputView.printInfo("지하철 노선이 등록되었습니다.");
    }

    public void deleteLine() {
        String name = inputView.deleteLine();
        lineService.deleteLine(name);

        outputView.printInfo("지하철 노선이 삭제되었습니다.");
    }

    public void searchLines() {
        List<Line> lines = lineService.findAll();
        outputView.printLines(lines);
    }

    // 2. 구간 관련 메서드
    public void registerSection() {
        String line = inputView.selectLine();
        String station = inputView.selectStation();
        String order = inputView.selectOrder();

        sectionService.addSection(line, station, order);

        outputView.printInfo("구간이 등록되었습니다.");
    }

    public void deleteSection() {
        String line = inputView.deleteSectionsLine();
        String station = inputView.deleteSectionsStation();

        sectionService.delete(line, station);

        outputView.printInfo("구간이 삭제되었습니다.");
    }

    public void goBack() {
        return;
    }

}
