
public class ResourceManager {
	
	boolean isFree[];
	
	public ResourceManager(int numberOfItems) {
		isFree = new boolean[numberOfItems];
		for(int i = 0; i < numberOfItems; ++i) {
			isFree[i] = true;
		}
	}
	
	public synchronized int request() {
		while(true) {
			for(int i = 0; i < isFree.length; ++i) {
				if(isFree[i]) {
					isFree[i] = false;
					return i;
				}
			}
			
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void release(int index) {
		isFree[index] = true;
		this.notify();
	}
}
