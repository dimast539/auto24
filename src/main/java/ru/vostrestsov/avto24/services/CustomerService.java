package ru.vostrestsov.avto24.services;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vostrestsov.avto24.models.Customer;
import ru.vostrestsov.avto24.models.Part;
import ru.vostrestsov.avto24.repositories.CustomerRepository;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerService {

    CustomerRepository customerRepository;


    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer clientChange(int id, Customer updateCustomer){
        updateCustomer.setId(id);
        return customerRepository.save(updateCustomer);
    }
}
