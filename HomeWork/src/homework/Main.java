package homework;

import java.util.Set;

public class Main {
	

	public static void main(String[] args) {
		
		// - Declara a classe para fazer a leitura do CSV
		CSVFileReader leitorDeLivros = new CSVFileReader();
		
		// - Realiza a leitura do arquivo e retorna um set de Book
		Set<Book> listaDeLivros = CSVFileReader.read("books.csv");
		
		//Exibe a lista de livros armazenada
		for (Book livro : listaDeLivros) {
			System.out.println(livro);
		}
		
	}

}
