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
        Line line = Line.of(name);

        addLineOfStation(line, firstStation, lastStation);

        lineRepository.save(line);
    }

    public void addLineOfStation(Line line, String firstStation, String lastStation) {
        validateStation(firstStation, lastStation);

        Station upStation = stationRepository.findByName(firstStation)
                .orElseThrow(() -> new IllegalArgumentException("찾을 수 없는 역입니다."));
        Station downStation = stationRepository.findByName(lastStation)
                .orElseThrow(() -> new IllegalArgumentException("찾을 수 없는 역입니다."));

        validateNotNull(upStation, downStation);

        line.addStation(upStation);
        line.addStation(downStation);
    }

    private void validateNotNull(Station upStation, Station downStation) {
        if (upStation == null || downStation == null) {
            throw new IllegalArgumentException("등록되지 않은 역입니다. 역을 먼저 등록해주세요.");
        }
    }

    private void validateStation(String firstStation, String lastStation) {
        if (firstStation.equals(lastStation)) {
            throw new IllegalArgumentException("상행 종점과 하행 종점은 같을 수 없습니다.");
        }
    }

    public List<Line> findAll() {
        return lineRepository.findAll();
    }

    public void deleteLine(String name) {
        validate(name);

        lineRepository.deleteLineByName(name);
    }

    private void validateDuplicate(String name) {
        if (lineRepository.exists(name)) {
            throw new IllegalArgumentException("[ERROR] 이미 등록된 노선입니다.");
        }
    }

    private void validate(String name) {
        lineRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 찾을 수 없는 노선입니다."));
    }
}
