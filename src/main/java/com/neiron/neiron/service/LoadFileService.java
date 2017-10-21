package com.neiron.neiron.service;

import com.neiron.neiron.entities.CustomerRequest;
import com.neiron.neiron.entities.RequestLine;
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
import java.util.ArrayList;
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
    public ArrayList<RequestLine> loadOrder(MultipartFile file) throws Exception {
        return xlsParser.parseXls(file);
    }

} 