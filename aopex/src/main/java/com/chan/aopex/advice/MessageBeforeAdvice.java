package com.chan.aopex.advice;

import org.springframework.stereotype.Component;

@Component("messageBeforeAdvice")
public class MessageBeforeAdvice {
	public void beforeMessage() {
		System.out.println("조회 작업을 실행할 때 나타나는 beforeAdvice Message");
	}
	public void afterMessage() {
		System.out.println("조회 작업을 실행하고 난 후 에 무조건 실행되는 after Advice Message");
	}
	public void afterRtnMessage() {
		System.out.println("조회 작업을 실행하고 난 후 에 정상적으로 문제 없이 실행되었을 때  afterReturning Advice Message");
	}
	public void afterThrowMessage() {
		System.out.println("조회 작업을 실행하는데 문제가 발생되었을 때 afterThrowing Advice Message");
	}
}
