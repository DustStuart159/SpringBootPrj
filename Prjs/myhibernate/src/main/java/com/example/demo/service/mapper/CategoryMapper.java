package com.example.demo.service.mapper;

import com.example.demo.models.Categories;
import com.example.demo.models.Products;
import com.example.demo.repository.IProductRepository;
import com.example.demo.service.dto.CategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryMapper {
    @Autowired
    private IProductRepository productRepo;
   /* convert tu entity -->DTO*/
    public CategoryDTO convertToDTO(Categories input){
        CategoryDTO res = new CategoryDTO();

        res.setId(input.getId());
        res.setCategory_name(input.getCategory_name());
        res.setProducts(input.getProducts());

        return res;
    }

   /* convert tu DTO --> Entity*/
    public Categories convertToEntity(CategoryDTO input){
        Categories res = new Categories();

        res.setId(input.getId());
        res.setCategory_name(input.getCategory_name());
        this.updateProduct(input.getProduct_ids(), res);

        return res;
    }

    private void updateProduct(List<Long> product_ids, Categories category) {
        for (long id : product_ids) {
            Optional<Products> opt = productRepo.findById(id);
            if (!opt.isPresent()){
                // thêm thông báo ko có product
                System.err.println("Không tồn tại product với id là " + id);
            }else {
                Products product = opt.get();
                product.setCategory(category);
                productRepo.save(product);
            }
        }
    }
}

