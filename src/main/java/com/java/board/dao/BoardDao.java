package com.java.board.dao;

import java.util.HashMap;
import java.util.List;

import com.java.board.dto.BoardDto;
import com.java.board.dto.ReplyDto;

public interface BoardDao {

	//�۾���
	public int boardWriteOk(HashMap<String, Object> dtoMap, int isNotice, HashMap<String, String> map2);

	//���� �Խ��� ����Ʈ, ī��Ʈ
	public List<BoardDto> accompanyboardList(int startRow, int endRow, String searchType, String keyword);
	public int accompanyboardCount(String searchType, String keyword);

	//���� �ı� ����Ʈ, ī��Ʈ
	public List<BoardDto> accompanyreviewList(int startRow, int endRow, String searchType, String keyword);
	public int accompanyreviewCount(String searchType, String keyword);

	//��õ ������ ����Ʈ, ī��Ʈ
	public List<BoardDto> recommendpathList(int startRow, int endRow, String searchType, String keyword);
	public int recommendpathCount(String searchType, String keyword);

	//������ �ı� ����Ʈ, ī��Ʈ
	public List<BoardDto> travelreviewList(int startRow, int endRow, String searchType, String keyword);
	public int travelreviewCount(String searchType, String keyword);

	//�󼼱��б�
	public BoardDto boardRead(int boardNo);

	//update
	public BoardDto boardupdate(int boardNo);

	//���ã��
	public int bookmark(String id, BoardDto boardDto);
	//���ã�� �ߺ�üũ
	public int bmCheck(String id, int boardNo);

	//����ۼ�
	public int replyWrite(ReplyDto replyDto);
	//��۸���Ʈ
	public List<ReplyDto> replyList(int boardNo);
	//��ۻ���
	public int replyDel(int replyNo);
	//��ۼ���
	public int replyUpd(ReplyDto replyDto);
	//���� max(group_no) ���ϱ�
	public int maxGroupNo();
	//���� max(sequence_no) ���ϱ�
	public int maxSequenceNo(int groupNo);
}