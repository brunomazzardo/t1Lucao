package t1alged2;

import java.util.ArrayList;

public class HashChain {
	int count=0;
	int countGet=0;
	private HashObject[] hash = new HashObject[13];

	public HashChain() {
		for (int i = 0; i < 13; i++) {
			hash[i] = new HashObject();
			hash[i].setDisponivel();
		}

	}

	public void remove(Item i) {

		if (get(i.getCodigo()) != null) {
			count--;
			hash[i.getCodigo() % 13].setItem(null);
			hash[i.getCodigo() % 13].setStatus(3);

		}
	}

	public Item get(int codigo, int i) {
		countGet++;
		if(countGet>12)
			return null;
		int key = (i + codigo % 13) % 13;
		System.out.println(key);
		if (hash[key].getStatus() == 2) {

			if (hash[key].getItem().getCodigo() == codigo) {

				return hash[key].getItem();
			}

		} else if (hash[key].getStatus() == 3) {
			key++;

			if (hash[key].getItem().getCodigo() == codigo) {
				System.out.println("Passou");
				return hash[key].getItem();
			}

		}

		return get(codigo, ++i);

		// return get(item);

	}

	public Item get(int codigo) {
		countGet=0;
		return get(codigo, 0);

	}

	public boolean add(Item item, int i) {
		if (count > 12)
			return false;
		int key = (i + item.getCodigo() % 13) % 13;

		System.out.println(key);

		if (hash[key].getStatus() == 1 || hash[key].getStatus() == 3) {
			count++;
			hash[key].setItem(item);
			hash[key].setStatus(2);
			return true;
		}

		return add(item, ++i);

	}

	public boolean add(Item item) {
		int key = item.getCodigo() % 13;
		return add(item, 0);
	}

	public Item getNome(String nome) {

		for (int i = 0; i < 13; i++) {
			if (hash[i].getStatus() == 2) {
				if (hash[i].getItem().getNome().equals(nome))
					return hash[i].getItem();
			}
		}
		return null;
	}

	public Item maisBarato() {
		Item maisBarato = new Item("void", 0, 0, 9999999999.0);
		for (int i = 0; i < 13; i++) {
			if (hash[i].getStatus() == 2) {
				if (hash[i].getItem().getPreco() < maisBarato.getPreco()) {
					maisBarato = hash[i].getItem();
				}
			}
		}
		return maisBarato;

	}

	public ArrayList<Item> listarTodos() {
		ArrayList<Item> ite = new ArrayList<>();
		for (int i = 0; i < 13; i++) {
			if (hash[i].getStatus() == 2) {
				ite.add(hash[i].getItem());
			}
		}
		return ite;
	}

	public void imprimi(int i) {
		if (hash[i].getStatus() == 2)
			System.out.println(hash[i].getItem().toString());
		if (i < 12) {
			i++;
			imprimi(i);
		}
	}
}
