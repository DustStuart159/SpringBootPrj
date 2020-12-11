package com.example.demo.service.impl;

import com.example.demo.models.Categories;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {

    private final ICategoryRepository iCategoryRepository;

    public List<Categories> finAll(){
        return iCategoryRepository.findAll();
    }

    public Optional<Categories> findById(Long id){
        return iCategoryRepository.findById(id);
    }

    public Categories save(Categories products){
        return  iCategoryRepository.save(products);
    }
    public void deleteById(Long id)
    {
        iCategoryRepository.deleteById(id);
    }
}
