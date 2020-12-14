package com.example.demo.service.mapper;

import com.example.demo.models.Accounts;
import com.example.demo.models.Contacts;
import com.example.demo.models.Roles;
import com.example.demo.models.Users;
import com.example.demo.repository.IAccountRepository;
import com.example.demo.repository.IContactRepository;
import com.example.demo.repository.IRoleRepository;
import com.example.demo.service.dto.AccountDTO;
import com.example.demo.service.dto.ContactDTO;
import com.example.demo.service.dto.RoleDTO;
import com.example.demo.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMapper extends BaseMapper {
    private final IRoleRepository roleRepo;
    private final IAccountRepository accRepo;
    private final IContactRepository contactRepo;
    public UserDTO convertToDto(Users input) {
        UserDTO res = super.tranferData(input, new UserDTO());
        /*res.setId(input.getId());
        res.setOrder_name(input.getOrder_name());
        res.setUser(input.getUser());*/

        return res;
    }

    public Users convertToEntity(UserDTO input) {
        Users res = super.tranferData(input, new Users());

        res.setRoles(this.getSetDataByIds(input.getRole_ids(), roleRepo, new Roles()));
        res.setAccounts(this.getSetDataByIds(input.getAccount_ids(), accRepo, new Accounts()));
        res.setContacts(this.getSetDataByIds(input.getContact_ids(),contactRepo,new Contacts()));
        /*res.setId(input.getId());
        res.setOrder_name(input.getOrder_name());
        res.setUser(this.getUserById(input.getUser_id()));
        this.updateRelationTable(res);*/

        return res;
    }

    /*private void updateRelationTable(Users res) {
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
    }*/
}
