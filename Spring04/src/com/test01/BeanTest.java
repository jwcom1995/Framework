package com.test01;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BeanTest {
	
	private MyClass myClass;
	
	public BeanTest() {
		System.out.println("\n 기본 생정자 실행");
	}
	
	public BeanTest(Date date) {
		System.out.println("\n 날짜 생성자(date:"+date+")");
	}
	
	public void setMyClass(MyClass myClass) {
		this.myClass = myClass;
		System.out.println("\n setMyClass() 호출: "+myClass);
	}
	
	public void setDate(Date date) {
		System.out.println("\n setDate() 호출:"+date);
	}
	public void setNumber(int num) {
		System.out.println("\n setNumber() 호출:"+num);
	}
	public void setArray(String[] arr) {
		System.out.println("\n setArray() 호출");
		for(String value:arr) {
			System.out.println("이름: "+value);
		}
	}
	public void setList(List<String> list) {
		System.out.println("\n setList() 호출");
		for(String value:list) {
			System.out.println("value: "+value);
		}
	}
	public void setSet(Set<String> set) {
		System.out.println("\n setSet() 호출");
		for(String value:set) {
			System.out.println("val:"+value);
		}
	}
	public void setMap(Map<String,String> map) {
		System.out.println("\n setMap() 호출");
		Collection<String> values=map.values();
		for(String val:values) {
			System.out.println(val);
		}
	}
	
	public void setScore(List<Score> list) {
		System.out.println("\n setScore() 호출");
		for(Score sc:list) {
			System.out.println(sc);
		}
	}
}