package ru.vostrestsov.avto24.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vostrestsov.avto24.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
