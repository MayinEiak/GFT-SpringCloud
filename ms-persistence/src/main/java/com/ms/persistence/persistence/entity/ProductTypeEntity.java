package com.ms.persistence.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="ctl_product_type")
public class ProductTypeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_type_id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    public ProductTypeEntity(Integer id) {
        this.id = id;
    }
}
