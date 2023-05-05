package org.example;

public class Cell {

    private Integer rowNo;

    private Integer totalRows;

    private Integer totalColumns;

    private Integer columnNo;

    private Boolean isAlive;

    public Cell(Integer rowNo, Integer columnNo, Integer totalRows, Integer totalColumns, Boolean isAlive) {
        this.rowNo = rowNo;
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        this.columnNo = columnNo;
        this.isAlive = isAlive;
    }

    public Boolean isAlive(){

        return this.isAlive;
    }





}
