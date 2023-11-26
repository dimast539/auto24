package ru.vostrestsov.avto24.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vostrestsov.avto24.models.Part;

import java.util.Optional;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
   Optional<Part> findPartByName(String name);
   Optional<Part> findPartByVendorCode(String vendorCode);
}
