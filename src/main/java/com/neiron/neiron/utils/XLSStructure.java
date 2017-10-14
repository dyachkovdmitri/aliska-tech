package com.neiron.neiron.utils;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Iterator;

public class XLSStructure {
    Integer code;
    Integer codeString;
    Integer itemName;
    Integer itemNameString;
    Integer amount;
    Integer amountString;

    XLSStructure(Sheet sheet) {
        init(sheet);
    }

    private void init(Sheet sheet) {
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            if (row != null) {
                System.out.println("___________________________");
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) { //todo сделать остановку
                    Cell cell = cellIterator.next();
                    if (cell != null) {
                        String value = cell.toString();
                        System.out.print(value + "--");
                        if (value.toLowerCase().trim().contains("количество") || value.toLowerCase().equalsIgnoreCase("кол-во")) {
                            this.amount = cell.getColumnIndex();
                            this.amountString = cell.getRowIndex();
                        }
                        if (value.toLowerCase().trim().contains("наименование") || value.toLowerCase().equalsIgnoreCase("наим.")) {
                            this.itemName = cell.getColumnIndex();
                            this.itemNameString = cell.getRowIndex();
                        }

                        if (value.toLowerCase().trim().contains("артикул") || value.toLowerCase().equalsIgnoreCase("наим.")) {
                            this.code = cell.getColumnIndex();
                            this.codeString = cell.getRowIndex();
                        }

                    }


                }
            }
        }
    }

} 