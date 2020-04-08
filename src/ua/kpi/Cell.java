package ua.kpi;

import ua.kpi.enums.Actions;
import ua.kpi.enums.Furniture;

public class Cell {

    private Furniture furnitureName;
    private Actions action;

    public Cell() {
    }

    public Cell(Furniture furnitureName) {
        this.furnitureName = furnitureName;
        this.action= null;
    }

    public Cell(Furniture furnitureName, Actions action) {
        this.furnitureName = furnitureName;
        this.action = action;
    }

    public Furniture getFurnitureName() {
        return furnitureName;
    }

    public void setFurnitureName(Furniture furnitureName) {
        this.furnitureName = furnitureName;
    }

    public Actions getAction() {
        return action;
    }

    public void setAction(Actions action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "furnitureName=" + furnitureName +
                ", action=" + action +
                '}';
    }
}
