package com.neiron.neiron.controllers;

import com.neiron.neiron.crud.BaseMsgResponce;
import com.neiron.neiron.crud.ResponceStatus;
import com.neiron.neiron.entities.Customer;
import com.neiron.neiron.entities.Item;
import com.neiron.neiron.entities.Price;
import com.neiron.neiron.entities.RequestLine;
import com.neiron.neiron.service.CustomerService;
import com.neiron.neiron.service.ItemService;
import com.neiron.neiron.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "item/")
public class ItemController {
    @Autowired
    ItemService itemService;
    @Autowired
    PriceService priceService;
    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/loadfile/**", method = RequestMethod.POST, produces ="application/json;charset=UTF-8", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public BaseMsgResponce loadOrder(@RequestParam("file") MultipartFile file,@RequestParam(value="priceName", required=false)String priceName, @RequestParam(value="allVisible", required=false)Boolean allVisible, @CookieValue(value = "customerAliskaId", required=false) Long customerAliskaId) {
        BaseMsgResponce<RequestLine> response = new BaseMsgResponce(ResponceStatus.OK, "Данные успешно загружены");
        try {
            Customer customer = customerService.createOrUpdateCustomer(customerAliskaId);
            Price price = priceService.createNewPrice(priceName,allVisible, customerAliskaId);
            response.setMsg(itemService.loadPrice(file, price.getId()).toString());
        }
        catch (Exception e) {
            response.setStatus(ResponceStatus.ERROR);
            String msg = "При обработке файла произошла ошибка.";
            response.setMsg(msg);
            response.setAliskaMonolog("Чо за грязь ты мне прислал!? Я ничо не поняла! Над колокной с намиенование напиши \"наименование\"! Над колонкой с количеством которое тебе надо напиши \"кол-во\"! может тогда я пойму! Но это неточно...");
        }
        return response;
    }

    @RequestMapping(value = "/getPrice", method = RequestMethod.GET, produces ="application/json;charset=UTF-8")
    @ResponseBody
    public BaseMsgResponce getOffer(@CookieValue(value = "customerAliskaId")Long customerAliskaId, @CookieValue(value = "priceId", required = false)  Long priceId) {

        BaseMsgResponce<Item> response = new BaseMsgResponce(ResponceStatus.OK, "Данные успешно загружены");
        try {
            ArrayList<Item> items = itemService.getPrice(customerAliskaId, priceId);
            response.setData(items);
        }
        catch (Exception e) {
            response.setStatus(ResponceStatus.ERROR);
            String msg = e.toString();
            response.setMsg(msg);
        }
        return response;
    }
} 