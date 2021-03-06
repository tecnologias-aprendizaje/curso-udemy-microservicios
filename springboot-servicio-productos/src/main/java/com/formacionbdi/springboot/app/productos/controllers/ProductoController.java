package com.formacionbdi.springboot.app.productos.controllers;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @Autowired
    private Environment environment;

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/listar")
    public List<Producto> listar() {
        return productoService.findAll().stream().map(producto -> {
            producto.setPort(port);
            return producto;
        }).collect(toList());
    }

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable("id") Long id) throws Exception {
        Producto producto = productoService.findById(id);
        producto.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
        /*try {
            Thread.sleep(2000L);
        }catch (InterruptedException e){
            e.printStackTrace();
        }*/
        return producto;
    }
}
