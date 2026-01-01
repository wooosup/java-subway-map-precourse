package subway.service;

import java.util.List;
import java.util.Optional;
import subway.domain.Station;
import subway.repository.StationRepository;

public class StationService {

    private final StationRepository repository;

    public StationService(StationRepository repository) {
        this.repository = repository;
    }

    public void addStation(String name) {
        validateDuplicate(name);
        Station station = Station.of(name);

        repository.save(station);
    }

    public List<Station> findAll() {
        return repository.findAll();
    }

    public void deleteStation(String name) {
        validate(name);

        repository.deleteByName(name);
    }

    private void validateDuplicate(String name) {
        if (repository.exists(name)) {
            throw new IllegalArgumentException("[ERROR] 이미 등록된 역입니다.");
        }
    }

    private void validate(String name) {
        repository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 찾을 수 없는 역입니다."));
    }

}
