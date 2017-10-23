package com.neiron.neiron.service;

import com.neiron.neiron.entities.Item;
import com.neiron.neiron.repos.ItemRepo;
import com.neiron.neiron.utils.XlsParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@Service
public class ItemService {
    @Autowired
    private
    XlsParser xlsParser;

    @Autowired
    private
    ItemRepo itemRepo;

    public Long loadPrice(MultipartFile file) {
        return xlsParser.parseXlsPrice(file);
    }

    public ArrayList<Item> getPrice(Long companyId) {
        return itemRepo.findByCompanyId(companyId);
    }
}