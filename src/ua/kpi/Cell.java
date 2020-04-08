package ua.kpi;

import ua.kpi.enums.Actions;
import ua.kpi.enums.Furniture;

public class Cell implements Cloneable{

    private Furniture furnitureName;
    private Actions action;

    public Cell() {
    }

    public Cell(Furniture furnitureName) {
        this.furnitureName = furnitureName;
        this.action = null;
    }

    public Cell(Furniture furnitureName, Actions action) {
        this.furnitureName = furnitureName;
        this.action = action;
    }

    public Furniture getFurnitureName() {
        if (furnitureName == null) return null;
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
    protected Object clone() throws CloneNotSupportedException {
        Cell clone = null;
        try {
            clone = (Cell) super.clone();
            if (this.getFurnitureName() == null) {
                clone = new Cell(null);
            } else {
                clone = new Cell(this.getFurnitureName());
            }
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        return clone;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "furnitureName=" + furnitureName +
                ", action=" + action +
                '}';
    }
}
