package com.oijoa.dao;

import java.util.List;
import com.oijoa.domain.Notice;

public interface NoticeDao {
  List<Notice> findAll(String keyword) throws Exception;
}








