package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p from Product p WHERE " +
            "p.name LIKE CONCAT('%',:query, '%')" +
            "OR p.description LIKE CONCAT('%', :query, '%')")
    List<Product> searchProducts(String query);

    @Query(value = "SELECT * from products p WHERE " +
            "p.name LIKE CONCAT('%',:query, '%')" +
            "OR p.description LIKE CONCAT('%', :query, '%')", nativeQuery = true)
    List<Product> searchProductsSQL(String query);

}
