package ua.kpi;

import ua.kpi.enums.Actions;

import java.util.List;

public class Utility {

    // проверка можна ли куда-то переместить мебель
    public static Cell[][] checkMoving(Cell[][] cells) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] != null) {
                    if (i - 1 >= 0 && cells[i - 1][j].getFurnitureName() == null) {
                        cells[i][j].setAction(Actions.UP);
                    } else if (i + 1 < 2 && cells[i + 1][j].getFurnitureName() == null) {
                        cells[i][j].setAction(Actions.DOWN);
                    } else if (j - 1 >= 0 && cells[i][j - 1].getFurnitureName() == null) {
                        cells[i][j].setAction(Actions.LEFT);
                    } else if (j + 1 < 3 && cells[i][j + 1].getFurnitureName() == null) {
                        cells[i][j].setAction(Actions.RIGHT);
                    } else cells[i][j].setAction(Actions.NOTHING);
                }
            }
        }
        return cells;
    }

    public static void printCellsArray(Cell[][] cells) {
        System.out.println("___________________________________");
        for (int i = 0; i < 2; i++) {
            System.out.print( "|  ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j].getFurnitureName());
                System.out.print( "  |  ");

            }
            System.out.println();
        }
        System.out.println("___________________________________");

    }

    // перемещение  мебели
    public static Cell[][] swapCells(Cell[][] cells, int i1, int j1, int i2, int j2) {
        Cell temp = new Cell(cells[i1][j1].getFurnitureName(), cells[i1][j1].getAction());

        cells[i1][j1].setFurnitureName(cells[i2][j2].getFurnitureName());

        cells[i2][j2].setFurnitureName(temp.getFurnitureName());

        return cells;
    }

    public static Cell[][] cloneCellArray(Cell[][] cells) throws CloneNotSupportedException {
        Cell[][] temp = new Cell[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j]= new Cell( cells[i][j].getFurnitureName());
            }
        }
        return temp;
    }

    private static Cell[][] cleanActions(Cell[][] cells) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j].setAction(null);
            }
        }
        return cells;
    }


}
