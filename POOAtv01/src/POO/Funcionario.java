package POO;

import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Funcionario extends Usuario {
	
		private Sexo sexo;
		private Salario salario;
		
		private String nome;
		private String email;
		
		Salario s = new Salario();
		
		SimpleDateFormat dataC = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dataAno = new SimpleDateFormat("y");
		Calendar dataN = new GregorianCalendar();
		Calendar dataA = Calendar.getInstance();
		
		
		public Funcionario() {
			
		}
		
		public Funcionario(String usuario, String senha, String nome, String email) throws NoSuchAlgorithmException {
			super(usuario, senha);
			setNome(nome);
			setEmail(email);
		}
		
		public Funcionario(String usuario, String senha) throws NoSuchAlgorithmException {
			super(usuario, senha);
		}

		
		public Sexo getSexo() {
			return sexo;
		}

		public void setSexo(Sexo sexo) {
			this.sexo = sexo;
		}

		public Salario getSalario() {
			return salario;
		}

		public void setSalario(Salario salario) {
			this.salario = salario;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			if (nome.length() > 0)
				this.nome = nome;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			if (email.length() > 0)
				this.email = email;
		}
		
		
		public int idade() {
			int idade = 0;
			if (dataA.get(Calendar.DAY_OF_MONTH) >= dataN.get(Calendar.MONTH)) {
				if (dataA.get(Calendar.DAY_OF_MONTH) >= dataN.get(Calendar.DAY_OF_MONTH)) {
					idade = (dataA.get(Calendar.YEAR) - dataN.get(Calendar.YEAR));
					
				} else {
					idade = (dataA.get(Calendar.YEAR) - dataN.get(Calendar.YEAR) - 1);
				}
			} else {
				idade = (dataA.get(Calendar.YEAR) - dataN.get(Calendar.YEAR) - 1);
			}
			
			return idade;
		}
		
		public void dataNasci(int ano, int mes, int dia) {
			dataN.set(ano, (mes - 1), dia);
		}
		
		public int idadeMinima() {
			int ano = dataN.get(Calendar.YEAR);
			
			if(sexo.getCod() == 1) {
				ano += 62;
				
			} else if (sexo.getCod() == 2) {
				ano += 65;
			}
			
			return ano;
		}
		
		public int aposentado() {
			if (tempoC() > idade()) {
				return (tempoC());
				
			} else {
				return idade();
			}
		}
		
		public int tempoC() {
			int anoAtual = dataA.get(Calendar.YEAR);
			return (anoAtual - salario.anosT() + 35);
		}
		
		public int idadeAposentado() {
			return (aposentado() - dataN.get(Calendar.YEAR));
		}
		
		public int anoF() {
			return(aposentado() - idade());
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("\n* Funcionário *");
			builder.append("\n- Nome: ");
			builder.append(nome);
			builder.append("\n- Sexo: ");
			builder.append(getSexo());
			builder.append("\n- Data de Nascimento: ");
			builder.append(dataC.format(dataN.getTime()));
			builder.append("\n- E-mail: ");
			builder.append(email);
			builder.append("\n- Usuário: ");
			builder.append(getUsuario());
			builder.append("\n- Senha: ");
			builder.append(getSenha());
			builder.append("\n* Dados *");
			builder.append("\n- Ano de nascimento: ");
			builder.append(dataAno.format(dataN.getTime()));
			builder.append("\n- Tempo de Contribuição: ");
			builder.append(tempoC());
			builder.append("\n- Idade Miníma: ");
			builder.append(idadeMinima());
			builder.append("\n- Ano Aposentadoria: ");
			builder.append(aposentado());
			builder.append("\n- Idade Aposentadoria: ");
			builder.append(idadeAposentado());
			builder.append("\n- Idade Atual: ");
			builder.append(idade());
			builder.append("\n Anos Faltantes: ");
			builder.append(anoF());
			return builder.toString();
		}

}
