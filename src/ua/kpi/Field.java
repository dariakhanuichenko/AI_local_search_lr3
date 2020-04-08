package ua.kpi;

import ua.kpi.enums.Actions;
import ua.kpi.enums.Furniture;

import java.util.LinkedList;
import java.util.List;

public class Field {

    private Cell[][] cells;

    private List<Cell[][]> previous;

    public Field() {
        cells = new Cell[2][3];
        initialisationCells();
        previous = new LinkedList<>();
        previous.add(cells);
    }

    public Cell[][] getCells() {
        return cells;
    }

    public List<Cell[][]> getPrevious() {
        return previous;
    }


    private void initialisationCells() {
        cells[0][0] = new Cell(Furniture.TABLE);
        cells[0][1] = new Cell(Furniture.CHAIR_2);
        cells[0][2] = new Cell(Furniture.CUPBOARD);
        cells[1][0] = new Cell(Furniture.CHAIR_1);
        cells[1][1] = new Cell(null);
        cells[1][2] = new Cell(Furniture.ARMCHAIR);
    }

    // есть ли такое же поле в преведущих
    public boolean checkExistencePrevious(Cell[][] cells, List<Cell[][]> previous) {

        if (!previous.isEmpty()) {
            for (Cell[][] field : previous) {
                //если такое поле уже существует
                if (isEquals(field, cells)) return true;
            }
        }
        return false;
    }

    // одинаковые ли  названия мебели
    public boolean equalsFurnitureName(Cell cell1, Cell cell2) {
        if (cell1.getFurnitureName() == null) {
            if (cell2.getFurnitureName() == null) {
                return true;
            } else return false;
        } else if (cell2.getFurnitureName() == null) {
            return false;
        } else
            return cell1.getFurnitureName().equals(cell2.getFurnitureName());
    }

    // одинаковые ли днйствия
    public boolean equalsAction(Cell cell1, Cell cell2) {
        return cell1.getAction() == cell2.getAction();
    }

    // равны ли 2 поля
    public boolean isEquals(Cell[][] field1, Cell[][] field2) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(equalsFurnitureName(field1[i][j], field2[i][j]))) {
                    return false;
                }
            }
        }
        return true;
    }

    // достигли цели?
    public boolean success(Cell[][] cells) {
        return
                (cells[0][2].getFurnitureName() == Furniture.ARMCHAIR &&
                        cells[1][2].getFurnitureName() == Furniture.CUPBOARD);

    }

    public int[] canMove(Cell cell, int i, int j) {
        int[] coordinates = new int[2];
        coordinates[0] = i;
        coordinates[1] = j;
        if (cell.getAction() != Actions.NOTHING)
            return cell.getAction().returnTargetCellCoordinates(coordinates);
        else
            throw new RuntimeException("oops");
    }

    //вместо превиос список хешкодов
    public void algorithm(Cell[][] cells, List<Cell[][]> previous) throws CloneNotSupportedException {
        //для координат куда перемещать
        int[] coordinates = new int[2];

        // проверили что куда может передвигатся
        Utility.checkMoving(cells);

        // начинаем цыкл по всем ячейкам поля
        for (int i = 1; i >= 0; i--) {
            for (int j = 2; j >= 0; j--) {
                // если мебель с этой ячейки можна передвинуть
                if (cells[i][j].getAction() != Actions.NOTHING) {
                    // получили координаты ячейки куда переставляем мебель
                    coordinates = canMove(cells[i][j], i, j);
                    // если после перемещения будет поле, которое уже существует перейти к следуюзей ячейке
                    if (checkExistencePrevious(Utility.swapCells(Utility.cloneCellArray(cells), i, j, coordinates[0], coordinates[1]), previous))
                        continue;
                        // если такого поля нету
                    else {
//                        System.out.println("--------BEFORE SWAP-------");
//                        Utility.printCellsArray(cells);

                        // переместить мебель
                        cells = Utility.swapCells(cells, i, j, coordinates[0], coordinates[1]);
                        System.out.println("--------AFTER SWAP-------");
                        Utility.printCellsArray(cells);
                        System.out.println("-------------------------");

                        // добавить полученое поле в те которые уже пройдены
                        previous.add(cells);

                        // если достигли цели -> выйти
                        if (success(cells)) {
                            System.exit(1);
                        }
                        // іначе рекурсия
                        else {
                            algorithm(Utility.cloneCellArray(cells), previous);
                        }
                    }
                }
            }
        }
    }
}
