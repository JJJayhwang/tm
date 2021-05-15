package com.java.member.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.member.dto.MemberDto;

@Component
public class MemberDaoImp implements MemberDao{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int memberinsert(MemberDto memberDto) {
		
		
		return sqlSessionTemplate.insert("member_insert", memberDto);
	}

	@Override
	public int memberidCheck(String id) {
		
		return sqlSessionTemplate.selectOne("id_doublecheck",id);
		
	}

	@Override
	public HashMap<String,Object> loginOk(String id, String password) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("password", password);
		HashMap<String,Object> result = sqlSessionTemplate.selectOne("member_login", map);
		return result;
	}

	// ȸ������ ���� ȭ��
	@Override
	public MemberDto memberUpdate(String id) {
		return sqlSessionTemplate.selectOne("member_select",id);
	}
	
	// ȸ������ ���� �Ϸ�
	@Override
	public int memberUpdateOk(MemberDto memberDto) {
		return sqlSessionTemplate.update("member_update",memberDto);
	}
	
	// ȸ��Ż��
	@Override
	public int memberDelete(String id, String password) {
		return sqlSessionTemplate.update("member_delete", id);
	}

	// ���̵� ã��
	@Override
	public String memberFindId(String name, String phone) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("name", name);
		map.put("phone", phone);
		return sqlSessionTemplate.selectOne("member_findId", map);
	}
	// ��й�ȣ ã�� - ���̵�, �̸��� ã��
	@Override
	public int checkIdAndEmail(String id, String email) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("email", email);
		return sqlSessionTemplate.selectOne("checkIdandEmail", map);
	}

	// ��й�ȣ ã�� - ����Ű ����
	@Override
	public int updateAuthKey(String id, String email, String authKey) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("email", email);
		map.put("authKey", authKey);
		return sqlSessionTemplate.update("updateAuthkey", map);
	}
	// ��й�ȣ ã�� - ��й�ȣ ����
	@Override
	public int changePassword(String id, String password, String authKey) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("password", password);
		map.put("authKey", authKey);
		
		return sqlSessionTemplate.update("changePassword", map);
	}

}
