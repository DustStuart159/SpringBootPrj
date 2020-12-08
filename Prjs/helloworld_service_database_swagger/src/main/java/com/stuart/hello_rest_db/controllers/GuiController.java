package com.stuart.hello_rest_db.controllers;


import com.stuart.hello_rest_db.modul.Entities.ProductEntity;
import com.stuart.hello_rest_db.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Controller
@ApiIgnore
@RequestMapping("/crud")
public class GuiController {
    @Autowired
    private ProductService service;

    @RequestMapping("")
    public String viewHomePage(Model model){
        List<ProductEntity> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);

        return "read_product";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model){
        ProductEntity product = new ProductEntity();
        model.addAttribute("product", product);

        return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") ProductEntity product){
        service.save(product);

        return "redirect:/crud";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("edit_product");
        ProductEntity product = service.get(id);
        mav.addObject("product", product);

        return mav;
    }

    @RequestMapping("delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id){
        service.delete(id);
        return "redirect:/crud";
    }

}
