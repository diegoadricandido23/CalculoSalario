package br.com.calculosalario.service.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.calculosalario.service.CalculadoraSalario;

public class CalculadoraSalarioTest {
	
	private CalculadoraSalario calculadoraSalario;
	
	@Before
	public void init() {
		calculadoraSalario = new CalculadoraSalario();
	}
	
	@Test
	public void calculaSalarioInss8Porcento() {
		Double salarioBruto = 1500.0;
		int salarioLiq = calculadoraSalario.calcularSalarioLiquido(salarioBruto);
		
		Double inss = salarioBruto - salarioLiq;
		Double perc = (inss / salarioBruto) * 100;
		
		Assert.assertEquals("Valor Liquido", 1380, salarioLiq);
		Assert.assertEquals("Inss %", "8.0", perc.toString());
	}
	
	@Test
	public void calculaSalarioInss9Porcento() {
		Double salarioBruto = 2000.0;
		int salarioLiq = calculadoraSalario.calcularSalarioLiquido(salarioBruto);
		
		Double inss = salarioBruto - salarioLiq;
		Double perc = (inss / salarioBruto) * 100;
		
		Assert.assertEquals("Valor Liquido", 1820, salarioLiq);
		Assert.assertEquals("Inss %", "9.0", perc.toString());
	}
	
	@Test
	public void calculaSalarioInss11Porcento() {
		Double salarioBruto = 4001.0;
		int salarioLiq = calculadoraSalario.calcularSalarioLiquido(salarioBruto);
		
		Assert.assertEquals("Valor Liquido", 3294, salarioLiq);
	}
	
	@Test
	public void calculaSalarioIrrf15Porcento() {
		Double salarioBruto = 10000.0;
		int salarioLiq = calculadoraSalario.calcularSalarioLiquido(salarioBruto);
		
		Assert.assertEquals("Valor Liquido", 7565, salarioLiq);
	}
}
