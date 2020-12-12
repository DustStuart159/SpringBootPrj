package com.example.demo.service.impl;

import com.example.demo.models.Categories;
import com.example.demo.models.Products;
import com.example.demo.repository.IProductRepository;

import com.example.demo.service.dto.ProductDTO;
import com.example.demo.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl{
    @Autowired
    private IProductRepository iProductRepository;
    @Autowired
    private ProductMapper mapper;

    public List<ProductDTO> finAll(){
        List<ProductDTO> listDTO = new ArrayList<>();

        List<Products> list = iProductRepository.findAll();

        for (Products product : list){
            listDTO.add(mapper.convertToDTO(product));
        }

        return listDTO;
    }

    public Optional<Products> findById(Long id){
        return iProductRepository.findById(id);
    }

    public ProductDTO save(ProductDTO productDTO){
        Products prod = mapper.convertToEntity(productDTO);
        Products product = iProductRepository.save(prod);
        return mapper.convertToDTO(product);
    }
    public void deleteById(Long id)
    {
        iProductRepository.deleteById(id);
    }
}
