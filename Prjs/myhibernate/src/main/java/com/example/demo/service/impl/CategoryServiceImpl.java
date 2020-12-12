package com.example.demo.service.impl;

import com.example.demo.models.Categories;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.service.dto.CategoryDTO;
import com.example.demo.service.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl {
    private final ICategoryRepository iCategoryRepository;
    private final CategoryMapper mapper = new CategoryMapper();

    public List<Categories> finAll(){
        return iCategoryRepository.findAll();
    }

    public Optional<Categories> findById(Long id){
        return iCategoryRepository.findById(id);
    }

    public CategoryDTO save(CategoryDTO categoryDTO){
        Categories category = iCategoryRepository.save(mapper.convertToEntity(categoryDTO));
        return mapper.convertToDTO(category);
    }
    public void deleteById(Long id)
    {
        iCategoryRepository.deleteById(id);
    }
}
