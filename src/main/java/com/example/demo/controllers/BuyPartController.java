package com.example.demo.controllers;

import com.example.demo.domain.PartMessages;
import com.example.demo.domain.Part;
import com.example.demo.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BuyPartController {

    @Autowired
    private PartService partService;
    @PostMapping("/buyParts")
    public String buyNow(@RequestParam("partID") int partID, RedirectAttributes redirectAttributes){
        try {
            Part part = partService.findById(partID);
            if(part.getInv() > 0){
                part.setInv(part.getInv() -1);
                PartMessages partMessage = new PartMessages("Purchase successful!", partID, true);
                redirectAttributes.addFlashAttribute("partMessage", partMessage);
            }
            else{
                PartMessages partMessage = new PartMessages("Purchase failed. This part is out of stock!", partID, false);
                redirectAttributes.addFlashAttribute("partMessage", partMessage);
            }
            partService.save(part);
            return "redirect:/mainscreen";
        }
        catch(Exception e) {
            redirectAttributes.addFlashAttribute("error", "An error occurred while processing your request.");
            return "redirect:/mainscreen";
        }
    }

}



