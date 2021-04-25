

public final class PessoaFisica extends Cliente {
	

	private String cpf;
	
	

	public PessoaFisica(String nome, String cpf, String formaPagamento) {
		super(nome);
		this.cpf = cpf;	
		this.nome = nome;
		this.formaPagamento = formaPagamento;
		
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getformaPagamento() {
		return formaPagamento;
	}
	
	public void setformaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	public String toString() {
		String aux = "Nome:"+ nome ;
		return aux;
	}


	

}
