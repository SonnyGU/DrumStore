package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */

       if(productRepository.count() == 0 && partRepository.count() == 0) {
            
            OutsourcedPart o1 = new OutsourcedPart();
            o1.setCompanyName("Beat line Bros");
            o1.setName("Electronic Triggers/Pads");
            o1.setInv(5);
            o1.setPrice(90.0);
            o1.setId(100L);
            outsourcedPartRepository.save(o1);
            OutsourcedPart thePart1=null;

            OutsourcedPart o2 = new OutsourcedPart();
            o2.setCompanyName("Drum Dynasty");
            o2.setName("Drum Head");
            o2.setInv(7);
            o2.setPrice(100.0);
            o2.setId(200L);
            outsourcedPartRepository.save(o2);
            OutsourcedPart thePart2=null;

            OutsourcedPart o3 = new OutsourcedPart();
            o3.setCompanyName("Vibrant Valves");
            o3.setName("Cymbal");
            o3.setInv(4);
            o3.setPrice(130.0);
            o3.setId(300L);
            outsourcedPartRepository.save(o3);
            OutsourcedPart thePart3=null;

            OutsourcedPart o4 = new OutsourcedPart();
            o4.setCompanyName("Echo Edge Drums");
            o4.setName("Drum Shell");
            o4.setInv(2);
            o4.setPrice(100.0);
            o4.setId(400L);
            outsourcedPartRepository.save(o4);
            OutsourcedPart thePart4=null;


            OutsourcedPart o5 = new OutsourcedPart();
            o5.setCompanyName("Sonic Stave");
            o5.setName("Pair of Drumsticks");
            o5.setInv(6);
            o5.setPrice(20.0);
            o5.setId(500L);
            outsourcedPartRepository.save(o5);
            OutsourcedPart thePart5=null;

            List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for(OutsourcedPart part:outsourcedParts){
                switch (part.getName()) {
                    case "Pair of Drumsticks" -> thePart5 = part;
                    case "Drum Shell" -> thePart4 = part;
                    case "Cymbal" -> thePart3 = part;
                    case "Drum Head" -> thePart2 = part;
                    default -> thePart1 = part;
                }
            }

            Product sQ2 = new Product("SQ2 drum series", 5000.0, 5);
            Product pdp = new Product("pdp z5 series drum set", 400.0, 10);
            Product radio = new Product("Radio King drums", 1700.0, 17);
            Product proLite = new Product("ProLite series drums set", 1000.0, 12);
            Product ludwig = new Product("Ludwig Classic", 3100.0, 1);

            partRepository.save(thePart1);
            partRepository.save(thePart2);
            partRepository.save(thePart3);
            partRepository.save(thePart4);
            partRepository.save(thePart5);
            productRepository.save(sQ2);
            productRepository.save(pdp);
            productRepository.save(radio);
            productRepository.save(proLite);
            productRepository.save(ludwig);
        }


        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }



        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
