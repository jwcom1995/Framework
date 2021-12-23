package com.test06;

public class SamsungTV implements TV{
	
	public SamsungTV() {
		System.out.println("samsung tv 생성");
	}
	
	@Override
	public void powerOn() {
		System.out.println("Samsung tv on");
	}

	@Override
	public void powerOff() {
		System.out.println("Samsung tv off");
	}

	@Override
	public void volUp() {
		System.out.println("Samsung tv vol up");
	}

	@Override
	public void volDown() {
		System.out.println("Samsung tv vol down");
	}

}
