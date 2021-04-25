
public class PessoaJuridica extends Cliente{

	public String cnpj;
	
	
	public PessoaJuridica(String nome, String cnpj, String formaPagamento) {
		super(nome);
		this.cnpj = cnpj;
		this.formaPagamento = formaPagamento;
		
		}
	
	



	public String getformaPagamento() {
		return formaPagamento;
	}
	
	public void setformaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	

	public String getCNPJ() {
		return cnpj;
	}
	
	public void setCNPJ(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
	public String toString() {
		String aux = "Nome:"+ nome;
		return aux;
	}

}
