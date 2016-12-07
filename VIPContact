public class VIPContact {
		private int MAX_PHONES = 3; // dimensao do vector de telefones
		private int MAX_EMAILS = 5; // dimensao do vector de emails
		
		private String name;        // nome do contacto
		private int numberOfPhones; // numero de elementos no vector
		private int currentPhone;   // elemento corrente (para o iterador)
		private int[] phones;       // vector de telefones
		private int numberOfEmails; // numero de elementos no vector
		private int currentEmail;   // elemento corrente (para o iterador)
		private String[] emails;    // vector de emails

		public VIPContact(String name) {
			this.name = name;
			this.numberOfPhones = 0;
			this.currentPhone = 0;
			this.phones = new int[MAX_PHONES];
			this.numberOfEmails = 0;
			this.currentEmail = 0;
			this.emails = new String[MAX_EMAILS];
		}
		public String getName() {
			return name;
		}
		
		private int searchPhoneIndex(int phone) {
				int i = 0; // percurso pelos elementos 0..numberOfPhones
				boolean find = false; // indicador de existencia
				while ((i < numberOfPhones) && (!find))
					if (phones[i] == phone)
						find = true;
					else
						i++;
				
				if (find)
					return i;
				else
					return -1;
		}
		
		public void addPhone(int phone) {
			if (searchPhoneIndex(phone) == -1) {
				if (numberOfPhones == phones.length) { // vector cheio
					int tmp[] = new int[2 * phones.length];
					int i = 0;
					while (i < numberOfPhones) {
						tmp[i] = phones[i];
						i++;
					}
					phones = tmp;
				}
				phones[numberOfPhones++] = phone;
			}
		}

		public void removePhone(int phone) {
			int index = searchPhoneIndex(phone);
			if (index != -1) { // telefone existente
				int i=index;
				while (i < numberOfPhones-1) { 
					phones[i] = phones[i+1]; 
					i++;
				}
				numberOfPhones--;
			}
		}
		
		public int getNumberOfPhones() {
			return numberOfPhones;
		}

		// Operacoes para iterar sobre todos os numeros de telefone
		public void initPhoneIteration() {
			currentPhone = 0;
		}

		public boolean hasNextPhone() {
			return currentPhone < numberOfPhones;
		}

		public int nextPhone() {
			return phones[currentPhone++];
		}

		private int searchEmailIndex(String email) {
			int i = 0; // percurso pelos elementos 0..numberOfEmails
			boolean find = false; // indicador de existencia
			while ((i < numberOfEmails) && (!find))
				if (emails[i].equals(email))
					find = true;
				else
					i++;

			if (find)
				return i;
			else
				return -1;
		}

		public void addEmail(String email) {
			if (searchEmailIndex(email) == -1) {
				if (numberOfEmails == emails.length) { // vector cheio
					String tmp[] = new String[2 * emails.length];
					int i = 0;
					while (i < numberOfEmails) {
						tmp[i] = emails[i];
						i++;
					}
					emails = tmp;
				}
				emails[numberOfEmails++] = email;
			}
		}

		public void removeEmail(String email) {
			int index = searchEmailIndex(email);
			if (index != -1) { // contacto existente
				int i=index;
				while (i < numberOfEmails-1) { 
					emails[i] = emails[i+1]; 
					i++;
				}
				numberOfEmails--;
		 	}
		}

		public int getNumberOfEmails() {
			return numberOfEmails;
		}

		// Operacoes para iterar sobre todos os emails
		public void initEmailIteration() {
			currentEmail = 0;
		}

		public boolean hasNextEmail() {
			return currentEmail < numberOfEmails;
		}

		public String nextEmail() {
			return emails[currentEmail++];
		}

		public String toString() {
			String result = "";
			result += this.name + "\n" + this.getNumberOfPhones() + "\n";
			for (int i = 0; i < this.getNumberOfPhones(); i++)
				result += phones[i] + "\n";

			result += this.getNumberOfEmails() + "\n";
			for (int j = 0; j < this.getNumberOfEmails(); j++)
				result += emails[j] + "\n";

			return result;
		}



}
