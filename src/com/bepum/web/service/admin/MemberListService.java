package com.bepum.web.service.admin;

import java.util.List;

import com.bepum.web.entity.Member;

public class MemberListService {

	// ȭ���� �ε�� ��
	public List<Member> getMemberList() {
		return getMemberList(1, "");
	}

	// �˻����� ��(���̵��)
	public List<Member> getMemberList(String id) {
		return getMemberList(1, id);
	}

	// �˻��� ����¡
	public List<Member> getMemberList(int page, String id) {
		return null;
	}

	// �󼼳��� ����
	public int MemberGet(int id) {
		return 0;
	}


}
