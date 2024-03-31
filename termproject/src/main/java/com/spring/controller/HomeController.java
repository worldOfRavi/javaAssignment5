package com.spring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.spring.beans.Clients;
import com.spring.beans.product;
import com.spring.dao.ProductDao;

import org.springframework.ui.Model;

@Controller
public class HomeController {
    private final ProductDao productDao;

    public HomeController(ProductDao productDao) {
        this.productDao = productDao;
    }
    
    @GetMapping("/")
    public String home(Model model) {
    	String[][] items = {
                {"1", "product 1"},
                {"2", "product 2"},
                {"3", "product 3"},
                {"4", "product 4"},
                {"5", "product 5"}
            };
        model.addAttribute("items", items);
        return "product";
    }
    
    @PostMapping("/addOrUpdateProduct")
    public String addOrUpdateProduct(@RequestParam String id, @RequestParam String name) {
        // Assuming the quantity is always 1 for a new addition
        product item = new product(Integer.parseInt(id), name, 1);
        productDao.addOrUpdateItem(item);
        return "redirect:/"; // Redirect to the home page after adding/updating
    }
    
    @GetMapping("/cart")
    public String cart(Model model) {
        List<product> products = productDao.getAllProducts(); // Assuming getAllProducts method fetches all products from the database
        model.addAttribute("products", products);
        return "cart";
    }
    
    @PostMapping("/removeProduct")
    public String removeProduct(@RequestParam String id) {
        productDao.removeProductById(Integer.parseInt(id));
        return "redirect:/cart"; // Redirect to the home page
    }
    
    

//    @PostMapping("/signin")
//    public String signup(Model model,
//    		@RequestParam("email") String email,
//            @RequestParam("password") String password) {u
//        // Process the form data here (e.g., save to the database)
//        System.out.println("Received signup form data:");
//        System.out.println("Email: " + email);
//        System.out.println("Password: " + password);
//        
//        // Redirect to a success page or return a view name
//        return "redirect:/dashboard";
//    }
}
