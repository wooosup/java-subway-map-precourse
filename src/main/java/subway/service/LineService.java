package subway.service;

import java.util.List;
import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class LineService {

    private final LineRepository lineRepository;
    private final StationRepository stationRepository;

    public LineService(LineRepository lineRepository, StationRepository stationRepository) {
        this.lineRepository = lineRepository;
        this.stationRepository = stationRepository;
    }

    public void addLine(String name, String firstStation, String lastStation) {
        validateDuplicate(name);
        validateDifferentStation(firstStation, lastStation);
        Line line = Line.of(name);

        addLineOfStation(line, firstStation, lastStation);

        lineRepository.save(line);
    }

    public void addLineOfStation(Line line, String firstStation, String lastStation) {
        Station upStation = getStation(firstStation);
        Station downStation = getStation(lastStation);

        line.addStation(upStation);
        line.addStation(downStation);
    }

    public List<Line> findAll() {
        return lineRepository.findAll();
    }

    public void deleteLine(String name) {
        validateLine(name);

        lineRepository.deleteLineByName(name);
    }

    private Station getStation(String firstStation) {
        return stationRepository.findByName(firstStation)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 찾을 수 없는 역입니다."));
    }

    private void validateDifferentStation(String firstStation, String lastStation) {
        if (firstStation.equals(lastStation)) {
            throw new IllegalArgumentException("[ERROR] 상행 종점과 하행 종점은 같을 수 없습니다.");
        }
    }

    private void validateDuplicate(String name) {
        if (lineRepository.exists(name)) {
            throw new IllegalArgumentException("[ERROR] 이미 등록된 노선입니다.");
        }
    }

    private void validateLine(String name) {
        lineRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 찾을 수 없는 노선입니다."));
    }
}
