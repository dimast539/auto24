package ru.vostrestsov.avto24.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import ru.vostrestsov.avto24.models.Customer;
import ru.vostrestsov.avto24.services.CustomerService;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CustomerController {

    CustomerService customerService;

    @PostMapping("/create-cust")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping("/get-customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }


    @PatchMapping("/update-cust/{id}")
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        return customerService.clientChange(id, customer);
    }
}
