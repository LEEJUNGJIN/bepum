package com.bepum.web.service.sitter;

import java.util.HashMap;
import java.util.List;

import com.bepum.web.entity.Board;
import com.bepum.web.entity.Matching;
import com.bepum.web.entity.Member;
import com.bepum.web.entity.Sitter;

public class SitterSearchingService {
	
		//ȭ���� �ε�� �� 
		public HashMap<Member, Sitter> getSearchingList(){
			return null;
		}
		
		//������, ��¥��, �ð����� ������ �˻�
		public HashMap<Member, Sitter> getSearchingList(String searchTarget, String value) {
			// searchTarget ������, ��¥��, �ð��� / value: �˻���
			return getSearchingList(1, searchTarget, value);

		}

		public HashMap<Member, Sitter> getSearchingList(int page, String searchTarget, String value) {
			// searchTarget ������/��¥��/�ð��� / value: �˻���
			return getSearchingList(page, searchTarget, "", "", value);

		}
		
		public HashMap<Member, Sitter> getSearchingList(int page, String searchTarget, String searchTarget2, String value) {
			// searchTarget ������,��¥�� / ��¥��,�ð��� / ������,�ð��� / value: �˻���
			return getSearchingList(page, searchTarget, searchTarget2, "", value);

		}
		
		public HashMap<Member, Sitter> getSearchingList(int page, String searchTarget, String searchTarget2, String searchTarget3, String value) {
			// searchTarget ������, ��¥��, �ð��� / value: �˻���
			return getSearchingList(page, searchTarget, searchTarget2, searchTarget3, value, "");

		}

		// ���� -> ����ϼ�, ��޼����� ����
		public HashMap<Member, Sitter> getSearchingList(int page, String searchTarget, String searchTarget2, String searchTarget3, String value, String OrderCol) {
			return null;
		}
		
		// Ŭ���ϸ� �ش� ��� ���� �����ְ�
		public HashMap<Member, Sitter> get(String id) {
			return null;
		}
		
}
