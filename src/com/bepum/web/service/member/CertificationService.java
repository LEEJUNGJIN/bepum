package com.bepum.web.service.member;

import java.util.List;

import com.bepum.web.entity.Certification;

public class CertificationService {

	// ȭ���� �ε�� ��
	public List<Certification> getCertificationList() {
		return getCertificationList("");
	}
	
	public List<Certification> getCertificationList(String memId) {
		return getCertificationList(memId);
	}
	//������
	public int getCertification(String type, String memId) {
		return getCertification(type, memId);
	}
	//��û�� ����&����
	public int setApplication(String memId) {
		return 0;
	}
	// �ǰ����ܼ�����&����
	public int setHc(String memId) {
		return 0;
	}
	//����������������&����
	public int setFrc(String memId) {
		return 0;
	}

}
