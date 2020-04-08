package ua.kpi;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Field field = new Field();
        Utility.printCellsArray(field.getCells());
        System.out.println("-----------");

//
//        field.setCells(Utility.checkMoving(field.getCells()));
//        System.out.println("-----------");
//        Utility.printCellsArray(field.getCells());
        System.out.println("-----------");

        field.algorithm(field.getCells(), field.getPrevious());
    }
}
