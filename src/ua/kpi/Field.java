package ua.kpi;

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
    }

    public Cell[][] getCells() {
        return cells;
    }

    public List<Cell[][]> getPrevious() {
        return previous;
    }

    public void setCells(Cell[][] cells) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                this.cells[i][j].setAction(cells[i][j].getAction());
                this.cells[i][j].setFurnitureName(cells[i][j].getFurnitureName());

            }
        }
    }

    public void setPrevious(List<Cell[][]> previous) {
        this.previous = previous;
    }

    private void initialisationCells() {
        cells[0][0] = new Cell(Furniture.TABLE);
        cells[0][1] = new Cell(Furniture.CHAIR_2);
        cells[0][2] = new Cell(Furniture.CUPBOARD);
        cells[1][0] = new Cell(Furniture.CHAIR_1);
        cells[1][1] = new Cell(null);
        cells[1][2] = new Cell(Furniture.ARMCHAIR);
    }

}
