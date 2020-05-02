/**
 * 
 */
package br.com.calculosalario.main;

import br.com.calculosalario.service.CalculadoraSalario;

/**
 * @author dcandido
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Double salarioBruto = 10000.0;
		CalculadoraSalario calculadoraSalario = new CalculadoraSalario();
		System.out.println("Salario Bruto : " + salarioBruto);
		
		final int salarioLiquido = calculadoraSalario.calcularSalarioLiquido(salarioBruto);
		System.out.println("Salario Liq : " + salarioLiquido);

	}

}
