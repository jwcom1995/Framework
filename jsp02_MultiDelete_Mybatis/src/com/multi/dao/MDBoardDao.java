package com.multi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.multi.dto.MDBoardDto;

public class MDBoardDao extends SqlMapConfig{
	
	private String namespace ="com.my.multi.";
	
	//게시판 목록
	public List<MDBoardDto> selectAll(){
		SqlSession session = null;
		List<MDBoardDto> res = null;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.selectList(namespace+"selectAll");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return res;
	}
	
	//글 선택
	public MDBoardDto selectOne(int seq) {
		SqlSession session=null;
		MDBoardDto res = null;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.selectOne(namespace+"selectOne",seq);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return res;
	}
	
	//글 작성
	public int insert(MDBoardDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace+"insert",dto);
			
			if(res>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}
	
	//글 수정
	public int update(MDBoardDto dto) {
		
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.update(namespace+"update",dto);
			
			if(res>0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}
	
	//글 삭제
	public int delete(int seq) {
		
		SqlSession session=null;
		int res = 0;
		
		try {
			session=getSqlSessionFactory().openSession(false);
			res=session.delete(namespace + "delete", seq);
			
			if(res>0) {
				session.commit();
			}else {
				session.rollback();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		
		return res;
	}
	
	//다중 삭제
	public int multiDelete(String[] seq) {
		
		int res=0;
		
		Map<String,String[]> map = new HashMap<String,String[]>();
		map.put("seq", seq);
		
		SqlSession session=null;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.delete(namespace+"muldel",map);
			
			//삭제할 개수와 삭제가 완료된 갯수가 동일한지 확인
			if(res == seq.length) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
	}

}
