package subway.domain;

public class Station {
    private final String name;

    private Station(String name) {
        this.name = name;
    }

    public static Station of(String name) {
        return new Station(name);
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현

    @Override
    public String toString() {
        return "[INFO] " + name;
    }
}
