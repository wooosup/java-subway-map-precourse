package subway.view;

import java.util.List;
import subway.domain.Line;
import subway.domain.Station;

public class OutputView {

    public static final String INFO = "[INFO] ";

    public static void printError(String message) {
        System.out.println(message);
    }

    public void printMain() {
        System.out.println("## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
        System.out.println();
    }

    public void printStationManage() {
        System.out.println("## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");
        System.out.println();
    }

    public void printStations(List<Station> stations) {
        System.out.println("## 역 목록");
        for (Station station : stations) {
            System.out.println(station.toString());
        }
    }

    public void printLineManage() {
        System.out.println("## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기");
        System.out.println();
    }

    public void printLines(List<Line> lines) {
        System.out.println("## 노선 목록");
        for (Line line : lines) {
            System.out.println(line.toString());
        }
    }

    public void printSectionsManage() {
        System.out.println("## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기");
        System.out.println();
    }

    public void subwayList(List<Line> lines) {
        System.out.println("## 지하철 노선도");
        for (Line line : lines) {
            System.out.println(line.toString());
            System.out.println(INFO + "---");

            for (Station station : line.getStations()) {
                System.out.println(station.toString());
            }
            System.out.println();
        }
    }

    public void printInfo(String message) {
        System.out.println(INFO + message);
    }
}
