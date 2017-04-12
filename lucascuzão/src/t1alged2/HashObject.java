package t1alged2;

public class HashObject {

	private Item item;
	private int status;

	public HashObject() {
		
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	public void setDisponivel(){
		status=1;
	}
  }
