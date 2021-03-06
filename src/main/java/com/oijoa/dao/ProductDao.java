package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Product;

public interface ProductDao {
  List<Product> findAll(String keyword) throws Exception;

  int insert(Product product);

  Product findByNo(int no);

  int update(Product product);
}


