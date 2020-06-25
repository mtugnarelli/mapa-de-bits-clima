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
}
