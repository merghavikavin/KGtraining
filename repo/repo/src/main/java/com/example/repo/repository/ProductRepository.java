package com.example.repo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.repo.entity.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

   
    public Product findByName(String name);

    Optional<Product> findById(int i);

    List<Product> findByNameOrDescription(String name, String description);

    
     List<Product> findByNameAndDescription(String name, String description);

    Product findDistinctByName(String name);

    List<Product> findByPriceGreaterThan(BigDecimal price);

    
    List<Product> findByPriceLessThan(BigDecimal price);

    
    List<Product> findByNameContaining(String name);


    List<Product> findByNameLike(String name);

    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    
    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

    Optional<Product> findTopByOrderByDateCreatedAsc();
    //List<Product> findByDateCreatedBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);
    List<Product> findByLastUpdatedBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);

    //public Product updateProduct(int id, Product updatedProduct);
    //int updateProductById(int id, String field1, String field2);

    // @Modifying
    // @Query("UPDATE Product p SET p.name = :name, p.price = :price WHERE p.id = :id")
    // int updateProductById(@Param("id") Long id, @Param("name") String name, @Param("price") BigDecimal price);
    @Query("SELECT p FROM Product p " +
        "WHERE p.dateCreated BETWEEN :startOfSeptember AND :endOfSeptember " +
        "AND p.dateCreated NOT BETWEEN :startOfOctober AND :endOfOctober")
        List<Product> findProductsInSeptemberNotInOctober(LocalDateTime startOfSeptember, LocalDateTime endOfSeptember,LocalDateTime startOfOctober, LocalDateTime endOfOctober);



}