package subway.domain;

public class Station {
    private final String name;

    private Station(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("[ERROR] 2글자 이상이어야 합니다.");
        }
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
