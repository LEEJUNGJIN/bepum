package com.bepum.web.entity;

import java.sql.Time;

public class Bepumi extends Member {
/* ��Ǫ�� Ȱ������
 * ���̵�
 * ��Ÿ����, �ڱ�Ұ���
 * ��ǰ ���� �ð�
 * ���� ����
 * 
 * + ���� ����, �� ����....
 */
	
	private String id;
	private String address;
	private String phoneNum;

	public Bepumi() {
		
	}
	
	public Bepumi(String id, String address, String phoneNum) {
		super();
		this.id = id;
		this.address = address;
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	

	
}
