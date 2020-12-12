package com.example.demo.service.dto;

import com.example.demo.models.Categories;
import com.example.demo.models.Orders;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
/*@JsonInclude(JsonInclude.Include.NON_NULL)*/
public class ProductDTO implements Serializable {
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String product_name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private long category_id;
    private Categories category;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Long> order_ids;
    private List<Orders> orders;
}
