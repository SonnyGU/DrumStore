package com.example.demo.controllers;

import com.example.demo.domain.ProductMessages;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BuyProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/buyProduct")
    public String buyNow(@RequestParam("productID") int productID, RedirectAttributes redirectAttributes){
        try {
            Product product = productService.findById(productID);
            if(product.getInv() > 0){
                product.setInv(product.getInv() -1);
                ProductMessages productMessage = new ProductMessages("Purchase successful!", productID, true);
                redirectAttributes.addFlashAttribute("productMessage", productMessage);
            }
            else{
                ProductMessages productMessage = new ProductMessages("Purchase failed. Product is out of stock!", productID, false);
                redirectAttributes.addFlashAttribute("productMessage", productMessage);
            }
            productService.save(product);
            return "redirect:/mainscreen";
        }
            catch(Exception e) {
            redirectAttributes.addFlashAttribute("error", "An error occurred while processing your request.");
            return "redirect:/mainscreen";
            }
        }

}
