package com.my.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.my.dto.MyBoardDto;

public class MyBoardDao extends SqlMapConfig{
	
	private String boardMapper = "com.my.myboard.";
	
	//전체출력
	public List<MyBoardDto> selectAll(){
		List<MyBoardDto> res = new ArrayList<MyBoardDto>();
		
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);  //true : auto commit을 의미
		
		res = session.selectList("com.my.myboard.selectAll");
		session.close();
		return res;
	}
	//선택출력
	public MyBoardDto selectOne(int myno) {
		SqlSession session=null;
		MyBoardDto res =null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			
			//넣어줄값 myno를 인자로 넣어줌
			res =session.selectOne("com.my.myboard.selectOne",myno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}
	//추가
	public int insert(MyBoardDto dto) {
		
		SqlSession session = null;
		int res= 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.insert(boardMapper+"myinsert",dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}
	//삭제
	public int delete(int myno) {
		
		
		return 0;
	}
	
	public int update(MyBoardDto dto) {
		
		
		return 0;
	}
}
