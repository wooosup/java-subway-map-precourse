package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import subway.domain.Line;

public class LineRepository {
    private final List<Line> lines = new ArrayList<>();

    public List<Line> findAll() {
        return Collections.unmodifiableList(lines);
    }

    public void save(Line line) {
        lines.add(line);
    }

    public void deleteLineByName(String name) {
        lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public Optional<Line> findByName(String name) {
        return lines.stream()
                .filter(line -> line.getName().equals(name))
                .findFirst();
    }

    public boolean exists(String name) {
        return lines.stream()
                .anyMatch(line -> line.getName().equals(name));
    }
}
