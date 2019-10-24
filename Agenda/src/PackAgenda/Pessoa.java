package PackAgenda;

import java.util.Calendar;



public class Pessoa {
	private int codigo;
	private String nome;
	private Calendar dataNasc;
	private String email;
	private String fone;
	
	
	
	public Calendar getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Calendar dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String telefone) {
		this.fone = telefone;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pessoa [codigo=");
		builder.append(codigo);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", dataNasc=");
		builder.append(Arruma_data.arrumaDate(dataNasc));
		builder.append(", email=");
		builder.append(email);
		builder.append(", telefone=");
		builder.append(fone);
		builder.append("]");
		return builder.toString();
	}
}
