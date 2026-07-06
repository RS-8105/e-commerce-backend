package com.rushi.e_commerce.product.ProductEntity;

import com.rushi.e_commerce.Common.AuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String brand;

    private String imageUrl;

    @Column(nullable = false)
    private BigDecimal discountPercentage = BigDecimal.ZERO;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private boolean isDeleted = false;
}
