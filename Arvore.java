import javax.swing.JOptionPane;

public class Arvore {

	private No raiz;	
	
	public Arvore() {
		//Seta os nos iniciais
		raiz = new No("lives in water");
		this.raiz.setDir(new No("Shark"));
		this.raiz.setEsq(new No("Monkey"));		
	}
	
	public void start () {
		//Inicia o jogo em loop ate usuurio cancelar ou fechar aplicacao.
		int select;
		do {
		select = JOptionPane.showConfirmDialog(null, "Think in an animal", "Animals",JOptionPane.WARNING_MESSAGE);
		if(select == 0)
			pergunta(this.raiz);
		}while(select != 2 && select != -1);
	}

	public void addNo(No n) {
		String animal, atributo;
		animal = JOptionPane.showInputDialog(null, "\r\n" + //
				"What animal did you think of?","I give up!",JOptionPane.INFORMATION_MESSAGE);
		
		//Evita que usuario clique em cancelar e input pegue valor null.
		if(animal == null)
			return;

		//Copia o valor do animal no No atual
		String r = n.getValor();
		atributo = JOptionPane.showInputDialog("A(An) " + animal + " have" + "_____" +" but un " + r + " not.");
		
		//Cria-se n2 para armazenar o 'o valor do ex no atual', n1 para valor do novo animal e n recebe o novo atributo.
		No n2 = new No(r);
		No n1 = new No(animal);
		n.setValor(atributo);
		n.setDir(n1);
		n.setEsq(n2);
		
	}

public String editValue(String value, boolean choose) {
	//Metodo edita a apresentacao da resposta caso seja um atributo ou um animal.
	if(choose) 
		return "The animal you thought of is " + value + "?";
	return "The animal you thought  " + value + "?";
}

public void pergunta(No n) {
	//bool para definir tipo de apresentacao da resposta ao usuario.
	boolean choose = (n.getDir() == null || n.getEsq() == null ? true : false);
	int ret = JOptionPane.showConfirmDialog( null,editValue(n.getValor(), choose) , "Animals Guessing Game", JOptionPane.YES_NO_OPTION );
	
	//Logica do jogo
	if(ret == 0) {
		if(n.getDir() == null)
			JOptionPane.showMessageDialog(null, "I hit it again!","Animal's Guessing Game", JOptionPane.INFORMATION_MESSAGE);
		else 
			pergunta(n.getDir());
	}else {
		if(n.getEsq() == null) {
			addNo(n);
		}else {
			pergunta(n.getEsq());
		}
	}
}


}
