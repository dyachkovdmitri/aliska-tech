package com.neiron.neiron.utils;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Iterator;

public class XLSStructure {
    Integer code;
    Integer itemName;
    Integer amount;
    Integer beginString;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getItemName() {
        return itemName;
    }

    public void setItemName(Integer itemName) {
        this.itemName = itemName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    XLSStructure(Sheet sheet) {
        init(sheet);
    }

    private void init(Sheet sheet) {
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            if (row != null) {
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) { //todo сделать остановку
                    Cell cell = cellIterator.next();
                    if (cell != null) {
                        String value = cell.toString();
                        //System.out.print(value + "--");
                        if (value.toLowerCase().trim().contains("количество") || value.toLowerCase().equalsIgnoreCase("кол-во")) {
                            this.amount = cell.getColumnIndex();
                            this.beginString = cell.getRowIndex();
                        }
                        if (value.toLowerCase().trim().contains("наименование") || value.toLowerCase().equalsIgnoreCase("наим.")) {
                            this.itemName = cell.getColumnIndex();
                            this.beginString = cell.getRowIndex();
                        }

                        if (value.toLowerCase().trim().contains("артикул") || value.toLowerCase().equalsIgnoreCase("наим.")) {
                            this.code = cell.getColumnIndex();
                            this.beginString = cell.getRowIndex();
                        }

                    }


                }
            }
        }
    }

    public Integer getBeginString() {
        return beginString;
    }

    public void setBeginString(Integer beginString) {
        this.beginString = beginString;
    }
}