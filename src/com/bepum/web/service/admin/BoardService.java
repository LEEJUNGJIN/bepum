package com.bepum.web.service.admin;

import java.util.List;

import com.bepum.web.entity.Board;

public class BoardService {
	//ȭ���� �ε�� �� 
	public List<Board> getBoardList(){
		return getBoardList(1,"");
	}
	//�˻����� ��
	public List<Board> getBoardList(String title){
		return getBoardList(1,title);
	}
	//�˻��� ����¡
	public List<Board> getBoardList(int page, String title){
		return null;
	}
	//����
	public List<Board> getBoardList(int page, String title, String OrderCol, boolean asc){
		return null;
		//����~~
	}
	
	//�󼼳��� ����
	public int BoardGet(int no){
		return 0;
	}

}
