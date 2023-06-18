public class No {

	private No dir;
	private No esq;
	private String valor;
	
	public No(String v) {
		this.valor = v;
		this.dir = null;
		this.esq = null;
	}
	
	public No getDir() {
		return this.dir;
	}
	
	public void setDir(No n) {
		this.dir = n;
	}
	
	public No getEsq() {
		return this.esq;
	}
	
	public void setEsq(No n) {
		this.esq = n;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
