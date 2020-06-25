package clima;

import org.junit.Assert;
import org.junit.Test;

public class PruebaLluviasDelMes {

	private LluviasDelMes lluvias = new LluviasDelMes();
	
	@Test
	public void inicialmenteNoTieneNingunDia() {
		
		Assert.assertEquals(0, lluvias.contar());
	}
	
	@Test
	public void agregarElPrimerDiaDelMes() {
		
		lluvias.agregar(1);
		
		Assert.assertEquals(1, lluvias.contar());
		Assert.assertTrue(lluvias.contiene(1));
	}

	@Test
	public void agregarElUltimoDiaDelMes() {
		
		lluvias.agregar(31);
		
		Assert.assertEquals(1, lluvias.contar());
		Assert.assertTrue(lluvias.contiene(31));
	}

	@Test
	public void agregarCincoDiasDelMes() {
		
		lluvias.agregar(4);
		lluvias.agregar(29);
		lluvias.agregar(10);
		lluvias.agregar(22);
		lluvias.agregar(2);
		
		comprobarQueContieneLosDias(2, 4, 10, 22, 29);
	}
	
	@Test
	public void agregarCatorceDiasDelMes() {
		
		lluvias.agregar(1);
		lluvias.agregar(4);
		lluvias.agregar(3);
		lluvias.agregar(8);
		lluvias.agregar(2);
		lluvias.agregar(22);
		lluvias.agregar(23);
		lluvias.agregar(15);
		lluvias.agregar(31);
		lluvias.agregar(30);
		lluvias.agregar(12);
		lluvias.agregar(5);
		lluvias.agregar(24);
		lluvias.agregar(18);
		
		comprobarQueContieneLosDias(1, 2, 3, 4, 5, 8, 12, 15, 18, 22, 23, 24, 30, 31);
	}
	
	@Test
	public void agregarOtrasLluviasConSuperposicion() {
		
		lluvias.agregar(3);
		lluvias.agregar(7);
		lluvias.agregar(15);
		
		LluviasDelMes otrasLluvias = new LluviasDelMes();
		otrasLluvias.agregar(7);
		otrasLluvias.agregar(25);
		
		lluvias.agregar(otrasLluvias);
		
		comprobarQueContieneLosDias(3, 7, 15, 25);
	}

	@Test
	public void retenerOtrasLluviasConSuperposicion() {
		
		lluvias.agregar(3);
		lluvias.agregar(7);
		lluvias.agregar(15);
		
		LluviasDelMes otrasLluvias = new LluviasDelMes();
		otrasLluvias.agregar(7);
		otrasLluvias.agregar(25);
		
		lluvias.retener(otrasLluvias);
		
		comprobarQueContieneLosDias(7);
	}

	@Test
	public void removerOtrasLluviasConSuperposicion() {
		
		lluvias.agregar(3);
		lluvias.agregar(7);
		lluvias.agregar(15);
		
		LluviasDelMes otrasLluvias = new LluviasDelMes();
		otrasLluvias.agregar(7);
		otrasLluvias.agregar(25);
		
		lluvias.remover(otrasLluvias);
		
		comprobarQueContieneLosDias(3, 15);
	}
	
	private void comprobarQueContieneLosDias(int... diasQueLlovio) {
		
		Assert.assertEquals(diasQueLlovio.length, lluvias.contar());
		 
		for (int dia = 1, i = 0; dia <= 31; dia++) {
			if ((i < diasQueLlovio.length) && (diasQueLlovio[i] == dia)) {
				Assert.assertTrue(lluvias.contiene(dia));
				i++;
			} else {
				Assert.assertFalse(lluvias.contiene(dia));
			}
		}
	}
}
