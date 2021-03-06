package com.neiron.neiron.controllers;

import com.neiron.neiron.crud.BaseMsgResponce;
import com.neiron.neiron.crud.ResponceStatus;
import com.neiron.neiron.entities.RequestLine;
import com.neiron.neiron.service.LoadFileService;
import com.neiron.neiron.service.RequestLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "customerRequest/")
public class CustomerRequestController {
    @Autowired
    private
    LoadFileService loadFileService;

    @Autowired
    RequestLineService requestLineService;

    @RequestMapping(value = "/loadfile/**", method = RequestMethod.POST, produces ="application/json;charset=UTF-8", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public BaseMsgResponce loadOrder(@RequestParam("file") MultipartFile file, @RequestParam("brandImportant")Boolean brandImportant) {
        BaseMsgResponce<RequestLine> response = new BaseMsgResponce(ResponceStatus.OK, "Данные успешно загружены");
        try {
           return loadFileService.loadOrder(file, brandImportant);
        }
        catch (Exception e) {
            response.setStatus(ResponceStatus.ERROR);
            String msg = "При обработке файла произошла ошибка.";
            response.setMsg(msg);
        }
        return response;
    }

    @RequestMapping(value = "/getOffer", method = RequestMethod.GET, produces ="application/json;charset=UTF-8")
    @ResponseBody
    public BaseMsgResponce getOffer(@CookieValue(value = "customerRequestId") Long customerRequestId) {

        BaseMsgResponce<RequestLine> response = new BaseMsgResponce(ResponceStatus.OK, "Данные успешно загружены");
        try {
            Integer count=0;
            ArrayList<RequestLine> requestLines = requestLineService.getRequestLines(customerRequestId);
            response.setData(requestLines);
        }
        catch (Exception e) {
            response.setStatus(ResponceStatus.ERROR);
            String msg = e.toString();
            response.setMsg(msg);
        }
        return response;
    }
} 