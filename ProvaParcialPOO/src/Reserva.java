


public class Reserva implements Pagamento {

	
	Cliente cliente;
	Boolean pagamentoAVista;
	
	
	public Reserva(Cliente cliente, boolean pagamentoAVista) {
		this.cliente = cliente;
		this.pagamentoAVista = pagamentoAVista;
	}
	 
	
	
	
	
	public boolean getpagamentoAVista() {
		return pagamentoAVista;
	}
	
	public void setpagamentoAVista(boolean pagamentoAVista) {
		this.pagamentoAVista = pagamentoAVista;
	}
	
	
	public String toString() {
		String aux = "Cliente:" + cliente + ", Valor a vista:" + pagamentoAVista;
		return aux;
	}
	

	
	
	@Override
	public double calcularPagamento() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
