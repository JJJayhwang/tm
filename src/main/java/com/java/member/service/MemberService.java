package com.java.member.service;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

public interface MemberService {
public void memberRegisterOk(ModelAndView mav);
	
	public void memberidCheck(ModelAndView mav);

	public void memberlogin(ModelAndView mav);

	public void memberloginOk(ModelAndView mav);

	public void main(ModelAndView mav);

	public void memberloginOut(ModelAndView mav);

	public void memberUpdateOk(ModelAndView mav);

	public void memberUpdate(ModelAndView mav);
	
	public void memberDelete(ModelAndView mav);
	
	public int memberDeleteOk(ModelAndView mav);

	// ���� �߰��� 
	public void sendEmail(ModelAndView mav);

	public void memberFindId(ModelAndView mav);

	public int checkIdAndEmail(ModelAndView mav);

	public void sendEmailToFindPwd(ModelAndView mav);

	public void changePassword(ModelAndView mav);

	public void memberProfileOk(ModelAndView mav);
}