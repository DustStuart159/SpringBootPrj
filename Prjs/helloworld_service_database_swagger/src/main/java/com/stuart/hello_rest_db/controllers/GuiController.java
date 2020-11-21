package com.stuart.hello_rest_db.controllers;


import com.stuart.hello_rest_db.modul.Product;
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
public class GuiController {
    @Autowired
    private ProductService service;

    @RequestMapping("/crud")
    public String viewHomePage(Model model){
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);

        return "read_product";
    }

    @RequestMapping("/crud/new")
    public String showNewProductPage(Model model){
        Product product = new Product();
        model.addAttribute("product", product);

        return "new_product";
    }

    @RequestMapping(value = "/crud/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product){
        service.save(product);

        return "redirect:/crud";
    }

    @RequestMapping("/crud/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("edit_product");
        Product product = service.get(id);
        mav.addObject("product", product);

        return mav;
    }

    @RequestMapping("crud/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id){
        service.delete(id);
        return "redirect:/crud";
    }

}
