package com.bepum.web.service.admin;

import java.util.List;

import com.bepum.web.entity.Matching;

public class MatchingService {
	//ȭ���� �ε�� �� 
	
	
	public List<Matching> getMatchingList(){
		return getMatchingList(1,"", "");
	}	
	
	//�˻����� ��
	public List<Matching> getMatchingList( int page, String searchTarget, String value) {
		// searchTarget ���̵�, ��Ǫ�� �̸�, ������ / value: �˻���
		return getMatchingList( page, searchTarget, value);
	}
	
	
	//���� ���� ���� �з�
	public List<Matching> getMatchingList(int page, int  progress){
		return null;
		//����~~
	}
	
	//�󼼳��� ����
	public int MatchingGet(int no){
		return 0;
	}
}
