class Cliente
{
	String nome;
	String cpf;	

	public Cliente(String nome, String cpf)
	{
	this.nome = nome;
	this.cpf = cpf;
	}


	public String getNome()
	{
		return nome;
	}

	public String getCPF()
	{
		return cpf;
	}

	public void mostrar()
	{
		System.out.println("Nome: " + nome);
		System.out.println("CPF: " + cpf);
	}
}
