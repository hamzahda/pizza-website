package com.product.controller;

import java.util.List;

import javax.persistence.Cacheable;

import com.product.entity.Product;
import com.product.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

@Autowired
private ProductService productService;

@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)

private List<Product> getAll() {
try {
    return productService.getProduct();
} catch (final Exception e) {

}
return null;
    
}
@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
public Product getProduct(@PathVariable final long id ) {
   return productService.findById(id);
}

@PostMapping("/")
public void postProduct (@RequestBody final Product Product){
    productService.createProduct(Product);
}

@DeleteMapping("/{id}")
public void deleteProduct (@PathVariable final long id){
    productService.deleteProductById(id);
}


  @PutMapping("/{id}")
public  Product modif(@RequestBody final Product Product, @PathVariable final Long id) {
    Product usr = productService.findById(id);
    usr.setName(Product.getName());
    productService.update(usr);
    return usr;
  }





}
