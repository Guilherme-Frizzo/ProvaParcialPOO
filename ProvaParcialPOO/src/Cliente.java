
public class Cliente {

	public Object cnpj;
	public Object cpf;
	String nome;
	String formaPagamento;
	
	public Cliente(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	public String toString() {
		String aux = "Nome:" + nome;
		return aux;
	}
	
	
}
