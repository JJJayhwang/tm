package com.java.board.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.java.board.dto.ReplyDto;

public interface BoardService {

	//�۾���
	void boardWriteOk(ModelAndView mav);

	//�Խ��� ����Ʈ(����, �����ı�, ��õ������, �������ı�
	void accompanyboardList(ModelAndView mav);
	void accompanyreviewList(ModelAndView mav);
	void recommendpathList(ModelAndView mav);
	void travelreviewList(ModelAndView mav);

	//�б�
	void boardRead(ModelAndView mav);

	//����
	void boardUpdate(ModelAndView mav);
	
	//���ã��
	int bookmark(ModelAndView mav);
	//���ã�� �ߺ�üũ
	int bmCheck(String id, int boardNo);
	
	//����Է�
	int replyWrite(ReplyDto replyDto);
	//��۸���Ʈ
	List<ReplyDto> replyList(int boardNo);
	//��ۻ���
	int replyDel(int replyNo);
	//��ۼ���
	int replyUpd(ReplyDto replyDto);

	
}