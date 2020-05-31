package com.fomracionbdi.springboot.app.item.clientes;

import com.fomracionbdi.springboot.app.item.models.Item;
import com.fomracionbdi.springboot.app.item.models.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceFeignImpl implements ItemService {
    @Autowired
    private ProductoClienteRest clienteFeing;

    @Override
    public List<Item> findAll() {
        return clienteFeing.listar().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        return new Item(clienteFeing.detalle(id), 1);
    }
}
