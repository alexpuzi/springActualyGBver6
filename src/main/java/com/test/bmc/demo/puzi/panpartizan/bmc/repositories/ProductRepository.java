package com.test.bmc.demo.puzi.panpartizan.bmc.repositories;

import com.geekbrains.geekmarket.entities.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
//public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAllByVendorCode(String vendorCode);
//
    List<Product> findAll();
//
    List<Product> findAllByTitleAndPrice(String title, double price);
//
//
    List<Product> findAllByPriceBetween(double min, double max);

 //   List<Product> findAllByCategory_Title(double min, double max);
//
    Product findOneByTitle(String title);
//
    @Query(value ="select id, category_id, short_description, " +
            "create_at, full_description, title, price, vendor_code, " +
            "title from products where id = ?1", nativeQuery = true)
    Product myQuery(Long id);
}
