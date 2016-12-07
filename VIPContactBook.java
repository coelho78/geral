public class VIPContactBook {
	public static final int MAX_CONTACTS = 50;

	private int counter; // numero de contactos existentes
	private VIPContact[] contacts; //vector com os contactos
	private int currentContact; //indice do contacto actual

	// Construtores
	public VIPContactBook() {
		counter = 0;
		contacts = new VIPContact[MAX_CONTACTS];
		currentContact = 0; //Por omissao, pode ser 0.
	}
	
	private int searchIndex(String name) {
		int i = 0; // percurso pelos elementos 0..counter
		boolean find = false; // indicador de existencia
		while ((i < counter) && (!find))
			if (contacts[i].getName().compareTo(name) == 0)
				find = true;
			else
				i++;
			
		if (find)
			return i;
		else
			return -1;
	}

	public VIPContact getContact (String name) {
		int index = searchIndex(name);
		if (index != -1) 
			return contacts[index];
		else return null;
	}
	
	public void addContact(String name) {
		if (searchIndex(name) == -1) { // novo contacto
			if (counter == contacts.length) { // vector cheio
				VIPContact tmp[] = new VIPContact[2 * contacts.length];
				int i = 0;
				while (i < counter) {
					tmp[i] = contacts[i];
					i++;
				}
				contacts = tmp;
			}
			// Repare que so passamos o nome. Ainda nao ha telefone nem email.
			contacts[counter++] = new VIPContact(name);
		}
	}

	//Adicionar telefone ao contacto (versao mais elaborada):
	//Se existe contacto, adicionamos o telefone ao contacto. Caso contr�rio
	//criamos primeiro um novo contacto e depois adicionamos o telefone
	//ao novo contacto, chamando de novo esta funcao.
	public void addPhone (String name, int phone) {
		int index = searchIndex(name);
		if (index != -1) // Se existe o contacto, adicionar telefone
			contacts[index].addPhone(phone);
		else {
			// Se o contacto nao existir, podemos adicionar o
			// contacto e, so depois, adicionar o email.
			addContact(name); // Aqui, adicionamos o contacto...
			addPhone(name, phone); // Agora, o contacto ja esta la de certeza.
		}
	}

	//Adicionar email ao contacto (versao mais elaborada):
	//Se existe contacto, adicionamos o email ao contacto. Caso contr�rio
	//criamos primeiro um novo contacto e depois adicionamos o email
	//ao novo contacto, chamando de novo esta funcao.
	public void addEmail (String name, String email) {
		int index = searchIndex(name);
		if (index != -1) // Se existe o contacto, adicionar email.
			contacts[index].addEmail(email);
		else {
			// Se o contacto nao existir, podemos adicionar o
			// contacto e, depois, adicionar o email.
			addContact(name); // Aqui, adicionamos o contacto...
			addEmail(name, email); // Agora, o contacto ja esta la de certeza.
		}
	}

	// Removemos um contacto da forma habitual...
	// Desde que o contacto exista, claro!
	public void removeContact(String name) {
		int index = searchIndex(name);
		if (index != -1) { // contacto existente
			int i = index;
			while (i < counter - 1) {
				contacts[i] = contacts[i + 1];
				i++;
			}
			counter--;
		}
	}
	
	// Remover telefone, usando operacao da classe VIPContact
	public void removePhone(String name, int phone) {
		int index = searchIndex(name);
		if (index != -1) { // contacto existente
			contacts[index].removePhone(phone);
		}
	}

	// Remover email, usando operacao da classe VIPContact
	public void removeEmail(String name, String email) {
		int index = searchIndex(name);
		if (index != -1) { // contacto existente
			contacts[index].removeEmail(email);
		}
	}

	public int getNumberOfContacts() {
		return counter;
	}

	// Operacoes para iterar sobre todos os contactos
	public void initIteration() {
		currentContact = 0;
	}

	public boolean hasNextContact() {
		return currentContact < counter;
	}

	public VIPContact nextContact() {
		return contacts[currentContact++];
	}
	
	public String listContacts() {
		String result = "";
		
		for (int i=0; i<counter; i++) 
			result = result + contacts[i].toString() + "\n";
		return result;
	}

}
