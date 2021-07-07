package Facade;

public class Main {
    public static void main(String[] args) {
        FacadeService.getData();
    }
}


class FacadeService {
    static FirstSubService fss = new FirstSubService();
    static SecondSubService sss = new SecondSubService();
    static ThirdSubService tss = new ThirdSubService();

    public static void getData() {
        System.out.println("Fetching...");
        fss.getData();
        sss.getData();
        tss.getData();
    }

}

class FirstSubService {
    public void getData() {}
}

class SecondSubService {
    public void getData() {}
}

class ThirdSubService {
    public void getData() {}
}