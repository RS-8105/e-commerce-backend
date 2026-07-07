package com.rushi.e_commerce.order.entity;

import com.rushi.e_commerce.Common.AuditableEntity;
import com.rushi.e_commerce.product.ProductEntity.ProductEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal unitPrice;

    @Column(nullable = false)
    private boolean isDeleted = false;

    @Column(nullable = false)
    private Integer quantity;
}

