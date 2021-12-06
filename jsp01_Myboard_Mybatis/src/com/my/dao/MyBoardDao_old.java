package com.my.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.my.dto.MyBoardDto;

public class MyBoardDao_old {
	
	Connection con = null;
	
	public MyBoardDao_old() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("01. driver 연결");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//전체출력
	public List<MyBoardDto> selectAll(){
		try {
			con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KH","KH");
			System.out.println("02. 계정 연걸");
		} catch (SQLException e) {
			System.out.println("02. 계정 연결 실패");
			e.printStackTrace();
		}
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MYBOARD";
		List<MyBoardDto> res= new ArrayList<MyBoardDto>();
		
		try {
			stmt = con.createStatement();
			System.out.println("03.query 준비 : "+sql);
			
			rs=stmt.executeQuery(sql);
			System.out.println("04.query 실행 및 리턴");
			
			while(rs.next()) {
				MyBoardDto dto = new MyBoardDto(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				res.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("3/4 단계 에러");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
				System.out.println("05. db 종료\n");
			} catch (SQLException e) {
				System.out.println("05. db 종료 에러");
				e.printStackTrace();
			}
		}
		return res;
	}
	//선택출력
	public MyBoardDto selectOne(int myno) {
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KH","KH");
			System.out.println("02. 계정연결 성공");
		} catch (SQLException e) {
			System.out.println("error: 계정연결 실패");
			e.printStackTrace();
		}
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql  = "SELECT * FROM MYBOARD WHERE MYNO="+myno;
		MyBoardDto dto = null;
		try {
			stmt = con.prepareStatement(sql);
			System.out.println("03. SQL 준비"+sql);
			rs = stmt.executeQuery(sql);
			System.out.println("04. SQL 실행");
			
			if(rs.next()) {
				dto = new MyBoardDto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			} else {
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println("error : sql 준비/ 실행 오류");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
				System.out.println("05. db 종료\n");
			} catch (SQLException e) {
				System.out.println("error : db close");
				e.printStackTrace();
			}
		}
		return dto;
	}
	//추가
	public int insert(MyBoardDto dto) {
		
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KH","KH");
			System.out.println("02. 계정연결 실패");
		} catch (SQLException e) {
			System.out.println("error : 계정연결 실패");
			e.printStackTrace();
		}
		
		PreparedStatement pstm= null;
		String sql = "INSERT INTO MYBOARD "+ 
				"VALUES(MYSEQ.NEXTVAL,?,?,?,SYSDATE)";
		int res=0;
		
		try {
			pstm=con.prepareStatement(sql);
			
			pstm.setString(1, dto.getMyname());
			pstm.setString(2, dto.getMytitle());
			pstm.setString(3, dto.getMycontent());
			
			System.out.println("03. sql 준비 : "+sql);
			
			res=pstm.executeUpdate();
			System.out.println("04. sql 실행");
		} catch (SQLException e) {
			System.out.println("error : query 준비/실행 실패");
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
				System.out.println("05.db 종료\n");
			} catch (SQLException e) {
				System.out.println("error : db종료 실패");
				e.printStackTrace();
			}
		}
		return res;
	}
	//삭제
	public int delete(int myno) {
		
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KH","KH");
			System.out.println("02.계정접속 성공");
		} catch (SQLException e) {
			System.out.println("error : 계정접속 실패");
			e.printStackTrace();
		}
		
		PreparedStatement pstm = null;
		String sql = "DELETE FROM MYBOARD WHERE MYNO=?";
		int res=0;
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, myno);
			System.out.println("03. query 준비 : "+sql);
			
			res= pstm.executeUpdate();
			System.out.println("04. query 실행");
		} catch (SQLException e) {
			System.out.println("error : query 준비/실행 실패");
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
				System.out.println("05. db 종료 \n");
			} catch (SQLException e) {
				System.out.println("error : db 종료 실패");
				e.printStackTrace();
			}
		}
		
		return res;
	}
	
	public int update(MyBoardDto dto) {
		
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KH","KH");
			System.out.println("02. 계정 접속");
		} catch (SQLException e) {
			System.out.println("error : 계정접속 실패");
			e.printStackTrace();
		}
		
		PreparedStatement pstm = null;
		String sql = "UPDATE MYBOARD SET MYTITLE = ?, MYCONTENT = ? WHERE MYNO = ?";
		int res=0;
		
		try {
			pstm=con.prepareStatement(sql);
			System.out.println("03. query 준비 : "+sql);
			
			pstm.setString(1, dto.getMytitle());
			pstm.setString(2, dto.getMycontent());
			pstm.setInt(3, dto.getMyno());
			
			res=pstm.executeUpdate();
			System.out.println("04. query 실행");
		} catch (SQLException e) {
			System.out.println("error : query 준비/실행 실패");
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
				System.out.println("05. db 종료");
			} catch (SQLException e) {
				System.out.println("error : db 종료 실패");
				e.printStackTrace();
			}
		}
		
		return res;
	}
}
