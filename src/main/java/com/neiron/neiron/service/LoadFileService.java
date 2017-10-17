package com.neiron.neiron.service;

import com.neiron.neiron.entities.CustomerRequest;
import com.neiron.neiron.repos.CustomerRequestRepo;
import com.neiron.neiron.repos.RequestLineRepo;
import com.neiron.neiron.utils.XlsParser;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;

@Service
public class LoadFileService {
    @Autowired
    CustomerRequestRepo customerRequestRepo;

    @Autowired
    RequestLineRepo requestLineRepo;

    @Autowired
    XlsParser xlsParser;


    @Transactional(rollbackFor = Exception.class)
    public String loadOrder(MultipartFile file) throws Exception {
        CustomerRequest customerRequest = customerRequestRepo.saveAndFlush(new CustomerRequest());
        BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String line = "";
        xlsParser.parseXls(file);
        while ((line = br.readLine()) != null) {
            try {
                String[] item = new String(line.getBytes(), "UTF-8").split(";");
            } catch (Exception e) {
                return ("Все ненорм");
            }
        }
        return customerRequest.getId().toString();
    }

} 