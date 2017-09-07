package com.bepum.web.dao;

import java.util.List;

import com.bepum.web.entity.Board;
import com.bepum.web.entity.BoardView;
import com.bepum.web.entity.SecretBoardView;

public interface SecretBoardDao {

	List<SecretBoardView> getList(int page,String c_name, String query, String tName);

	SecretBoardView get(String no, String tName);

	int update(String no, String title, String content, int isPrivate, String privateKey, String tName);

	int insert(String title, String content, int isPrivate, String privateKey, String tName);

	int getCount(String string);

}
