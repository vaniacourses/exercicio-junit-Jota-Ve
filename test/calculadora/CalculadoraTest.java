package calculadora;


import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {

	private Calculadora calc;

	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}

	@DisplayName("Testa a soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);
		Assertions.assertEquals(9, soma);
	}

	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}

	@Test
	public void testDivisaoPorZero() {
		try {
			calc.divisao(8, 0);
			fail("Exceção não lançada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}
	}

	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

	@Test
	public void testSomatoria(){
		int somatoria = calc.somatoria(3);
		assertEquals(somatoria, 6);
	}

	@Test
	public void testSomatoriaZero(){
		int somatoria = calc.somatoria(0);
		assertEquals(somatoria, 0);
	}

	@Test
	public void testEhPositivo(){
		assertTrue(calc.ehPositivo(1));
	}

	@Test
	public void testZeroEhPositivo(){
		assertTrue(calc.ehPositivo(0));
	}

	@Test
	public void testNaoEhPositivo(){
		assertFalse(calc.ehPositivo(-1));
	}

	@Test
	public void testComparaIgualdade(){
		assertEquals(calc.compara(5, 5), 0);
	}

	@Test
	public void testComparaMenorComMaior(){
		assertEquals(calc.compara(1, 2), -1);
	}

	@Test
	public void testComparaMaiorComMenor(){
		assertEquals(calc.compara(7, 0), 1);
	}

}
