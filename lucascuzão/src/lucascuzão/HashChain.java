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
			add(item, i + 1);

		} else if (hash[key].getStatus() == 3) {
			add(item, i + 1);

		}
		return null;

	}

	public Item get(Item item) {
		item=get(item, 0);
		return item;
	}

	public void add(Item item, int i) {
		int key = item.getCodigo() % 13 + i;
		if (key > 13) {
			i = 0;
			key = 0;
		}

		if (hash[key].getStatus() == 1 || hash[key].getStatus() == 3) {
			hash[key].setItem(item);
			hash[key].setStatus(2);

		} else {
			add(item, i + 1);

		}

	}

	public void add(Item item) {
		add(item, 0);
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
