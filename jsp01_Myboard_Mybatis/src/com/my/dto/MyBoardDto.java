package com.my.dto;

import java.util.*;

public class MyBoardDto {
	private int myno;
	private String myname;
	private String mytitle;
	private String mycontent;
	private String mydate;
	
	//생성자, getter & setter
	public MyBoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	//전체생성자
	public MyBoardDto(int myno, String myname, String mytitle, String mycontent, String mydate) {
		super();
		this.myno = myno;
		this.myname = myname;
		this.mytitle = mytitle;
		this.mycontent = mycontent;
		this.mydate = mydate;
	}
	
	//글작성 생성자
	public MyBoardDto(String myname, String mytitle, String mycontent) {
		super();
		this.myname = myname;
		this.mytitle = mytitle;
		this.mycontent = mycontent;
	}
	public int getMyno() {
		return myno;
	}
	public void setMyno(int myno) {
		this.myno = myno;
	}
	public String getMyname() {
		return myname;
	}
	public void setMyname(String myname) {
		this.myname = myname;
	}
	public String getMytitle() {
		return mytitle;
	}
	public void setMytitle(String mytitle) {
		this.mytitle = mytitle;
	}
	public String getMycontent() {
		return mycontent;
	}
	public void setMycontent(String mycontent) {
		this.mycontent = mycontent;
	}
	public String getMydate() {
		return mydate;
	}
	public void setMydate(String mydate) {
		this.mydate = mydate;
	}
	
}
