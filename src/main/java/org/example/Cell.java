package org.example;

import java.util.Objects;

public class Cell {
     private Boolean isAlive;

    public Cell(Boolean isAlive) {

        this.isAlive = isAlive;
    }

    public Boolean isAlive(){

        return this.isAlive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Cell cell = (Cell) o;
        return this.isAlive == cell.isAlive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isAlive);
    }
}
