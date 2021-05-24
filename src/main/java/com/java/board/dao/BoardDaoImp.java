package com.java.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.board.dto.BoardDto;
import com.java.board.dto.ReplyDto;

@Component
public class BoardDaoImp implements BoardDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	//�۾���
	@Override
	public int boardWriteOk(HashMap<String, Object> dtoMap, int isNotice, HashMap<String, String> map2) {
		
		if (isNotice == 1) {
			return sqlSessionTemplate.insert("notice_insert", dtoMap);	//������
			
		} else if (map2.get("file") != "true" && map2.get("map").isEmpty() != true) {
			return sqlSessionTemplate.insert("board_file_map_insert", dtoMap);	//�Ϲݱ�_����,���� ����
			
		} else if (map2.get("file") != "true" && map2.get("map").isEmpty() == true) {
			return sqlSessionTemplate.insert("board_file_insert", dtoMap);	//�Ϲݱ�_���ϸ�
			
		} else if (map2.get("file") == "true" && map2.get("map").isEmpty() != true) {
			return sqlSessionTemplate.insert("board_map_insert", dtoMap);	//�Ϲݱ�_������
			
		} 
		return sqlSessionTemplate.insert("board_insert", dtoMap);	//�Ϲݱ�_�۸�
	}

	//���� �Խ��� ����Ʈ
	@Override
	public List<BoardDto> accompanyboardList(int startRow, int endRow, String searchType, String keyword) {
		Map<String, Object> Map = new HashMap<String, Object>();
		Map.put("startRow", startRow);
		Map.put("endRow", endRow);
		Map.put("searchType", searchType);
		Map.put("keyword", keyword);
		
		return sqlSessionTemplate.selectList("accompanyboard_list", Map);
	}

	//���� �Խ��� read ī��Ʈ
	@Override
	public int accompanyboardCount(String searchType, String keyword) {
		Map<String, Object> Map = new HashMap<String, Object>();
		Map.put("searchType", searchType);
		Map.put("keyword", keyword);
		
		return sqlSessionTemplate.selectOne("accompanyboard_getCount", Map);
	}

	//���� �ı� �Խ��� ����Ʈ
	@Override
	public List<BoardDto> accompanyreviewList(int startRow, int endRow, String searchType, String keyword) {
		Map<String, Object> Map = new HashMap<String, Object>();
		Map.put("startRow", startRow);
		Map.put("endRow", endRow);
		Map.put("searchType", searchType);
		Map.put("keyword", keyword);
		
		return sqlSessionTemplate.selectList("accompanyreview_list", Map);
	}

	//���� �ı� �Խ��� read ī��Ʈ
	@Override
	public int accompanyreviewCount(String searchType, String keyword) {
		Map<String, Object> Map = new HashMap<String, Object>();
		Map.put("searchType", searchType);
		Map.put("keyword", keyword);
		
		return sqlSessionTemplate.selectOne("accompanyreview_getCount", Map);
	}

	//��õ ���� ��� �Խ��� ����Ʈ
	@Override
	public List<BoardDto> recommendpathList(int startRow, int endRow, String searchType, String keyword) {
		Map<String, Object> Map = new HashMap<String, Object>();
		Map.put("startRow", startRow);
		Map.put("endRow", endRow);
		Map.put("searchType", searchType);
		Map.put("keyword", keyword);
		
		return sqlSessionTemplate.selectList("recommendpath_list", Map);
	}

	
	//��õ ���� ��� read ī��Ʈ
	@Override
	public int recommendpathCount(String searchType, String keyword) {
		Map<String, Object> Map = new HashMap<String, Object>();
		Map.put("searchType", searchType);
		Map.put("keyword", keyword);
		
		return sqlSessionTemplate.selectOne("recommendpath_getCount", Map);
	}


	//������ �ı� �Խ��� ����Ʈ
	@Override
	public List<BoardDto> travelreviewList(int startRow, int endRow, String searchType, String keyword) {
		Map<String, Object> Map = new HashMap<String, Object>();
		Map.put("startRow", startRow);
		Map.put("endRow", endRow);
		Map.put("searchType", searchType);
		Map.put("keyword", keyword);
		
		return sqlSessionTemplate.selectList("travelreview_list", Map);
	}
	
	//������ �ı� read ī��Ʈ
	@Override
	public int travelreviewCount(String searchType, String keyword) {
		Map<String, Object> Map = new HashMap<String, Object>();
		Map.put("searchType", searchType);
		Map.put("keyword", keyword);
		
		return sqlSessionTemplate.selectOne("travelreview_getCount", Map);
	}

	//�� �󼼺���
	@Override
	public BoardDto boardRead(int boardNo) {
		sqlSessionTemplate.update("board_view", boardNo);
		return sqlSessionTemplate.selectOne("board_read", boardNo);
	}

	//update
	@Override
	public BoardDto boardupdate(int boardNo) {
		
		return sqlSessionTemplate.selectOne("board_update", boardNo);
	}
	
	//=====================================================================���ã��
	//���ã��
	@Override
	public int bookmark(String id, BoardDto boardDto) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("boardDto", boardDto);
				
		return sqlSessionTemplate.insert("bookmark", map);
	}
	
	//���ã�� �ߺ�üũ
	@Override
	public int bmCheck(String id, int boardNo) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("boardNo", Integer.toString(boardNo));
		
		return sqlSessionTemplate.selectOne("bmCheck", map);
	}
	
	//=====================================================================���
	//����Է�
	@Override
	public int replyWrite(ReplyDto replyDto) {
		return sqlSessionTemplate.insert("replyWrite", replyDto);
	}
	
	//��۸���Ʈ
	@Override
	public List<ReplyDto> replyList(int boardNo) {
		return sqlSessionTemplate.selectList("replyList", boardNo);
	}
	
	//��ۻ���
	@Override
	public int replyDel(int replyNo) {
		return sqlSessionTemplate.update("replyDel", replyNo);
	}
	
	//��ۼ���
	@Override
	public int replyUpd(ReplyDto replyDto) {
		return sqlSessionTemplate.update("replyUpd", replyDto);
	}

	//���� max(group_no) ���ϱ�
	@Override
	public int maxGroupNo() {
		return sqlSessionTemplate.selectOne("maxGNo");
	}

	//���� max(sequence_no) ���ϱ�
	@Override
	public int maxSequenceNo(int groupNo) {
		return sqlSessionTemplate.selectOne("maxSeqNo", groupNo);
	}
	

	
}