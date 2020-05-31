package com.fomracionbdi.springboot.app.item.clientes;

import com.fomracionbdi.springboot.app.item.models.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "servicio-productos")
public interface ProductoClienteRest {
    @GetMapping("/listar")  // es el mismo endpoint de ProductoController (otro microservicio)
    public List<Producto> listar();

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable("id")  Long id);
}
