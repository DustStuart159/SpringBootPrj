package com.example.demo.controller;

import com.example.demo.service.dto.OrderDTO;
import com.example.demo.service.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@Slf4j
@RequiredArgsConstructor
public class OrderController {
    private final OrderServiceImpl orderServiceImpl;

    @PostMapping(value = "/create")
    public OrderDTO create(@RequestBody OrderDTO orderDTO) {
        return orderServiceImpl.save(orderDTO);
    }

    /*@GetMapping(value = "/get-all")
    public List<ProductDTO> findAll() {
        return orderServiceImpl.finAll();
    }

    @GetMapping(value = "/get-one")
    public Products findById(@RequestParam Long id) {
        Optional<Products> optionalProducts = orderServiceImpl.findById(id);
        if (!optionalProducts.isPresent()) {
            log.error("ID " + id + "is not exist");
            ResponseEntity.badRequest().build();
        }
        return optionalProducts.get();
    }
    @PutMapping(value = "/update")
    public Products update(@RequestParam Long id,@RequestBody Products products){
        if(!orderServiceImpl.findById(id).isPresent()){
            log.error("ID "+ id + "is not exist");
        }
        return orderServiceImpl.save(products);
    }

    @DeleteMapping(value = "/delete")
    public void delete(@RequestParam Long id){
        if(!orderServiceImpl.findById(id).isPresent()){
            log.error("ID "+ id + "is not exist");
            ResponseEntity.badRequest().build();
        }
        orderServiceImpl.deleteById(id);

    }*/
}
