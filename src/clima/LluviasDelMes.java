package clima;

/**
 * Registro de lluvias en los días de un mes.
 * 
 */
public class LluviasDelMes {

	private int llovio;
	
	/**
	 * @post registro del mes sin ningún día lluvioso.
	 */
	public LluviasDelMes() {
		llovio = 0;
	}

	/**
	 * @pre 'dia' está en el rango [1-31] .
	 * @post registra que el día del mes llovió.
	 * @param dia : número del día del mes.
	 */
	public void agregar(int dia) {
		
		validar(dia);
		
		int bit = (1 << (dia - 1));
		llovio = (llovio | bit);
	}
	
	/**
	 * @pre 'dia' está en el rango [1-31].
	 * @param dia : número del día del mes.
	 * @return si llovió el día del mes.
	 */
	public boolean contiene(int dia) {
		
		validar(dia);
		
		int bit = (1 << (dia - 1));
		return ((llovio & bit) != 0);
	}

	/**
	 * @return cantidad de días que llovieron el mes.
	 */
	public int contar() {

		return contar(llovio);
	}
	
	private int contar(int bits) {
		
		int cuenta = 0;
		if (bits != 0) {
			cuenta = (bits & 1) + contar(bits >> 1);
		} 
		return cuenta;
	}

	/**
	 * @post agrega los días lluviosos de 'otro'.
	 * @param otro
	 */
	public void agregar(LluviasDelMes otro) {
		
		llovio = (llovio | otro.llovio);
	}

	/**
	 * @post deja solo aquellos días lluviosos que también están en 'otro'.
	 * @param otro
	 */
	public void retener(LluviasDelMes otro) {
		
		llovio = (llovio & otro.llovio);
	}
	
	/**
	 * @post remueve los días lluviosos que están en 'otro'.
	 * @param otro
	 */
	public void remover(LluviasDelMes otro) {
		
		int noLlovioEnOtro = otro.llovio ^ 0b11111111_11111111_11111111_11111111;

		llovio = (llovio & noLlovioEnOtro);
	}

	private void validar(int dia) {
		if ((dia < 1) || (dia > 31)) {
			throw new IllegalArgumentException("No es un día del mes: " + dia);
		}
	}
}
