package com.example.demo.service.mapper;

import com.example.demo.models.Orders;
import com.example.demo.models.Users;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderMapper {
    private final IUserRepository userRepo;

    public OrderDTO convertToDto(Orders input) {
        OrderDTO res = new OrderDTO();

        res.setId(input.getId());
        res.setOrder_name(input.getOrder_name());
        res.setUser(input.getUser());

        return res;
    }

    public Orders convertToEntity(OrderDTO input) {
        Orders res = new Orders();

        res.setId(input.getId());
        res.setOrder_name(input.getOrder_name());
        res.setUser(this.getUserById(input.getUser_id()));
        this.updateRelationTable(res);

        return res;
    }

    private void updateRelationTable(Orders res) {
        Users user = res.getUser();
        if (null == user) return;

        user.getOrders().add(res);
        userRepo.save(user);
    }

    private Users getUserById(Long id) {
        if (null == id) return null;

        Optional<Users> opt = userRepo.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            System.err.println("Không tồn tại user có id là " + id);
            return null;
        }
    }
}
