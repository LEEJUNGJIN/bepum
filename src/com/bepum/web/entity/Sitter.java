package com.bepum.web.entity;

import java.sql.Time;

public class Sitter {
/* ��Ǫ�� Ȱ������
 * ���̵�
 * ��Ÿ����, �ڱ�Ұ���
 * ��ǰ ���� �ð�
 * ���� ����
 * 
 * + ���� ����, �� ����....
 */
	private String id;
	private String others;
	private String intro;
	private Time str_time;
	private Time end_time;
	private boolean open;
	
	public Sitter() {
		
	}
	
	public Sitter(String id, String others, String intro, Time str_time, Time end_time, boolean open) {
		this.id = id;
		this.others = others;
		this.intro = intro;
		this.str_time = str_time;
		this.end_time= end_time;
		this.open = open;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}

	public Time getStr_time() {
		return str_time;
	}

	public void setStr_time(Time str_time) {
		this.str_time = str_time;
	}

	public Time getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Time end_time) {
		this.end_time = end_time;
	}
	
	
}
