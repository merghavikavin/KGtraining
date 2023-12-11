package com.example.repo.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.repo.repository.ProductRepository;
import com.example.repo.entity.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/findByName")
    public ResponseEntity<Product> findByNameMethod() {
        Product product = productRepository.findByName("Product 1");

        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Product> findByIdMethod(@PathVariable("id") int id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByNameOrDescription")
    public ResponseEntity<List<Product>> findByNameOrDescriptionMethod() {
        List<Product> products = productRepository.findByNameOrDescription("Product 1", "Description for Product 1");

        if (!products.isEmpty()) {
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findDistinctByName")
    public ResponseEntity<Product> findDistinctByNameMethod() {
        Product product = productRepository.findDistinctByName("Product 3");
        return ResponseEntity.ok(product);
    }

    @GetMapping("/findByPriceGreaterThan")
    public ResponseEntity<List<Product>> findByPriceGreaterThanMethod() {
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(40));
        return ResponseEntity.ok(products);
    }

    @GetMapping("/findByPriceLessThan")
    public ResponseEntity<List<Product>> findByPriceLessThanMethod() {
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(20));
        return ResponseEntity.ok(products);
    }

    @GetMapping("/findByNameContaining")
    public ResponseEntity<List<Product>> findByNameContainingMethod() {
        List<Product> products = productRepository.findByNameContaining("Product 1");
        return ResponseEntity.ok(products);
    }

    @GetMapping("/findByNameLike")
    public ResponseEntity<List<Product>> findByNameLikeMethod() {
        List<Product> products = productRepository.findByNameLike("Product 1");
        return ResponseEntity.ok(products);
    }

    @GetMapping("/findByPriceBetween")
    public ResponseEntity<List<Product>> findByPriceBetweenMethod() {
        List<Product> products = productRepository.findByPriceBetween(new BigDecimal(20), new BigDecimal(50));
        return ResponseEntity.ok(products);
    }

    @GetMapping("/findByDateCreatedBetween")
    public ResponseEntity<List<Product>> findByDateCreatedBetweenMethod() {
        LocalDateTime startDate = LocalDateTime.of(2023, 12, 6, 17, 48, 33);
        LocalDateTime endDate = LocalDateTime.of(2023, 12, 6, 18, 15, 21);
        List<Product> products = productRepository.findByDateCreatedBetween(startDate, endDate);
        return ResponseEntity.ok(products);
    }

    // 12
    @GetMapping("/earliestCreated")
    public ResponseEntity<Product> getProductWithEarliest() {
        Optional<Product> earliestProduct = productRepository.findTopByOrderByDateCreatedAsc();

        return earliestProduct.map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // 7
    @GetMapping("/InSeptember")
    public ResponseEntity<List<Product>> getProductsInSeptember() {
        LocalDate startOfMonth = LocalDate.of(LocalDate.now().getYear(), Month.SEPTEMBER, 1);
        LocalDate endOfMonth = LocalDate.of(LocalDate.now().getYear(), Month.SEPTEMBER, Month.SEPTEMBER.maxLength());

        List<Product> productsInSeptember = productRepository.findByDateCreatedBetween(startOfMonth.atStartOfDay(),
                endOfMonth.atTime(LocalTime.MAX));

        if (!productsInSeptember.isEmpty()) {
            return new ResponseEntity<>(productsInSeptember, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 30
    @GetMapping("/lastUpdatedInDecember")
    public ResponseEntity<List<Product>> getProductsLastUpdatedInDecember() {
        LocalDate startOfMonth = LocalDate.of(LocalDate.now().getYear(), Month.DECEMBER, 1);
        LocalDate endOfMonth = LocalDate.of(LocalDate.now().getYear(), Month.DECEMBER, Month.DECEMBER.maxLength());

        List<Product> productsLastUpdatedInDecember = productRepository
                .findByLastUpdatedBetween(startOfMonth.atStartOfDay(), endOfMonth.atTime(LocalTime.MAX));

        if (!productsLastUpdatedInDecember.isEmpty()) {
            return new ResponseEntity<>(productsLastUpdatedInDecember, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<Product> updateProduct(@PathVariable Long id,
    // @RequestBody Product updatedProduct) {
    // int updatedRowCount = productRepository.updateProductById(id,
    // updatedProduct.getName(),
    // updatedProduct.getPrice());

    // if (updatedRowCount > 0) {
    // // Product updated successfully
    // Product updatedProduct1 = productRepository.findById(id).orElse(null);
    // return new ResponseEntity<>(updatedProduct1, HttpStatus.OK);
    // } else {
    // // No product found for the given ID
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    // }
    LocalDateTime startOfSeptember = LocalDateTime.of(2023, Month.SEPTEMBER, 1, 0, 0);
    LocalDateTime endOfSeptember = LocalDateTime.of(2023, Month.SEPTEMBER, 30, 23, 59);

    LocalDateTime startOfOctober = LocalDateTime.of(2023, Month.OCTOBER, 1, 0, 0);
    LocalDateTime endOfOctober = LocalDateTime.of(2023, Month.OCTOBER, 31, 23, 59);

    List<Product> productsInSeptemberNotInOctober = productRepository.findProductsInSeptemberNotInOctober(startOfSeptember, endOfSeptember,
            startOfOctober, endOfOctober);

    // Process the list of products as needed

}
