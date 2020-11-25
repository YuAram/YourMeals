package com.oijoa.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.oijoa.dao.RecipeDao;
import com.oijoa.domain.Recipe;

public class RecipeDaoImpl implements RecipeDao{

  SqlSessionFactory sqlSessionFactory;

  public RecipeDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<Recipe> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("RecipeDao.findAll", keyword);
    }
  }
}







