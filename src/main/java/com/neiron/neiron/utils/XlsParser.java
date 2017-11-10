package com.neiron.neiron.utils;

import com.neiron.neiron.entities.Company;
import com.neiron.neiron.entities.CustomerRequest;
import com.neiron.neiron.entities.Item;
import com.neiron.neiron.entities.RequestLine;

import com.neiron.neiron.repos.CustomerRequestRepo;
import com.neiron.neiron.repos.ItemRepo;
import com.neiron.neiron.repos.RequestLineRepo;
import com.neiron.neiron.utils.aliska.AliskaParser;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class XlsParser {
    @Autowired
    CustomerRequestRepo customerRequestRepo;

    @Autowired
    RequestLineRepo requestLineRepo;


    @Autowired
    ItemRepo itemRepo;

    @Autowired
    AliskaParser aliskaParser;

//    public Long parseXlsPrice(MultipartFile file, Long priceId) {
//        ArrayList<RequestLine> requestLines = null;
//        ArrayList<Item> items = null;
//        try {
//            requestLines = getRequestLines(null, file);
//            //requestLineRepo.save(requestLines);
//            items = parsePrice(priceId, requestLines);
//            itemRepo.save(items);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return company.getId();
//    }


    public Long parseXls(MultipartFile file, Boolean brandImportant) {
        CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setStatus(1);
        customerRequest = customerRequestRepo.saveAndFlush(customerRequest);
        ArrayList<RequestLine> requestLines = null;
        try {
            requestLines = getRequestLines(customerRequest.getId(), file);
            //requestLineRepo.save(requestLines);
            customerRequest.setStatus(2);
            customerRequestRepo.saveAndFlush(customerRequest);
            requestLines = parse(requestLines, brandImportant);
            requestLineRepo.save(requestLines);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerRequest.getId();
    }


//    public ArrayList<Item> parsePrice(Long companyId, ArrayList<RequestLine> lines) {
//        return aliskaParser.parsePrice(companyId, lines);
//    }

    private ArrayList<RequestLine> parse(ArrayList<RequestLine> lines, Boolean brandImportant) {
        return aliskaParser.parse(lines, brandImportant);
    }

    public ArrayList<RequestLine> getRequestLines(Long customerRequestId, MultipartFile file) throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        XLSStructure structure = new XLSStructure(sheet);
        ArrayList<RequestLine> lines = new ArrayList<>();
        for (int i = 1; i < 30000; i++) {
            Row row = sheet.getRow(structure.getBeginString() + i);
            if (row != null) {
                String unparsedLine = "Строка не понята";
                try {
                    unparsedLine = row.getCell(structure.getItemName()).toString();

                    //System.out.println(unparsedLine);
                    String amountString;
                    Integer ammount;
                    try {
                        amountString = row.getCell(structure.getAmount()).toString();
                        ammount = Integer.parseInt(amountString.substring(0, amountString.indexOf(".")));
                    } catch (Exception e) {
                        ammount = -1;
                    }
                    RequestLine requestLine = new RequestLine();
                    requestLine.setUnparsedLine(unparsedLine);
                    requestLine.setAmmount(ammount);
                    requestLine.setRequestId(customerRequestId);
                    if (unparsedLine.length() > 3) {
                        lines.add(requestLine);
                    }
                } catch (Exception ignored) {
                }
            } else {
                return lines;
            }
        }
        return lines;
    }
}