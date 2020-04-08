package ua.kpi;

public class Main {

    // Начальное поле вида
    //  _________________________
    // | Стол  | Стул2 | Шкаф   |
    // |_______|_______|________|
    // | Стул1 |       | Кресло |
    // |_______|_______|________|


    public static void main(String[] args) {
        Field field = new Field();
        System.out.println("-----------");
        Utility.printCellsArray(field.getCells());

        try {
            field.algorithm(field.getCells(), field.getPrevious());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
