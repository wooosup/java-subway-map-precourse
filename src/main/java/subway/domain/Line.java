package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final String name;
    private final List<Station> stations = new ArrayList<>();

    private Line(String name) {
        this.name = name;
    }

    public static Line of(String name) {
        return new Line(name);
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public void addStation(Station station, int order) {
        validateDuplicate(station);

        if (order < 0 || order > stations.size()) {
            stations.add(station);
            return;
        }
        stations.add(order, station);
    }

    private void validateDuplicate(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException("[ERROR] 이미 노선에 등록된 역입니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[INFO] " + name;
    }

    public void removeStation(Station station) {
        stations.remove(station);
    }
}
