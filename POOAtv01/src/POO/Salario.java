package POO;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Salario {
	
	private int mesesT;
	
	DecimalFormat formata = new DecimalFormat("R$ #,##0.00");
	
	private List<Float> valorHora = new ArrayList<Float>();
	private List<Double> salarios = new ArrayList<Double>();
	private List<Double> salario = new ArrayList<Double>();
	private List<Integer> horas = new ArrayList<Integer>();
	
	
	public int getMesesT() {
		return mesesT;
	}
	
	public void setMesesT(int mesesT) {
		this.mesesT = mesesT;
	}
	
	public void inserirSalario(float valor, int hora) {
		valorHora.add(valor);
		horas.add(hora);
		salario.add((double) (valor * hora));
		salarios.add((double) valor * hora);
		mesesT++;
	}
	
	public String mostraValor() {
		int aux = 1;
		String msg = "";
		
		for (float valor : valorHora) {
			msg += "(" + aux + ")" + formata.format(valor) + " | ";
		}
		
		return msg;
	}
	
	public String mostraHora() {
		int aux = 1;
		String msg = "";
		
		for (Integer valor : horas) {
			msg += "(" + aux + ")" + valor + " | ";
			aux++;
		}
		
		return msg;
	}
	
	public String mostraSalario() {
		String msg = "";
		
		for (int aux = 0; aux < salario.size(); aux++) {
			msg += "Salário " + (aux + 1) + ": " + formata.format(salario.get(aux)) + "\n";
		}
		
		return msg;
	}
	
	public double salarioTotal() {
		double total = 0;
		
		if (!salario.isEmpty()) {
			for(int aux = 0; aux < salario.size(); aux++) {
				total += salario.get(aux);
			}
		}
		
		return (total);
	}
	
	public double media() {
		return (salarioTotal() / salario.size());
	}
	
	public int anosT() {
		return (int) (getMesesT() / 12);
	}
	
	public int fracao() {
		return (getMesesT() % 12);
	}
	
	public String maiorS(int valor) {
		String msg = "Maiores Salários: (" + valor + ")";
		salarios.sort(Collections.reverseOrder());
		
		for(int aux = 0; aux < valor; aux++) {
			msg += formata.format(salarios.get(aux)) + " | ";
		}
		
		return msg;
	}
	
	public String menorS(int valor) {
		String msg = "Menores Salários: (" + valor + ")";
		salarios.sort(null);
		
		for(int aux = 0; aux < valor; aux++) {
			msg += formata.format(salarios.get(aux)) + " | ";
		}
		
		return msg;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n* Informações do Salário *");
		builder.append("\n" + mostraSalario());
		builder.append("\n- Valor por Hora: ");
		builder.append(mostraValor());
		builder.append("\n- Horas trabalhadas: ");
		builder.append(mostraHora());
		builder.append("\n- Salário Total: ");
		builder.append(formata.format(salarioTotal()));
		builder.append("\n- Média Salarial: ");
		builder.append(formata.format(media()));
		builder.append("\n- Meses Trabalhados: ");
		builder.append(getMesesT());
		builder.append("\n- Anos Trabalhados: ");
		builder.append(anosT());
		builder.append("\n- Fração dos Meses Trabalhados: ");
		builder.append(fracao());
		builder.append("\n- Anos e Meses de Trabalho: ");
		builder.append(anosT() + " ano(s), " + fracao() + " mês(es)");
		return builder.toString();
	}
	
}
