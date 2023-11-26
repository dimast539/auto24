package ru.vostrestsov.avto24.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "customers")
public class Customer {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    long id;

    @Column(name = "full_name")
    String fullName;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer")
    private List<Part> spareParts;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(fullName, customer.fullName) && Objects.equals(spareParts, customer.spareParts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, spareParts);
    }
}
