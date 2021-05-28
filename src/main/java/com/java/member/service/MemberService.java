package com.java.member.service;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

public interface MemberService {
	
	// ���̵� �ߺ�Ȯ��
	public void memberidCheck(ModelAndView mav);
	
	// ȸ������ �̸������� ���� ����
	public void sendEmail(ModelAndView mav);

	// ȸ������
	public void memberRegisterOk(ModelAndView mav);

	// �α���
	public void memberloginOk(ModelAndView mav);
	
	// ȸ������ Ȯ��
	public void memberProfileOk(ModelAndView mav);
		
	// ȸ������ ����
	public void memberUpdate(ModelAndView mav);
	
	// ȸ������ ���� �Ϸ�
	public void memberUpdateOk(ModelAndView mav);

	// ȸ��Ż��
	public int memberDeleteOk(ModelAndView mav);
	
	// ���̵� ã��
	public void memberFindId(ModelAndView mav);

	// ��й�ȣ ã�� - ���̵�, �̸��� ���� Ȯ��
	public int checkIdAndEmail(ModelAndView mav);

	// ��й�ȣ ã�� - ���� �̸��� �����ϱ�
	public void sendEmailToFindPwd(ModelAndView mav);

	// ��й�ȣ ã�� - ��й�ȣ �����ϱ�
	public void changePassword(ModelAndView mav);

}
