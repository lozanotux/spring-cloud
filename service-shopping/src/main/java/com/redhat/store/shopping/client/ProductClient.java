package com.redhat.store.shopping.client;

import com.redhat.store.shopping.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-product")
@RequestMapping("/products")
public interface ProductClient {

    @GetMapping("/{id}")
    ResponseEntity<Product> getProduct(@PathVariable("id") Long id);

    @GetMapping("/{id}/stock")
    ResponseEntity<Product> updateStockProduct(
            @PathVariable Long id,
            @RequestParam(name = "quantity", required = true) Double quantity
    );

}
