package com.bepum.web.entity;

import java.util.Date;

public class Board {
/*
 * ��� �Խ���
 * no, �Խù� ����, 
 * ����, �۾���, 
 * �ۼ� ��¥, ���� ����
 */
	private String no;
	private String title;
	private String content;
	private String writer;
	private int hit;
	private Date regDate;
	private boolean open;
	
	public Board() {
		
	}

	public Board(String no, String title, String content, String writer, int hit, Date regDate, boolean open) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.hit = hit;
		this.regDate = regDate;
		this.open = open;
	}
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}

	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}




	
}
