package lucascuzão;

public class HashChain {
	private HashObject[] hash = new HashObject[13];

	public HashChain() {
		for (int i = 0; i < 13; i++) {
			hash[i] = new HashObject();
			hash[i].setDisponivel();
		}

	}

	public Item get(Item item, int i) {
		int key = item.getCodigo() % 13 + i;
		if (key > 13) {
			i = 0;
			key = 0;
		}
		if (hash[key].getStatus() == 2) {
			if (hash[key].getItem().getCodigo() == item.getCodigo())
				return hash[key].getItem();

		} else if (hash[key].getStatus() == 3) {

		}
		return null;

	}

	public Item get(Item item) {
		item = get(item, 0);
		return item;
	}

	public boolean add(Item item, int i, int codigo) {
		int key = codigo + i;

		if (key > 12) {
			i = 0;
			key = 0;

		}
		System.out.println(key);

		if (hash[key].getStatus() == 1 || hash[key].getStatus() == 3) {
			hash[key].setItem(item);
			hash[key].setStatus(2);
			return true;
		}
		return add(item, i +1, item.getCodigo()%13);

	}

	public boolean add(Item item) {
		int key = item.getCodigo() % 13;
		return add(item, 0, key);
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
