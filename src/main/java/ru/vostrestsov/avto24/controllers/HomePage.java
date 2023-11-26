package ru.vostrestsov.avto24.controllers;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import ru.vostrestsov.avto24.models.Part;
import ru.vostrestsov.avto24.services.PartService;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class HomePage {

    PartService partService;


    @GetMapping()
    public List<Part> getPart() {
        return partService.getParts();
    }

    @GetMapping("/{id}")
    public Part findById(@PathVariable long id) {
        return partService.findById(id);
    }

    @GetMapping("/name/{name}")
    public Part findPartByName(@PathVariable String name) {
        return partService.findPartByName(name);
    }

    @GetMapping("/vendor_code/{vendorCode}")
    public Part findPartByVendorCode(@PathVariable String vendorCode){
        return partService.findPartByVendorCode(vendorCode);
    }

    @PostMapping("/save_part")
    public Part savePart(@RequestBody Part part){
        return partService.savePart(part);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePart(@PathVariable long id){
        partService.deletePart(id);
    }

    @PatchMapping("/update/{id}")
    public Part updatePart(@PathVariable long id, @RequestBody Part updatePart){
       return partService.updatePart(id, updatePart);
    }
}
