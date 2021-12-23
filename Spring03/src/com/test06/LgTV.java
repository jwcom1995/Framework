package com.test06;

public class LgTV implements TV{

	public void LgTV() {
		System.out.println("Lg TV 생성");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LG tv on");
	}

	@Override
	public void powerOff() {
		System.out.println("LG tv off");
	}

	@Override
	public void volUp() {
		System.out.println("LG tv vol up");
	}

	@Override
	public void volDown() {
		System.out.println("LG tv vol down");
	}

}
