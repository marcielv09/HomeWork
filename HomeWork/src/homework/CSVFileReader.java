package homework;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;


public class CSVFileReader implements Comparator<Book>{
	
	public static Set<Book> read(String fileName){
		
		//Cria um set de Book
		Set<Book> listaDeLivros = new TreeSet<Book>(new CSVFileReader());
		
		try{
			//Abre o arquivo 
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
		
			//String para representar a linha
			String line = "";
			
			//Index para iterar as colunas do arquivo CSV
			int index = 0;
			
			while((line = reader.readLine()) != null){
				
				//Declara um novo objeto para receber as colunas do arquivo .CSV
				Book livro = new Book();
				
				//Faz o split da linha usando um regex para quebrar por vírgulas que estejam foras das asplas duplas
				//E joga isso para um Array de Strings[]
				String[] stringsSplitted = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				
				//Utilazando um for each para iterar sobre cada coluna quebrada pela vírgula
				for(String textSplitted: stringsSplitted){
					
					if(index == 0){
						//Se for o primeiro índice da linha, trata-se do título do livro. 
						livro.setTitle(textSplitted);
					} 
					else if(index == 1){
						//Se for o segundo índice da linha, trata-se do autor do livro. 
						livro.setAuthor(textSplitted);
					}
					else if(index == 2){
						//Se for o terceiro índice da linha, trata-se do isbn do livro. 
						livro.setIsbn(textSplitted);
					}
					else if(index == 3){
						//Se for o quarto índice da linha,  trata-se do ano do livro. .
						livro.setYear(Integer.parseInt(textSplitted));
					}
					//Incrementa o index para ler uma nova coluna.
					index++;
					
				}
				//Zera o index para ler uma nova linha.
				index = 0;
				
				//Adiciona o livro criado na lista de livros
				listaDeLivros.add(livro);
			}						
		}
		
		catch(FileNotFoundException e){
			System.out.println("Arquivo não encontrado.");
		}
		catch(IOException e){
			System.out.println("Erro de Entrada");
		}
		
		catch(Exception e){
			System.out.println("Erro");
			e.printStackTrace();
		}
		return listaDeLivros;
					
	}	
	
	@Override
	public int compare(Book o1, Book o2) {
		if (o1.getIsbn().equals( o2.getIsbn())) {
			return 0;
		}
		if (o1.getIsbn() == null) {
			return -1;
		}
		if (o2.getIsbn() == null) {
			return 1;
		}
		return o1.getIsbn().compareTo(o2.getIsbn());			  
	}
	

}
