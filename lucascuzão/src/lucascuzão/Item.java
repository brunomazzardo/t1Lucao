package lucascuz�o;

public class Item {
	private String nome;
	private int codigo;
	private int setor;
	private double preco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getSetor() {
		return setor;
	}

	public void setSetor(int setor) {
		this.setor = setor;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Item(String nome, int codigo, int setor, Double preco) {

		this.nome = nome;
		this.codigo = codigo;
		this.setor = setor;
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Item [nome=" + nome + ", codigo=" + codigo + ", setor=" + setor + ", preco=" + preco + "]";
	}
}
