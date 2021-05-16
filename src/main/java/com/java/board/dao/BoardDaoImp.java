package com.java.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.java.board.dto.BoardDto;

@Component
public class BoardDaoImp implements BoardDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	//�۾���
	@Override
	public int boardWriteOk(HashMap<String, Object> dtoMap, int isNotice) {
		if (isNotice == 1) {
			return sqlSessionTemplate.insert("notice_insert", dtoMap);
		}
		return sqlSessionTemplate.insert("board_insert", dtoMap);
	}

	//���� �Խ��� ����Ʈ
	@Override
	public List<BoardDto> accompanyboardList(int startRow, int endRow) {
		Map<String, Integer> Map = new HashMap<String, Integer>();
		Map.put("startRow", startRow);
		Map.put("endRow", endRow);
		
		return sqlSessionTemplate.selectList("accompanyboard_list", Map);
	}

	//���� �Խ��� read ī��Ʈ
	@Override
	public int accompanyboardCount() {
		
		return sqlSessionTemplate.selectOne("accompanyboard_getCount");
	}

	//���� �ı� �Խ��� ����Ʈ
	@Override
	public List<BoardDto> accompanyreviewList(int startRow, int endRow) {
		Map<String, Integer> Map = new HashMap<String, Integer>();
		Map.put("startRow", startRow);
		Map.put("endRow", endRow);
		
		return sqlSessionTemplate.selectList("accompanyreview_list", Map);
	}

	//���� �ı� �Խ��� read ī��Ʈ
	@Override
	public int accompanyreviewCount() {
		
		return sqlSessionTemplate.selectOne("accompanyreview_getCount");
	}

	//��õ ���� ��� �Խ��� ����Ʈ
	@Override
	public List<BoardDto> recommendpathList(int startRow, int endRow) {
		Map<String, Integer> Map = new HashMap<String, Integer>();
		Map.put("startRow", startRow);
		Map.put("endRow", endRow);
		
		return sqlSessionTemplate.selectList("recommendpath_list", Map);
	}

	
	//��õ ���� ��� read ī��Ʈ
	@Override
	public int recommendpathCount() {
		
		return sqlSessionTemplate.selectOne("recommendpath_getCount");
	}


	//������ �ı� �Խ��� ����Ʈ
	@Override
	public List<BoardDto> travelreviewList(int startRow, int endRow) {
		Map<String, Integer> Map = new HashMap<String, Integer>();
		Map.put("startRow", startRow);
		Map.put("endRow", endRow);
		
		return sqlSessionTemplate.selectList("travelreview_list", Map);
	}
	
	//������ �ı� read ī��Ʈ
	@Override
	public int travelreviewCount() {

		return sqlSessionTemplate.selectOne("travelreview_getCount");
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

	
}