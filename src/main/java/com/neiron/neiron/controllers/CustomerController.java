package com.neiron.neiron.controllers;

import com.neiron.neiron.crud.BaseMsgResponce;
import com.neiron.neiron.crud.ResponceStatus;
import com.neiron.neiron.entities.Customer;
import com.neiron.neiron.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "customer/")
public class CustomerController {
    @Autowired
    CustomerService customerService;

   private static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @RequestMapping(value = "/getCookie", method = RequestMethod.GET)
    @ResponseBody
    public BaseMsgResponce getMe2(@CookieValue(value = "customerAliskaId", required = false) Long customerAliskaId) {

        BaseMsgResponce<Customer> response;
        if (customerAliskaId == null) {
            Customer customer = customerService.createOrUpdateCustomer(null);
            response = new BaseMsgResponce(ResponceStatus.OK, customer.getId().toString());
        } else response = new BaseMsgResponce(ResponceStatus.OK, customerAliskaId.toString());
        return response;
    }

    @RequestMapping(value = "/test/**", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String test(@CookieValue(value = "customerAliskaId") Long customerAliskaId) {
        System.out.println("System.out.println");
        System.err.println("Error");
        logger.debug("Debug log message");
        logger.info("Info log message");
        logger.error("Error log message");

        return "Успех!";
    }

    @RequestMapping(value = "/getMe/**", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseMsgResponce getMe(@CookieValue(value = "customerAliskaId") Long customerAliskaId) {

        BaseMsgResponce<Customer> response = new BaseMsgResponce(ResponceStatus.OK, "Данные успешно загружены");

        if (customerAliskaId == null) {
            Customer customer = customerService.createOrUpdateCustomer(null);
            response.setAliskaMonolog(customer.getAliskaMonolog());
            response.setMsg(customer.toString());
        } else {
            try {
                Customer customer = customerService.getMe(customerAliskaId);
                response.setMsg(customer.toString());
                response.setData(customer);
                response.setAliskaMonolog(customer.getAliskaMonolog());
            } catch (Exception e) {
                response.setStatus(ResponceStatus.ERROR);
                response.setMsg("Не в этот день детка. Творится какая то фигня!");
            }
        }
        return response;
    }



    @RequestMapping(value = "/addAliskaDialog/**", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseMsgResponce addAliskaDialog(@CookieValue(value = "customerAliskaId") Long customerAliskaId,
                                           @RequestParam(value = "word") String word) {
        BaseMsgResponce<Customer> response = new BaseMsgResponce(ResponceStatus.OK, "Данные успешно загружены");

        try {
            Customer customer = customerService.addMonolog(word, customerAliskaId);
            response.setAliskaMonolog(customer.getAliskaMonolog());
            response.setData(customer);
        } catch (Exception e) {
            response.setStatus(ResponceStatus.ERROR);
            response.setMsg("Не в этот день детка. Творится какая то фигня!");

        }
        return response;
    }
} 