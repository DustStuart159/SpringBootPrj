package com.example.demo.service.impl;

import com.example.demo.models.Categories;
import com.example.demo.models.Products;
import com.example.demo.repository.IProductRepository;
import com.example.demo.service.IProductService;
import com.example.demo.service.dto.ProductDTO;
import com.example.demo.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final IProductRepository iProductRepository;
    private final ProductMapper mapper = new ProductMapper();

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
        Products product = iProductRepository.save(mapper.convertToEntity(productDTO));
        return mapper.convertToDTO(product);
    }
    public void deleteById(Long id)
    {
        iProductRepository.deleteById(id);
    }
}
