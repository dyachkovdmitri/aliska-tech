package com.neiron.neiron.service;

import com.neiron.neiron.utils.XlsParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

public class ItemService {
    @Autowired
    XlsParser xlsParser;
    public Long loadPrice(MultipartFile file) {
        return xlsParser.parseXlsPrice(file);
    }
}