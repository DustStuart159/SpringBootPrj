package com.example.demo.service.dto;

import com.example.demo.models.Products;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDTO implements Serializable {
    private long id;
    private List<Long> product_ids;
    private String category_name;
    private List<Products> products = new ArrayList<>();
}
