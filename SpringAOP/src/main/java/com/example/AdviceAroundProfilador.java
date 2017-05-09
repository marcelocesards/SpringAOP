package com.example;

import java.util.ArrayList;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AdviceAroundProfilador implements MethodInterceptor {
	private List<Long> tempos = new ArrayList<Long>();

	public List<Long> getTempos() {
		return tempos;
	}

	public void setTempos(List<Long> tempos) {
		this.tempos = tempos;
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		long momentoInicial = System.currentTimeMillis();
		
		Object resultado =  invocation.proceed();
		long tempo = System.currentTimeMillis() - momentoInicial;
		getTempos().add(tempo);
		System.out.println("Tempo para executar " + tempo + "ms");
		return resultado;
	}

}
