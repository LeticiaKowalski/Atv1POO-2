package POO;

import java.nio.channels.UnsupportedAddressTypeException;
import java.security.NoSuchAlgorithmException;

public class Principal {

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedAddressTypeException {
	
		Funcionario f = new Funcionario("LeticiaKM", "2001", "Leticia", "lehh.kowalski@gmail.com");
		Salario s = new Salario();
		Sexo sexo = Sexo.FEMININO;
		f.dataNasci(2001, 2, 12);
		
		f.setSexo(sexo);
	
		s.inserirSalario(11.1f, 2);
		s.inserirSalario(15, 10);
		s.inserirSalario(31.2f, 10);
		s.inserirSalario(10.2f, 1);
		s.inserirSalario(2.5f, 13);
		s.inserirSalario(12f, 3);
		s.inserirSalario(23.4f, 12);
		s.inserirSalario(20.1f, 15);
		s.inserirSalario(31.4f, 7);
		s.inserirSalario(27.8f, 23);
		s.inserirSalario(2, 4);
		s.inserirSalario(12.9f, 31);
		s.inserirSalario(21, 10);
		s.inserirSalario(47.1f, 20);
		
		f.setSalario(s);
		
		System.out.println(f);
		System.out.println(f.getSalario().toString());
		System.out.println(f.getSalario().menorS(7));
		System.out.println(f.getSalario().maiorS(4));
		
	}

}
