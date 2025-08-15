import java.util.Scanner;

public class Main 
{

	public static boolean verifica(String cpf)
	{
	
		if(cpf.length() < 11) return false;

		byte [] n = new byte[11];

		for(byte i = 0; i < 11; i++)
		{
			if(cpf.charAt(i) < '0' || cpf.charAt(i) > '9') return false;
			
			n[i] = (byte)(cpf.charAt(i) - '0');
		}
	
		boolean tigual = true;
		for(byte i = 0; i < 11; i++)
		{
			if(n[0] != n[i]) tigual = false;
		}
		if(tigual == true) return false;
	
		int soma1 = n[0] * 10 + n[1] * 9 + n[2] * 8 + n[3] * 7 + n[4] * 6 + n[5] * 5 + n[6] * 4 + n[7] * 3 + n[8] * 2;
	        int resto1 = (soma1 *10) % 11;

	        if(resto1 == 10) resto1 = 0;


		int soma2 =n[0] * 11 + n[1] * 10 + n[2] * 9 + n[3] * 8 + n[4] * 7 + n[5] * 6 + n[6] * 5 + n[7] * 4 + n[8] * 3 + n[9] * 2;
	        int resto2 = (soma2 * 10) % 11;

	        if(resto2 == 10) resto2 = 0;

	        return (resto1 == n[9] && resto2 == n[10]);
	} 


	public static void main(String[] args) 	    
	{
		Scanner ler = new Scanner(System.in);

        	System.out.print("Quantos clientes deseja adicionar? ");
        	int n = ler.nextInt(); // melhor usar int
        	ler.nextLine(); // limpa o \n do buffer

        	Cliente[] clientes = new Cliente[n];
	
        	for (int i = 0; i < n; i++) 
		{
			System.out.println("Digite o nome do cliente " + (i + 1) + ":");
			String nome = ler.nextLine();

			System.out.println("Digite o CPF deste cliente:");
			
			String cpf;
			while(true)
			{
				cpf = ler.nextLine();
				if(verifica(cpf))
				{
					break;
				}
				else
				{
					System.out.println("CPF invalido, insira novamente");
				}
			}
			clientes[i] = new Cliente(nome, cpf);
		}

        System.out.println("\nClientes cadastrados:");
        for (Cliente c : clientes) 
	{
		c.mostrar();
		System.out.println();
        }

        ler.close();
    }
}
