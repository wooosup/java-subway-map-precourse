package subway.view;


import java.util.Scanner;

public class InputView {
    private final Scanner sc = new Scanner(System.in);

    public String readFunction() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return sc.nextLine();
    }

    public String inputStationName() {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        return sc.nextLine();
    }

    public String deleteStation() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        return sc.nextLine();
    }

    public String addLine() {
        System.out.println("## 등록할 노선 이름을 입력하세요.");
        return sc.nextLine();
    }

    public String deleteLine() {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
        return sc.nextLine();
    }

    public String lineOfFirstStation() {
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        return sc.nextLine();
    }

    public String lineOfLastStation() {
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        return sc.nextLine();
    }

    public String selectLine() {
        System.out.println("## 노선을 입력하세요.");
        return sc.nextLine();
    }

    public String selectStation() {
        System.out.println("## 역이름을 입력하세요.");
        return sc.nextLine();
    }

    public String selectOrder() {
        System.out.println("## 순서를 입력하세요.");
        return sc.nextLine();
    }

    public String deleteSectionsLine() {
        System.out.println("## 삭제할 구간의 노선을 입력하세요.");
        return sc.nextLine();
    }

    public String deleteSectionsStation() {
        System.out.println("## 삭제할 구간의 역을 입력하세요.");
        return sc.nextLine();
    }
}
