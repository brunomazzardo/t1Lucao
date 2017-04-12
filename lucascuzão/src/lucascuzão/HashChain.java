package lucascuzão;

public class HashChain {
	private HashObject[] hash = new HashObject[13];

	public HashChain() {
		for (int i = 0; i < 13; i++) {
			hash[i] = new HashObject();
			hash[i].setDisponivel();
		}

	}

	public void remove(Item i) {

		if (get(i.getCodigo()) != null) {
			hash[i.getCodigo()].setItem(null);
			hash[i.getCodigo()].setStatus(3);

		}
	}

	public Item get(int codigo, int i) {
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
		return get(codigo, 0);

	}

	public boolean add(Item item, int i) {
		int key = (i + item.getCodigo() % 13) % 13;

		System.out.println(key);

		if (hash[key].getStatus() == 1 || hash[key].getStatus() == 3) {
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

	public void imprimi(int i) {
		if (hash[i].getStatus() == 2)
			System.out.println(hash[i].getItem().toString());
		if (i < 12) {
			i++;
			imprimi(i);
		}
	}
}
