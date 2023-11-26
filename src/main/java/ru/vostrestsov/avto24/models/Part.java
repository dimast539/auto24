package ru.vostrestsov.avto24.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "spare_parts")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spare_parts_id")
    private long id;

    @Column(name = "part_name")
    private String name;

    @Column(name = "vendor_code")
    private String vendorCode;


    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    @JsonBackReference

    private Customer customer;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Part part = (Part) o;
        return id == part.id && Objects.equals(name, part.name) && Objects.equals(vendorCode, part.vendorCode) && Objects.equals(customer, part.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, vendorCode, customer);
    }
}
