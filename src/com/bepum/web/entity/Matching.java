package com.bepum.web.entity;

import java.util.Date;

public class Matching extends Bepumi{
/*
 * no, ��û��, ��Ǫ��, ��Ǫ�� ���
 * ��ǰ ��¥, ��ǰ �ð�, ��ǰ�� ��û�� ��¥, �Ʊ� �̸�, �Ʊ� ����, �䱸���� , 
 * ���� ��Ȳ
 */
	private String no;
	private String requestID;
	private String bepumiID;
	private Date reqDate;
	private Date acceptDate;
	private Date bepumDate;
	private String startTime;
	private String endTime;
	
	private String requirement;
	private String status;
	
	public Matching() {
		
	}


	public Matching(String no, String requestID, String bepumiID, Date reqDate, Date acceptDate, Date bepumDate,
			String startTime, String endTime, String requirement, String status) {
		super();
		this.no = no;
		this.requestID = requestID;
		this.bepumiID = bepumiID;
		this.reqDate = reqDate;
		this.acceptDate = acceptDate;
		this.bepumDate = bepumDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.requirement = requirement;
		this.status = status;
	}





	public String getRequestID() {
		return requestID;
	}

	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}

	public String getBepumiID() {
		return bepumiID;
	}

	public void setBepumiID(String bepumiID) {
		this.bepumiID = bepumiID;
	}

	public Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

	public Date getAcceptDate() {
		return acceptDate;
	}

	public void setAcceptDate(Date acceptDate) {
		this.acceptDate = acceptDate;
	}

	public Date getBepumDate() {
		return bepumDate;
	}

	public void setBepumDate(Date bepumDate) {
		this.bepumDate = bepumDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getNo() {
		return no;
	}


	public void setNo(String no) {
		this.no = no;
	}

	

	
}
