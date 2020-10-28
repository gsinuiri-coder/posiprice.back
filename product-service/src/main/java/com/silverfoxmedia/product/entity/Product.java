package com.silverfoxmedia.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
@Table(name = "products")
@Data
//@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotEmpty(message = "El nombre no debe ser vacío")
    protected String name;
    protected String description;

    protected Double price;


    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createAt;

    @NotNull(message = "La categoria no puede ser vacia")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    protected Category category;


    public Product(Long id, @NotEmpty(message = "El nombre no debe ser vacío") String name, String description, Double price, Date createAt, @NotNull(message = "La categoria no puede ser vacia") Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createAt = createAt;
        this.category = category;
    }
}