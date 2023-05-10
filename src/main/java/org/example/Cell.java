package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Cell {

    private Integer row;

    private Integer column;
    private Boolean isAlive;

    private List<List<Integer>> neighboursLocation;


    public Cell(Integer row, Integer column, Boolean isAlive) {
        this.row = row;
        this.column = column;
        this.isAlive = isAlive;
        neighboursLocation = new ArrayList<>();
        neighboursLocation.add(Arrays.asList(row - 1, column));
        neighboursLocation.add(Arrays.asList(row + 1, column));
        neighboursLocation.add(Arrays.asList(row, column + 1));
        neighboursLocation.add(Arrays.asList(row, column - 1));
        neighboursLocation.add(Arrays.asList(row - 1, column + 1));
        neighboursLocation.add(Arrays.asList(row - 1, column - 1));
        neighboursLocation.add(Arrays.asList(row + 1, column + 1));
        neighboursLocation.add(Arrays.asList(row + 1, column - 1));
    }

    public Boolean isAlive(){
        return this.isAlive;
    }


    public Integer getNoOfLiveNeighbours(List<List<Cell>> cellList){

        Integer count = 0;
        for(List<Integer> positions : this.neighboursLocation){
            Integer row = positions.get(0);
            Integer column = positions.get(1);
            if(row >= 0 && column >= 0 && row < cellList.size() && column < cellList.get(0).size()){
                if(cellList.get(row).get(column).isAlive()){
                    count += 1;
                }
            }
        }

        return count;

    }

    public Cell cellForNextGeneration(Integer noOfLiveCells) {

       
        if (this.isAlive()) {
            if (noOfLiveCells >= 2 && noOfLiveCells <= 3) {
                return new Cell(this.row, this.column, true);
            }
        }
        if (noOfLiveCells == 3) {
            return new Cell(this.row, this.column,true);
        }

        return new Cell(this.row, this.column,false);

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
