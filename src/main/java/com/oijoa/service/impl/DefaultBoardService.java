package com.oijoa.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.oijoa.dao.BoardDao;
import com.oijoa.domain.Board;
import com.oijoa.service.BoardService;

@Service
public class DefaultBoardService implements BoardService {

  BoardDao boardDao;

  public DefaultBoardService(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public int delete(int no) throws Exception {
    return boardDao.delete(no);
  }

  @Override
  public int add(Board board) throws Exception {
    return boardDao.insert(board);
  }

  @Override
  public List<Board> list() throws Exception {
    return boardDao.findAll(null);
  }

  @Override
  public List<Board> list(String keyword) throws Exception {
    return boardDao.findAll(keyword);
  }

  @Override
  public Board get(int no) throws Exception {
    Board board = boardDao.findByNo(no);
    if (board != null) {
      boardDao.updateViewCount(no);
    }
    return board;
  }

  @Override
  public int update(Board board) throws Exception {
    return boardDao.update(board);
  }

}
