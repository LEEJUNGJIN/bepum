package com.bepum.web.service.admin;

import java.util.List;

import com.bepum.web.entity.Matching;

public class MatchingService {
	//ȭ���� �ε�� �� 
	public List<Matching> getMatchingList(){
		return getMatchingList(1,"");
	}
	//�˻����� ��
	public List<Matching> getMatchingList(String applicant){
		return getMatchingList(1,applicant);
	}
	//�˻��� ����¡
	public List<Matching> getMatchingList(int page, String applicant){
		return null;
	}
	//���� ���� ���� �з�
	public List<Matching> getMatchingList(int  progress){
		return null;
		//����~~
	}
	
	//�󼼳��� ����
	public int MatchingGet(int no){
		return 0;
	}
}
