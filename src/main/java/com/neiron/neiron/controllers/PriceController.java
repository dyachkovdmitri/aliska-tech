package com.neiron.neiron.controllers;

import com.neiron.neiron.crud.BaseMsgResponce;
import com.neiron.neiron.crud.ResponceStatus;
import com.neiron.neiron.entities.Customer;
import com.neiron.neiron.entities.Price;
import com.neiron.neiron.entities.RequestLine;
import com.neiron.neiron.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "price/")
public class PriceController {
    @Autowired
    PriceService priceService;

    @RequestMapping(value = "/getAvailable", method = RequestMethod.GET, produces ="application/json;charset=UTF-8")
    @ResponseBody
    public BaseMsgResponce loadOrder(@CookieValue(value = "customerAliskaId", required=false) Long customerAliskaId) {
        BaseMsgResponce<Price> response = new BaseMsgResponce(ResponceStatus.OK, "Данные успешно загружены");
        try {
            response.setData(priceService.getAvailablePrices(customerAliskaId));
        }
        catch (Exception e) {
            response.setStatus(ResponceStatus.ERROR);
            String msg = e.getMessage();
            response.setMsg(msg);
        }
        return response;
    }
} 