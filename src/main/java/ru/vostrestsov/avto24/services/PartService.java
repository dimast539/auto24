package ru.vostrestsov.avto24.services;


import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vostrestsov.avto24.exceptions.PartNotFoundException;
import ru.vostrestsov.avto24.models.Part;
import ru.vostrestsov.avto24.repositories.PartRepository;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PartService {
    PartRepository partRepository;

    @Autowired
    public PartService(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    public List<Part> getParts() {
        return partRepository.findAll();
    }

    public Part findById(long id) {
        return partRepository.findById(id).orElseThrow(() ->
                new PartNotFoundException("Данная запчасть отсутствует.")
        );
    }

    public Part findPartByName(String name) {
        return partRepository.findPartByName(name).orElseThrow(() ->
                new PartNotFoundException(name + ". Товар не найден.")
        );
    }

    public Part findPartByVendorCode(String vendorCode) {
        return partRepository.findPartByVendorCode(vendorCode).orElseThrow(() ->
                new PartNotFoundException(vendorCode + ". Товар не найден.")
        );
    }

    public Part savePart(Part part) {
        return partRepository.save(part);
    }


    public void deletePart(long id) {
        partRepository.deleteById(id);
    }

    public Part updatePart(long id, Part updatePart) {
        updatePart.setId(id);
        return partRepository.save(updatePart);
    }


}
