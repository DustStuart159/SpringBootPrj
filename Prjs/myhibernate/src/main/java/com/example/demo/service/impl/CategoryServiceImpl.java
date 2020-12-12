package com.example.demo.service.impl;

import com.example.demo.models.Categories;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.service.dto.CategoryDTO;
import com.example.demo.service.mapper.CategoryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CategoryServiceImpl {
    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Autowired
    private CategoryMapper mapper;

    public CategoryDTO findById(Long id){
        Optional<Categories> optionalCategory = iCategoryRepository.findById(id);

        if (!optionalCategory.isPresent()) {
            log.error("ID " + id + "is not exist");
            ResponseEntity.badRequest().build();
        }

        return mapper.convertToDTO(optionalCategory.get());
    }

    public CategoryDTO save(CategoryDTO categoryDTO){
        Categories category = iCategoryRepository.save(mapper.convertToEntity(categoryDTO));
        return mapper.convertToDTO(category);
    }
    public void deleteById(Long id)
    {
        iCategoryRepository.deleteById(id);
    }

    public List<CategoryDTO> findAll() {
        List<CategoryDTO> res = new ArrayList<>();

        for (Categories category : iCategoryRepository.findAll()){
            CategoryDTO categoryDTO = mapper.convertToDTO(category);

            res.add(categoryDTO);
        }

        return res;
    }
}
