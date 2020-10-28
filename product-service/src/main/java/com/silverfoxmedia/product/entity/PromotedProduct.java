package com.silverfoxmedia.product.entity;


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
@Table(name = "promoted_products")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class PromotedProduct extends Product {

    private String status;
    @Positive(message = "El stock debe ser mayor que cero")
    private Double stock;

    public PromotedProduct() {

        super();
    }
    public PromotedProduct(Long id, String name, String description, Double price, Date createAt, Category category, String status, Double stock) {
        super(id, name, description, price, createAt, category);
        this.status = status;
        this.stock = stock;
    }

    public void addPromoted(){

    }
    public void editPromoted(){

    }
    public void deletePromoted(){

    }
    public void searchPromoted(){

    }
}
