package com.example.demo.repository;

import com.example.demo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    @Query(value = "SELECT * FROM product u WHERE u.name like %?1%", nativeQuery = true)
    List<Product> getAllProductByName (String name);
}
