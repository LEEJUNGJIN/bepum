package com.bepum.web.service.member;

import java.util.List;

import com.bepum.web.entity.Message;

public class MessageService {

	//�޼������ (��ü�޼���, �߿�޼���, �����޼���, ���������޼���)
	//ȭ���� �ε�� ��
	public List<Message> getMessageList(){
		return getMessageList(1,"" ,"");
	}
	//�˻����� ��
	public List<Message> getMessagedList(String select, String searching){
		return getMessageList(1, select, searching);
	}

	//�˻��� ����¡
	public List<Message> getMessageList(int page, String select, String searching){
		return null;
	}
	
	//����
	public List<Message> getMessageList(int page,String select, String searching, String OrderCol, boolean asc){
		return null;
		//����~~
	}
	
	//�󼼳��� ����
	public int MessageGet(int num){
		return 0;
	}
	
	
}
