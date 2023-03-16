package com.myboot03.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myboot03.member.vo.MemberVO;


@Mapper
@Repository("memberDAO")
public interface MemberDAO {
	
	 // 해당 메서드명과 member.xml의 sql문이 같아야 실행됨. 
	 public List<MemberVO> selectAllMemberList() throws DataAccessException;
	 public int insertMember(MemberVO memberVO) throws DataAccessException ;
	 public int deleteMember(String id) throws DataAccessException;
	 public MemberVO loginById(MemberVO memberVO) throws DataAccessException;
}
