package subway.service;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class SectionService {

    private final LineRepository lineRepository;
    private final StationRepository stationRepository;

    public SectionService(LineRepository lineRepository, StationRepository stationRepository) {
        this.lineRepository = lineRepository;
        this.stationRepository = stationRepository;
    }

    public void addSection(String lineName, String stationName, String order) {
        Line line = getLine(lineName);
        Station station = getStation(stationName);

        line.addStation(station, Integer.parseInt(order) - 1);
    }

    public void delete(String lineName, String stationName) {
        Line line = getLine(lineName);
        Station station = getStation(stationName);

        line.removeStation(station);
    }

    private Station getStation(String stationName) {
        return stationRepository.findByName(stationName)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 찾을 수 없는 역입니다."));
    }

    private Line getLine(String lineName) {
        return lineRepository.findByName(lineName)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 찾을 수 없는 노선입니다."));
    }
}
