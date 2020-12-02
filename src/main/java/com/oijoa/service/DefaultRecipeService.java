package com.oijoa.service;

import java.util.List;
import com.oijoa.dao.RecipeDao;
import com.oijoa.domain.Recipe;

public class DefaultRecipeService implements RecipeService {

  RecipeDao recipeDao;

  public DefaultRecipeService(RecipeDao recipeDao) {
    this.recipeDao = recipeDao;
  }

  //  @Override
  //  public int delete(int no) throws Exception {
  //    return boardDao.delete(no);
  //  }
  //
  //  @Override
  //  public int add(Board board) throws Exception {
  //    return boardDao.insert(board);
  //  }
  //
  @Override
  public List<Recipe> list() throws Exception {
    return recipeDao.findAll(null);
  }

  @Override
  public List<Recipe> myList(int loginUserNo) throws Exception {
    return recipeDao.findMy(loginUserNo);
  }

  @Override
  public int add(Recipe recipe) throws Exception {
    recipeDao.insert(recipe);
    recipeDao.insertCategory(recipe);
    return 1;
  }
  //  @Override
  //  public List<Order> list(String keyword) throws Exception {
  //    return orderDao.findAll(keyword);
  //  }
  //
    @Override
    public Recipe get(int no) throws Exception {
      Recipe recipe = recipeDao.findByNo(no);
      if (recipe != null) {
    	  recipeDao.updateViewCount(no);
      }
      return recipe;
    }
  
    @Override
    public int update(Recipe recipe) throws Exception {
      return recipeDao.update(recipe);
    }

}
