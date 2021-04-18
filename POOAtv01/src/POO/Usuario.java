package POO;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Usuario {
	
	private String usuario;
	private String senha;
	
	
	public Usuario() {
		
	}
	
	public Usuario(String usuario, String senha) throws NoSuchAlgorithmException {
		inserirUsuario(usuario, senha);
		senhaCrip();
	}

	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	private void senhaCrip() throws NoSuchAlgorithmException {
		MessageDigest algoritmo = MessageDigest.getInstance("SHA1");
		
		byte messageDigest[] = algoritmo.digest(getSenha().getBytes());
		StringBuffer a = new StringBuffer();
		
		for (int aux = 0; aux < messageDigest.length; aux++) {
			a.append(Integer.toString((messageDigest[aux] & 0xff) + 0x100, 16).substring(1));
		}
		
		setSenha(a.toString());
	}
	
	
	public boolean inserirUsuario(String usuario, String senha) {
		if (usuario.equals(senha)) {
			System.out.println("ATENÇÃO! Não é permitido usuário e senha iguais");
			return false;
			
		} else {
			setUsuario(usuario);
			setSenha(senha);
			return true;
		}
	}
	
}