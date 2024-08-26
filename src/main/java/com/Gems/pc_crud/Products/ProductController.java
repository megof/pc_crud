package com.Gems.pc_crud.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Add to consult Data - Controller
@RequestMapping(path = "api/v1/products")
public class ProductController {
   private final ProductService productService;
   @Autowired
    public ProductController(ProductService productService){
       this.productService = productService;
   }

   @GetMapping
    public List<Product> getProducts(){
       return this.productService.getProducts();
   }

    @PostMapping
    public ResponseEntity<Object> registrarPrducto(@RequestBody Product product){
       return this.productService.newProduct(product);
    }
    @DeleteMapping(path="{PD}")
    public ResponseEntity<Object> eliminarPrducto(@PathVariable("PD") Long id){
        return this.productService.DelProduct(id);
    }
}
