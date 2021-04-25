import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		
Scanner teclado = new Scanner(System.in);
		
		List<Cliente> clientes = new ArrayList();
		List<Cliente> listaEspera = new ArrayList();
	
		
		
		 int indexCliente = 0;

	        boolean running = true;
	        String line;
	        while (running) {
	            System.out.print("> ");
	            line = teclado.nextLine();
	            switch (line.toLowerCase()) {
	                case "help":
	                    printMenu();
	                    break;
	                case "bye":
	                case "exit":
	                    running = false;
	                    break;
	                case "1":
	                case "add cliente":
	                    clientes.add(reservarMesa());
	                    break;
	                case "2":
	                case "list":
	                   listarReserva(clientes);
	                    break;
	                case "3":
	                case "pesquisar mesa":
	                	//pesquisarMesa();
	                    break;
	                case "4":
	                case "list empregado":
	            //       listar(listaPessoa, "empregado");
	                   break;
	                case "5":
	                case "list cliente":
	              //      listar(listaPessoa, "cliente");
	                	break;
	                case "6":
	                case "removePF":
	                    removerPF(clientes);
	                case "7":
	                case "removePJ":
	                    removerPJ(clientes);
	                case "8":
	                case "Finalizar" :
	                default:
	                    System.out.println("Opcao invalida");
	                    break;
	            }

	        }
	}
	
	

	public static void printMenu() {
		System.out.println("---------MENU---------");
		System.out.println("1...Reservar mesa");
		System.out.println("2...Listar reserva");
		System.out.println("3...Pesquisar reserva");
		System.out.println("4...Imprimir lista de espera");
		System.out.println("5...Remover pessoa fisica da lista");
		System.out.println("6...Remover pessoa juridica da lsita");
		System.out.println("7...Finalizar");
		
		}
	
	
	private static String inputTipoCliente() {
		String tipoCliente = null;
		while(tipoCliente == null) {
			System.out.println("Pessoa física (f) ou pessoa jurídica (j) : ");
			tipoCliente = new Scanner(System.in).nextLine();
			if(!"f".equals(tipoCliente) && !"j".equals(tipoCliente)) {
				tipoCliente= null;
				System.out.println("Opção inválida, aceito apenas f (Pessoa física) ou j (pessoa jurídica)");
			}
			
		}
		return tipoCliente;
		
	}
	
	
	
	private static PessoaFisica cadastrarPF() {
		
		System.out.println("Nome: ");
		String nome = new Scanner(System.in).nextLine();
		
		System.out.println("CPF :");
		String cpf = new Scanner(System.in).nextLine();
		
		System.out.println("Forma de pagamento (a vista ou parcelado): ");
		String formaPagamento = new Scanner(System.in).nextLine();
		
		
		PessoaFisica pf = new PessoaFisica(nome, cpf, formaPagamento);
		pf.setCpf(cpf);
		pf.setformaPagamento(formaPagamento);
		return pf;
		
	}
	
	
	private static PessoaJuridica cadastrarPJ() {
		
		System.out.println("Nome: ");
		String nome = new Scanner(System.in).nextLine();
		
		System.out.println("CNPJ: ");
		String cnpj = new Scanner(System.in).nextLine();
		
		System.out.println("Forma de pagamento( a vista ou parcelado): ");
		String formaPagamento = new Scanner(System.in).nextLine();
		
		PessoaJuridica pj = new PessoaJuridica(nome, cnpj, formaPagamento);
		pj.setCNPJ(cnpj);
		pj.setformaPagamento(formaPagamento);
		return pj;
	}
	
	
	public static Cliente reservarMesa() {
		
		Scanner teclado = new Scanner(System.in);
		
		Cliente cliente = null;
		
		String tipoCliente = inputTipoCliente();
		switch (tipoCliente) {
			case "f":
				cliente = cadastrarPF();
				break;
				
			case "j":
				cliente = cadastrarPJ();
				break;
		}
		
		return cliente;
		
		}
	

	
	
	public static void listarReserva(List<Cliente> clientes) {
		clientes.forEach(cliente -> {
            System.out.println(cliente.getClass().getName());
            if (cliente instanceof PessoaFisica) {
                PessoaFisica pf = (PessoaFisica) cliente; // cast de tipo
                System.out.println("cpf:" + pf.getCpf() + " - " + cliente + " - Forma de pagamento: "+ pf.getformaPagamento());
            } else if (cliente instanceof PessoaJuridica) {
                PessoaJuridica ph = (PessoaJuridica) cliente;
                System.out.println("cnpj:"+ ph.getCNPJ() + " - " + cliente + " - Forma de pagamento: "+ ph.getformaPagamento());
            }
        });	
		
    }
	
	
	public static void remover (List<Cliente> clientes) {
		
	}
	
	
	private static PessoaFisica buscarPF(List <Cliente> clientes, String cpf) {
	
		PessoaFisica pessoaFisica = null;
		
		for (int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i).cpf.equals(cpf)) {
				pessoaFisica = (PessoaFisica) clientes.get(i);
				break;
			}
		}
		return pessoaFisica;
	}
	
	private static PessoaJuridica buscarPJ(List <Cliente> clientes, String cnpj) {
		
		PessoaJuridica pessoaJuridica = null;
		
		for (int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i).cpf.equals(cnpj)) {
				pessoaJuridica= (PessoaJuridica) clientes.get(i);
				break;
			}
		}
		return pessoaJuridica;
	}
			
	private static void buscarMesa(List <Cliente> clientes) {
		
	}
	
	
	public static void removerPF(List <Cliente> clientes) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Informe o cpf que será removido: ");
		String cpf = teclado.nextLine();
		
		Cliente cliente = buscarPF(clientes, cpf);
		if(cliente != null) {
			clientes.remove(cliente);
			System.out.println("CPF cancelado!!!");
		} else {
			System.out.println("Pessoa não encontrada!!!");
		}
	}
	
	
	public static void removerPJ(List <Cliente> clientes) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Informe o cnpj que será removido: ");
		String cnpj = teclado.nextLine();
		
		Cliente cliente = buscarPJ(clientes, cnpj);
		if(cliente != null) {
			clientes.remove(cliente);
			System.out.println("CNPJ cancelado!!!");
		} else {
			System.out.println("Pessoa não encontrada!!!");
		}
	}
	

	
}
	

	
	
	

	
	
	
	



	


