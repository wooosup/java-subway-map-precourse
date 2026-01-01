package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import subway.domain.Station;

public class StationRepository {
    private final List<Station> stations = new ArrayList<>();

    public List<Station> findAll() {
        return Collections.unmodifiableList(stations);
    }

    public void save(Station station) {
        stations.add(station);
    }

    public void deleteByName(String name) {
        stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public Optional<Station> findByName(String name) {
        return stations.stream()
                .filter(station -> station.getName().equals(name))
                .findFirst();
    }

    public boolean exists(String station) {
        return stations.stream()
                .anyMatch(s -> s.getName().equals(station));
    }

}
