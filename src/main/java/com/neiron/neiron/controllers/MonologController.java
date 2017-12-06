package com.neiron.neiron.controllers;

import com.neiron.neiron.crud.BaseMsgResponce;
import com.neiron.neiron.crud.ResponceStatus;
import com.neiron.neiron.entities.RequestLine;
import com.neiron.neiron.service.LoadFileService;
import com.neiron.neiron.service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "monolog/")
public class MonologController {

    @Autowired
    LoadFileService loadFileService;


    @Autowired
    RegService regService;

    @RequestMapping(value = "/checkWord/**", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseMsgResponce checkWord(@CookieValue(value = "customerAliskaId") Long customerAliskaId,
                                     @RequestParam("word") String word) {
        BaseMsgResponce<RequestLine> response = new BaseMsgResponce(ResponceStatus.OK, "Данные успешно загружены");
        try {
            if (word.contains("@") && word.contains(".")) {
                response.setAliskaMonolog(regService.registerNewCustomer(word));
            } else {
            response.setAliskaMonolog(loadFileService.checkWord(word, customerAliskaId));}
        } catch (Exception e) {
            response.setStatus(ResponceStatus.ERROR);
            String msg = "При обработке файла произошла ошибка.";
            response.setMsg(msg);
            response.setAliskaMonolog("Чо за грязь ты мне прислал!? Я ничо не поняла! Над колокной с намиенование напиши \"наименование\"! Над колонкой с количеством которое тебе надо напиши \"кол-во\"! может тогда я пойму! Но это неточно...");
        }
        return response;
    }
} 