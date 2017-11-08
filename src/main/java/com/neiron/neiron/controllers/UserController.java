package com.neiron.neiron.controllers;

import com.neiron.neiron.crud.BaseMsgResponce;
import com.neiron.neiron.crud.ResponceStatus;
import com.neiron.neiron.repos.TestRepo;
import com.neiron.neiron.repos.UserRolesRepo;
import com.neiron.neiron.repos.UsersRepo;
import com.neiron.neiron.service.LoadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    final UsersRepo usersRepo;
    final TestRepo testRepo;
    final UserRolesRepo userRolesRepo;
    public UserController (UsersRepo usersRepo,TestRepo testRepo,UserRolesRepo userRolesRepo){
        this.usersRepo=usersRepo;
        this.testRepo=testRepo;
        this.userRolesRepo=userRolesRepo;
    }
    @Autowired
    LoadFileService loadFileService;

    @GetMapping("/")
    ModelAndView index() {
        System.out.println(userRolesRepo.findAll());
        Map<String, String> model = new HashMap<>();
        model.put("name", "");
        return new ModelAndView("index", model);
    }
//
//    @GetMapping("/test")
//    ModelAndView test() {
//        Map<String, String> model = new HashMap<>();
//        model.put("name", "USER");
//        return new ModelAndView("index", model);
//    }
//
//    @GetMapping("/secure")
//    ModelAndView secure() {
//        Map<String, String> model = new HashMap<>();
//        model.put("name", "ADMIN");
//        return new ModelAndView("index", model);
//    }
//    @RequestMapping(value = "/loadfile/**", method = RequestMethod.POST, produces ="application/json;charset=UTF-8", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    @ResponseBody
//    public BaseMsgResponce loadBlacklist(@RequestParam("file") MultipartFile file) {
//        BaseMsgResponce response = new BaseMsgResponce(ResponceStatus.OK, "Данные успешно загружены");
//        try {
//            loadFileService.parseAndSaveBlacklist(file);
//        }
//        catch (Exception e) {
//            response.setStatus(ResponceStatus.ERROR);
//            String msg = "При обработке файла произошла ошибка.";
//            response.setMsg(msg);
//        }
//        return response;
//    }
}