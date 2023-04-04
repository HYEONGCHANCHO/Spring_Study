package com.chan.aopex.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceTraceAdvice {

	//around 유형의 어드바이스를 적용하기 위해 만든 메서드=> 반드시 ProceedingJoinPoint를 매개값으로 받아야 한다.
	public Object trace(ProceedingJoinPoint jp) throws Throwable {
		String executeMethodInfoString = jp.getSignature().toShortString();
		System.out.println(executeMethodInfoString + "시작");
		long start = System.currentTimeMillis();
		try {
			Object result = jp.proceed();
			// 타겟 객체의 메서드를 실행시키는 메서드 (이건 고정임)
			return result;
		} finally {
			long finish = System.currentTimeMillis();
			System.out.println(executeMethodInfoString + "종료");
			long execTtime = finish -start;
			System.out.println(executeMethodInfoString +"실행시간:" +execTtime + "ms");
		} 

	}
}