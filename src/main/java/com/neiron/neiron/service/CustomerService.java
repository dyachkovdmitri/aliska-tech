package com.neiron.neiron.service;

import com.neiron.neiron.entities.Customer;
import com.neiron.neiron.entities.Price;
import com.neiron.neiron.repos.CustomerRepo;
import com.neiron.neiron.repos.PriceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    public Customer createOrUpdateCustomer(Long customerAliskaId) {
        Customer customer;
        if (customerAliskaId != null) {
            customer = customerRepo.findById(customerAliskaId);
            customer.setAmmount(customer.getAmmount() + 1);
        } else {
            customer = new Customer();
            customer.setAmmount(1);
            customer.setId((long)(Math.random() * Long.MAX_VALUE));
            customer.setName(createCustomerName());
            customer.addAliskaMonolog(true, "Привет! Я - Алиска. Я - обучающаяся нейронная сеть. Я делаю счета на лампы. Ты можешь больше узнать обо мне в разделе FAQ. А пока просто нажми ЗАГРУЗИТЬ ЗАЯВКУ и посмотри что получится!");
            customer.addAliskaMonolog(true, "Пока ты не зарегался, я буду называть тебя " + customer.getName() + "!");
        }
        return customerRepo.saveAndFlush(customer);
    }

    public Customer getMe(Long customerAliskaId) {
        return customerRepo.findById(customerAliskaId);
    }

    public Customer addMonolog(String monolog, Long customerAliskaId) {
        Customer customer = customerRepo.findById(customerAliskaId);
        String oldMonolog = customer.getAliskaMonolog();
        customer.addAliskaMonolog(true,monolog);
        return customerRepo.saveAndFlush(customer);
    }


    private String createCustomerName() {
        String[] names = new String[]{"папик", "няшка", "бигБэн", "скорострел", "пусик", "лапа", "зайка", "мерседес", "бмв", "лапа", "насяльника"};
        String[] firstNames = new String[]{"Тощий", "Бородатый", "Большой", "Толстый", "Быстрый", "Длинный", "Добрый", "Злой", "Жадный"};
        Random rand = new Random();
        return firstNames[rand.nextInt(9)] + " " + names[rand.nextInt(9)];

    }
} 