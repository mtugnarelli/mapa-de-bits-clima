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

	private void validar(int dia) {
		if ((dia < 1) || (dia > 31)) {
			throw new IllegalArgumentException("No es un día del mes: " + dia);
		}
	}
}
