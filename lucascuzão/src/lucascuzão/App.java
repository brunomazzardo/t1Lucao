package lucascuzão;

public class App {

	public static void main(String[] args) {
		Item item = new Item("um", 1, 1, 1.0);
		Item dois = new Item("dois", 2, 2, 2.0);
		Item quat = new Item("quatorze", 14, 14, 14.0);
		Item doze = new Item("12", 12, 12, 12.0);
		Item vinte = new Item("25", 25, 25, 25.0);
		HashChain hc = new HashChain();
		System.out.println(hc.add(item));
		System.out.println(hc.add(dois));
		System.out.println(hc.add(quat));
		System.out.println(hc.add(doze));
		System.out.println(hc.add(vinte));
		hc.imprimi(1);
		// System.out.println(hc.get(dois).toString());
	}

}
