package POO;

public enum Sexo {
	
	MASCULINO(1), FEMININO(2);
	
	private Sexo(int cod) {
		this.cod = cod;
	}
	
	private final int cod;
	
	public int getCod() {
		return cod;
	}
}
