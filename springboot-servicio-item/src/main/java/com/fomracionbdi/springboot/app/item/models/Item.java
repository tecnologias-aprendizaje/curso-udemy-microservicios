package com.fomracionbdi.springboot.app.item.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
    private  Producto producto;
    private Integer cantidad;

    public Item(Producto producto, Integer cant) {
        this.producto = producto;
        this.cantidad = cant;
    }

    public Double getTotal() {
        return producto.getPrecio() * cantidad;
    }
}
