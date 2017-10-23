package com.neiron.neiron.controllers;

import com.neiron.neiron.crud.BaseMsgResponce;
import com.neiron.neiron.crud.ResponceStatus;
import com.neiron.neiron.entities.RequestLine;
import com.neiron.neiron.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
@Controller
@RequestMapping(value = "item/")
public class ItemController {
    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/loadfile/**", method = RequestMethod.POST, produces ="application/json;charset=UTF-8", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public BaseMsgResponce loadOrder(@RequestParam("file") MultipartFile file) {
        BaseMsgResponce<RequestLine> response = new BaseMsgResponce(ResponceStatus.OK, "Данные успешно загружены");
        try {
            response.setMsg(itemService.loadPrice(file).toString());
        }
        catch (Exception e) {
            response.setStatus(ResponceStatus.ERROR);
            String msg = "При обработке файла произошла ошибка.";
            response.setMsg(msg);
        }
        return response;
    }
} 