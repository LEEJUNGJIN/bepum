package com.bepum.web.service.member;

import java.util.List;

import com.bepum.web.entity.Message;

public class MessageService {

	//�޼������ (��ü�޼���, �߿�޼���, �����޼���, ���������޼���)
	//ȭ���� �ε�� ��
	public List<Message> getMessageList(){
		return getMessageList(1,"");
	}
	//�˻����� ��
	public List<Message> getMessagedList(String fromID /*, String title �� �־�ߵǳ�?*/){
		return getMessageList(1, fromID);
	}

	//�˻��� ����¡
	public List<Message> getMessageList(int page, String fromID){
		return null;
	}
	//����
	public List<Message> getMessageList(int page, String fromID, String OrderCol, boolean asc){
		return null;
		//����~~
	}
	
	//�󼼳��� ����
	public int MessageGet(int num){
		return 0;
	}
	
	
}
