package com.oijoa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.oijoa.dao.FoodDao;
import com.oijoa.domain.Food;

@Service
public class DefaultFoodService implements FoodService {

  FoodDao foodDao;

  public DefaultFoodService(FoodDao foodDao) {
    this.foodDao = foodDao;
  }

  @Override
  public List<Food> list() throws Exception {
    return foodDao.findAll(null);
  }

  @Override
  public List<Food> list(String keyword) throws Exception {
    return foodDao.findAll(keyword);
  }

  @Override
  public List<Food> list(int recipeNo) throws Exception {
    return foodDao.findByRecipeNo(recipeNo);
  }

}
