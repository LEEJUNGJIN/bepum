package com.bepum.web.service.sitter;

import java.util.HashMap;
import java.util.List;

import com.bepum.web.entity.Matching;
import com.bepum.web.entity.Member;

public class MatchingService {
	// ��û�� ��Ǫ�� ��������� ��

	public List<Matching> getMatchingList(String role) { // ��û������ ��Ǫ������ Ȯ��
		return getMatchingList(role, 1);
	}

	public List<Matching> getMatchingList(String role, int page) {// ������ �ѱ�
		return getMatchingList(role, page);
	}

	// ��û���� ��� ���̵�, ��Ǫ�� �̸�, �������� ���� ��Ī ���� �˻�
	public List<Matching> getMatchingList(String role, String searchTarget, String value) {
		// searchTarget ���̵�, ��Ǫ�� �̸�, ������ / value: �˻���
		return getMatchingList(role, 1, searchTarget, value);

	}

	public List<Matching> getMatchingList(String role, int page, String searchTarget, String value) {
		// searchTarget ���̵�, ��Ǫ�� �̸�, ������ / value: �˻���
		return getMatchingList(role, page, searchTarget, value);

	}

	// ���� -> ��Ī ���� ���� ����/����/��û ���� ����
	public List<Matching> getMatchingList(String role, int page, String searchTarget, String value, String OrderCol) {
		return null;
	}

	// Ŭ���ϸ� �ش� ��� ���� �����ְ�
	public HashMap<Member, Matching> get(String id) {
		return null;
	}

	// ��������� ��û�� ���
	// ��Ī ����/����
	public int accept(boolean acc) {
		return 0;
	}
}
