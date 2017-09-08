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
	private String writerId;
	private int hit;
	private Date regDate;
	
	public Board() {
		
	}

	public Board(String no, String title, String content, String writerId, int hit, Date regDate) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.writerId = writerId;
		this.hit = hit;
		this.regDate = regDate;
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
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
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
