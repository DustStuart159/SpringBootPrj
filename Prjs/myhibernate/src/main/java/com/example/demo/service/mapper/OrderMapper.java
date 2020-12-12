package com.example.demo.service.mapper;

import com.example.demo.models.Orders;
import com.example.demo.models.Products;
import com.example.demo.repository.IProductRepository;
import com.example.demo.service.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderMapper {
    @Autowired
    private IProductRepository productRepository;
   /* convert tu entity -->DTO*/
    public OrderDTO convertToDTO(Orders input){
        OrderDTO res = new OrderDTO();

        res.setId(input.getId());
        res.setOrder_name(input.getOrder_name());
        res.setProducts(input.getProducts());

        return res;
    }

   /* convert tu DTO --> Entity*/
    public Orders convertToEntity(OrderDTO input){
        Orders res = new Orders();

        res.setId(input.getId());
        res.setOrder_name(input.getOrder_name());
        res.setProducts(this.getProductList(input.getProduct_ids()));
        this.updateProductList(res);

        return res;
    }

    private void updateProductList(Orders order) {
        for (Products product : order.getProducts()){
            product.getOrders().add(order);
            productRepository.save(product);
        }
    }

    private List<Products> getProductList(List<Long> product_ids) {
        List<Products> list = new ArrayList<>();

        for (long id : product_ids){
            Optional<Products> opt = productRepository.findById(id);
            if (opt.isPresent()){
                list.add(opt.get());
            }else {
                // xử lý hiển thị sai id product
                System.err.println("Không tồn tại Product có id là " + id);
            }
        }

        return list;
    }

}
