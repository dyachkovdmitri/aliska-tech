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
           // System.out.println("");
            Row row = rowIterator.next();
            if (row != null) {
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) { //todo сделать остановку
                    if(this.amount!=null&&this.beginString!=null&&this.itemName!=null){break;}
                    Cell cell = cellIterator.next();
                    if (cell != null) {
                        //System.out.print(cell+"-");
                        String value = cell.toString();
                        //System.out.print(value + "--");
                        if (value.toLowerCase().trim().contains("количество") || value.toLowerCase().contains("кол-во")) {
                            this.amount = cell.getColumnIndex();
                           // this.beginString = cell.getRowIndex();
                        }
                        if (value.toLowerCase().trim().contains("наименование") || value.toLowerCase().contains("наим.") || value.toLowerCase().contains("номенклатура")) {
                            this.itemName = cell.getColumnIndex();
                            this.beginString = cell.getRowIndex();
                        }

                        if (value.toLowerCase().trim().contains("артикул") || value.toLowerCase().contains("наим.")) {
                            this.code = cell.getColumnIndex();
                            //this.beginString = cell.getRowIndex();
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