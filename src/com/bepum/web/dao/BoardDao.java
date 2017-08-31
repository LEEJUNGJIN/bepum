package com.bepum.web.dao;

import java.util.List;

import com.bepum.web.entity.Board;

public interface BoardDao {

	List<Board> getList(int page, String query, String bName);

	Board get(String no, String bName);

	int update(String no, String title, String content, String bName);

	int insert(String title, String content, String bName);


}
