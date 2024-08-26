package com.Gems.pc_crud.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private HashMap<String, Object> datos;
    private final ProductRepository productrepository;

    @Autowired
    public ProductService(ProductRepository productrepository){
        this.productrepository = productrepository;
    }
    public List<Product> getProducts(){
        return this.productrepository.findAll();
//        return List.of(
//                new Product(
//                        1L,
//                        "Zapato",
//                        "Azúl",
//                        34,
//                        LocalDateTime.now(),
//                        LocalDateTime.now(),
//                        199L));
    }

    public ResponseEntity<Object> newProduct(Product product) {
       Optional<Product> res = productrepository.findProductByName(product.getName());
       datos = new HashMap<>();

       if(res.isPresent()){
           datos.put("error", true);
           datos.put("messsage", "Este ya está we");
           return new ResponseEntity<>(
                   datos,
                   HttpStatus.CONFLICT
           );
       }
       productrepository.save(product);

        datos.put("data", product);
        datos.put("messsage", "Este sí :)");
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }
    public ResponseEntity<Object> DelProduct(Long id) {
        boolean exist = this.productrepository.existsById(id);
        datos = new HashMap<>();
        if(!exist){
            datos.put("error", true);
            datos.put("messsage", "Este ya no está we");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        productrepository.deleteById(id);

        datos.put("data", datos);
        datos.put("messsage", "Este sí se eliminó :)");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }
}
