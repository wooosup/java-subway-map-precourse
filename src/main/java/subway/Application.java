package subway;

import java.util.Scanner;
import subway.controller.SubwayController;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.service.LineService;
import subway.service.SectionService;
import subway.service.StationService;
import subway.utils.DataLoader;
import subway.view.InputView;
import subway.view.OutputView;

public class Application {
    public static void main(String[] args) {
        StationRepository stationRepository = new StationRepository();
        LineRepository lineRepository = new LineRepository();

        DataLoader dataLoader = new DataLoader(stationRepository, lineRepository);
        dataLoader.load();

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        StationService stationService = new StationService(stationRepository);
        LineService lineService = new LineService(lineRepository, stationRepository);
        SectionService sectionService = new SectionService(lineRepository, stationRepository);

        SubwayController controller = new SubwayController(inputView, outputView, stationService, lineService, sectionService);

        controller.run();
    }
}
