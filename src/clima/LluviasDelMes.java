package clima;

/**
 * Registro de lluvias en los días de un mes.
 * 
 */
public class LluviasDelMes {

	private boolean[] llovio;
	
	/**
	 * @post registro del mes sin ningún día lluvioso.
	 */
	public LluviasDelMes() {
		llovio = new boolean[31];
	}

	/**
	 * @pre 'dia' está en el rango [1-31] .
	 * @post registra que el día del mes llovió.
	 * @param dia : número del día del mes.
	 */
	public void agregar(int dia) {
		validar(dia);
		llovio[dia - 1] = true;
	}
	
	/**
	 * @pre 'dia' está en el rango [1-31].
	 * @param dia : número del día del mes.
	 * @return si llovió el día del mes.
	 */
	public boolean contiene(int dia) {
		
		validar(dia);
		return llovio[dia - 1];
	}

	/**
	 * @return cantidad de días que llovieron el mes.
	 */
	public int contar() {

		int diasLluviosos = 0;
		
		for (int i = 0; i < llovio.length; i++) {
			if (llovio[i]) {
				diasLluviosos++;
			}
		}
		
		return diasLluviosos;
	}

	/**
	 * @post agrega los días lluviosos de 'otro'.
	 * @param otro
	 */
	public void agregar(LluviasDelMes otro) {
		
		for (int i = 0; i < llovio.length; i++) {
			llovio[i] = (llovio[i] || otro.llovio[i]);
		}
	}

	/**
	 * @post deja solo aquellos días lluviosos que también están en 'otro'.
	 * @param otro
	 */
	public void retener(LluviasDelMes otro) {
		
		for (int i = 0; i < llovio.length; i++) {
			llovio[i] = (llovio[i] && otro.llovio[i]);
		}
	}
	
	private void validar(int dia) {
		if ((dia < 1) || (dia > 31)) {
			throw new IllegalArgumentException("No es un día del mes: " + dia);
		}
	}
}
