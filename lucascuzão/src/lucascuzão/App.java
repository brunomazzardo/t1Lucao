package lucascuzão;

public class App {

	public static void main(String[] args) {
		Item item = new Item("um", 1, 1, 1.0);
		Item dois = new Item("dois", 2, 2, 2.0);
		Item quat = new Item("quatorze", 14, 14, 14.0);
		HashChain hc = new HashChain();
		hc.add(item);
		hc.add(dois);
		hc.add(quat);
	//hc.imprimi(1);
System.out.println(hc.get(dois).toString());
	}

}
