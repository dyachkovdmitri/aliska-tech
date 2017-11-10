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
        Customer customer = customerRepo.findById(customerAliskaId);
        if (customer == null) {
            customer = new Customer();
            customer.setAmmount(1);
            customer.setId(customerAliskaId);
            customer.setName(createCustomerName());
        } else customer.setAmmount(customer.getAmmount() + 1);
        return customerRepo.saveAndFlush(customer);
    }

    private String createCustomerName() {
        String[] names = new String[]{"папик", "няшка", "бигБэн", "скорострел", "пусик", "лапа", "зайка", "мерседес", "бмв", "лапа", "насяльника"};
        String[] firstNames = new String[]{"Тощий", "Бородатый", "Большой", "Толстый", "Быстрый", "Длинный", "Добрый", "Злой", "Жадный"};
        Random rand = new Random();
        return firstNames[rand.nextInt(9)] + " " + names[rand.nextInt(9)];

    }
} 