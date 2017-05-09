package com.example;

import java.io.File;
import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class AdviceBeforeProfilador implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		if(method.getName().equals("persistir") && args[1] != null){
			File arquivoAlvo = (File) args[1];
			if (arquivoAlvo.exists()) {
				System.out.println("Before Advice: arquivo já existe");
				args[1] = null;
			}
		}
	}
}
