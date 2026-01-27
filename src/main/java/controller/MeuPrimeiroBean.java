package controller;

import org.springframework.stereotype.Component;

@Component
public class MeuPrimeiroBean {
	private String ola = "test";

	public String getOla() {
		return ola;
	}

	public void setOla(String ola) {
		this.ola = ola;
	}
}
