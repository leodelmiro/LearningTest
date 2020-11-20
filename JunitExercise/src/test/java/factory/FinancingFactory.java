package factory;

import entities.Financing;

public class FinancingFactory {

    public static Financing createEmptyFinancing() {
        return new Financing();
    }

    public static Financing createAvailableFinancing(){
        return new Financing(10000.0, 2000.0, 10);
    }
}
