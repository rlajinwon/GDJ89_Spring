package com.winter.app.parts;

import org.springframework.stereotype.Component;

public class LeftArm implements Arm{
	
	@Override
	public void punch() {
		System.out.println("레프트 훅");
		
		
	}
	

}
