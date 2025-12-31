package subway.utils;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class DataLoader {

    private final StationRepository stationRepository;
    private final LineRepository lineRepository;

    public DataLoader(StationRepository stationRepository, LineRepository lineRepository) {
        this.stationRepository = stationRepository;
        this.lineRepository = lineRepository;
    }

    public void load() {
        loadStations();
        loadLines();
        loadSections();
    }

    private void loadSections() {
        addLineStation("2호선", "교대역", "강남역", "역삼역");
        addLineStation("3호선", "교대역", "남부터미널역", "양재역", "매봉역");
        addLineStation("신분당선", "강남역", "양재역", "양재시민의숲역");
    }

    private void addLineStation(String lineName, String... stationNames) {
        Line line = lineRepository.findByName(lineName)
                .orElseThrow(() -> new IllegalArgumentException("찾을 수 없습니다."));
        for (String stationName : stationNames) {
            Station station = stationRepository.findByName(stationName)
                    .orElseThrow(() -> new IllegalArgumentException("찾을 수 없습니다."));
            line.addStation(station);
        }
    }

    private void loadLines() {
        lineRepository.save(Line.of("2호선"));
        lineRepository.save(Line.of("3호선"));
        lineRepository.save(Line.of("신분당선"));
    }

    private void loadStations() {
        stationRepository.save(Station.of("교대역"));
        stationRepository.save(Station.of("강남역"));
        stationRepository.save(Station.of("역삼역"));
        stationRepository.save(Station.of("남부터미널역"));
        stationRepository.save(Station.of("양재역"));
        stationRepository.save(Station.of("양재시민의숲역"));
        stationRepository.save(Station.of("매봉역"));
    }
}
