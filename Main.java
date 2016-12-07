import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	//Constants defining commands
	public static final String ADDCONTACT = "AC";
	public static final String ADDPHONE = "AP";
	public static final String ADDEMAIL = "AE";
	public static final String REMOVECONTACT = "RC";
	public static final String REMOVEPHONE = "RP";
	public static final String REMOVEEMAIL = "RE";
	public static final String NROFCONTACTS="NC";
	public static final String LISTCONTACTS="LC";
	public static final String QUIT="Q";
	
	//Constants defining ErrorMessages
	public static final String WRONGCOMM = "Invalid Command.";
	public static final String CONTACTEXIST = "Contact already exists.";
	public static final String NAMENOTEXIST="Contact does not exist.";
	public static final String CONTACTADDED = "Contact added.";
	public static final String PHONEADDED = "Phone added!";
	public static final String EMAILADDED = "Email added!";

	public static final String FILENAME = "contacts_vip.txt";
		 
	public static void main(String args[]) throws Exception {
			VIPContactBook vipcBook;
			Scanner in;
			vipcBook = new VIPContactBook();
			in = new Scanner(System.in);
			
			readVIPContactBook(vipcBook,FILENAME);
			commandInterpreter(in, vipcBook);
			writeVIPContactBook(vipcBook,FILENAME); 
			System.out.println("Goodbye!");
			}
		
	private static void commandInterpreter(Scanner in, VIPContactBook vipcBook) {
		String comm="";
		comm=getCommand(in);
		while (!comm.equals(QUIT)) { 
			if (comm.equals(ADDCONTACT))
				addContact(in, vipcBook);
			else if (comm.equals(ADDPHONE))
				addPhoneToContact(in,vipcBook);		
			else if (comm.equals(ADDEMAIL))
				addEmailToContact(in,vipcBook);
			else if (comm.equals(REMOVECONTACT))
				removeContact(in, vipcBook);
			else if (comm.equals(REMOVEPHONE))
				removePhoneFromContact(in,vipcBook);		
			else if (comm.equals(REMOVEEMAIL))
				removeEmailFromContact(in,vipcBook);
			else if ( comm.equals(LISTCONTACTS))
				System.out.println(vipcBook.listContacts());
			else if (comm.equals(NROFCONTACTS))
				System.out.println(vipcBook.getNumberOfContacts());
			else
				System.out.println(WRONGCOMM);
			comm=getCommand(in);
		}
	}

	public static void addContact(Scanner in, VIPContactBook vipBook){
		String name = "";
		name=in.nextLine();
		if (vipBook.getContact(name)==null) {
		 	vipBook.addContact(name);
		 	System.out.println(CONTACTADDED);
		}
		else 
			System.out.println(CONTACTEXIST);
	}
	
	private static void addPhoneToContact(Scanner in, VIPContactBook vipBook){
		String name = "";
		int phonenum;
		
		name=in.nextLine();
		phonenum=in.nextInt();
		in.nextLine();
		vipBook.addPhone(name, phonenum);
		System.out.println(PHONEADDED);
	}
	
	public static void addEmailToContact(Scanner in, VIPContactBook vipBook){
		String name = "";
		String email = "";
		name=in.nextLine();
		email = in.nextLine();
		vipBook.addEmail(name, email);
		System.out.println(EMAILADDED);
	}
	
	public static void removeContact(Scanner in, VIPContactBook vipBook){
		String name = "";
		name=in.nextLine();
		if (vipBook.getContact(name)!=null)
		 	vipBook.removeContact(name);
		else 
			System.out.println(NAMENOTEXIST);
	}
	
	public static void removePhoneFromContact(Scanner in, VIPContactBook vipBook){
		String name = "";
		int phone = 0;
		name=in.nextLine();
		phone = in.nextInt();
		in.nextLine();
		if (vipBook.getContact(name) != null) 
			vipBook.removePhone(name, phone);
		else
			System.out.println(NAMENOTEXIST);
	}
	
	public static void removeEmailFromContact(Scanner in, VIPContactBook vipBook){
		String name = "";
		String email = "";
		name=in.nextLine();
		email = in.nextLine();
		if (vipBook.getContact(name) != null) 
			vipBook.removeEmail(name, email);
		else
			System.out.println(NAMENOTEXIST);
	}

    public static String getCommand(Scanner in){
		String input="";
		System.out.print("> ");
		input=in.nextLine().toUpperCase();
		return input;
	}

	public static void writeVIPContactBook(VIPContactBook vipBook, String file) throws Exception{
		PrintWriter pw = new PrintWriter(file);
		VIPContact vip=null;
		pw.println(vipBook.getNumberOfContacts());
		vipBook.initIteration();
		while (vipBook.hasNextContact()) {
			vip=vipBook.nextContact();
			pw.print(vip.toString());
		}
		pw.close();
	}

	public static void readVIPContactBook(VIPContactBook vipBook, String file) throws Exception {

		FileReader fich=new FileReader(file);
		Scanner fi=new Scanner(fich);
		int cont=fi.nextInt(); fi.nextLine();

		for(int i=0; i<cont; i++) { // para cada contacto,
			String name=fi.nextLine();	 // ler nome
			vipBook.addContact(name);  // adicionar nome
			int nrPhones=fi.nextInt(); fi.nextLine(); // ler quantidade telefones
			for (int j=0; j<nrPhones; j++) {  // para cada telefone,
				int phone = fi.nextInt(); fi.nextLine();	
				vipBook.addPhone(name, phone);	// adicionar telefone	
			}
			int nrEmails=fi.nextInt(); fi.nextLine(); // ler quantidade emails
			for (int j=0; j<nrEmails; j++) { // para cada email,
				String email = fi.nextLine();
				vipBook.addEmail(name, email);  // adicionar email
			}
		}		
		fi.close();
	}


}
