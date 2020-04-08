package ua.kpi;

import ua.kpi.enums.Actions;

public class Utility {

    public static Cell[][] checkMoving(Cell[][] cells) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] != null) {
                    if (i - 1 >= 0 && cells[i - 1][j].getFurnitureName() == null) {
                        cells[i][j].setAction(Actions.UP);
                    }
                   else  if (i + 1 < 2 && cells[i + 1][j].getFurnitureName() == null) {
                        cells[i][j].setAction(Actions.DOWN);
                    }
                   else  if (j - 1 >= 0 && cells[i][j - 1].getFurnitureName() == null) {
                        cells[i][j].setAction(Actions.LEFT);
                    }
                   else  if (j + 1 < 3 && cells[i][j + 1].getFurnitureName() == null) {
                        cells[i][j].setAction(Actions.RIGHT);
                    }
                   else cells[i][j].setAction(Actions.NOTHING);
                }
            }
        }
        printCellsArray(cells);
        return cells;
    }

    public static void printCellsArray(Cell[][] cells) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(cells[i][j]);
            }
        }
    }
}
