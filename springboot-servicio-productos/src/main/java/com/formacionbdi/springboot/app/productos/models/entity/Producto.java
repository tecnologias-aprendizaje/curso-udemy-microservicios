package com.formacionbdi.springboot.app.productos.models.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.TemporalType;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class Producto implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String nombre;
    private Double precio;

    @Transient
    private Integer port;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = 12343434343L;
}
