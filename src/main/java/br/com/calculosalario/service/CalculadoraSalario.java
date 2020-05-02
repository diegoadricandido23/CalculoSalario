package br.com.calculosalario.service;

/**
 * The Class CalculadoraSalario.
 *
 * @author diegoadricandido23@gmail.com
 */
public class CalculadoraSalario {
	
	private static final Double SALARIO_MINIMO = 1039.0;
	
	/**
	 * Calcular salario liquido.
	 *
	 * @param salarioBruto the salario bruto
	 * @return the int
	 */
	public int calcularSalarioLiquido(final Double salarioBruto) {
		
		if(salarioBruto <SALARIO_MINIMO ) {
			System.out.println("Salário menor que o Mínimo R$ " + SALARIO_MINIMO);
			return 0;
		}
		
		final Double percInss = percentualDescontoINSS(salarioBruto);
		System.out.println("Perc Inss: " + percInss);
		
		Double descontoInss = calcularDescontos(salarioBruto, percInss);
		Double salarioLiquido = salarioBruto - descontoInss;
		System.out.println("Desc Inss: " + descontoInss);
		
		final Double percIrrf = percentualDescontoIRRF(salarioLiquido);
		System.out.println("Perc Irrf: " + percIrrf);
		
		if(percIrrf > 0 ) {
			Double descontoIrrf = calcularDescontos(salarioLiquido, percIrrf);
			System.out.println("Desc Irrf: " + descontoIrrf);
			salarioLiquido -= descontoIrrf;
		}
		
		return (int) Math.round(salarioLiquido.doubleValue())	;
	}
	
	/**
	 * Calcular descontos.
	 *
	 * @param salarioBruto the salario bruto
	 * @param desconto the desconto
	 * @return the double
	 */
	private Double calcularDescontos(final Double salario, final Double percentual) {
		if(percentual > 0.0) {
			return (salario * percentual) / 100;
		}
		return 0.0;
	}
	
	/**
	 * Percentual desconto INSS.
	 *
	 * @param salarioBruto the salario bruto
	 * @return the double
	 */
	private Double percentualDescontoINSS(final Double salarioBruto) {
		if(salarioBruto <= Double.valueOf(1500)) {
			return 8.0;
		
		} else if(salarioBruto > Double.valueOf(1500) && salarioBruto <= Double.valueOf(4000)) {
			return 9.0;
		
		} else {
			return 11.0;
		}
	}
	
	/**
	 * Percentual desconto IRRF.
	 *
	 * @param salarioBruto the salario bruto
	 * @return the double
	 */
	private Double percentualDescontoIRRF(final Double salarioBruto) {
		if(salarioBruto <= Double.valueOf(3000)) {
			return 0.0;
		
		} else if(salarioBruto > Double.valueOf(3000) && salarioBruto <= Double.valueOf(7500)) {
			return 7.5;
		
		} else {
			return 15.0;
		}
	}
}
