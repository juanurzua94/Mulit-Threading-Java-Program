

public class Disk {
	static final int NUM_SECTORS = 1024;
	StringBuffer sectors[];
	
	public Disk() {
		
		sectors = new StringBuffer[NUM_SECTORS];
		
	}
	
	public void writeToStorage(StringBuffer line, int pos) {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sectors[pos] = line;
	}
	
	public StringBuffer readFromStorage(int pos) {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sectors[pos];
	}
	
	public StringBuffer getSector(int index) {
		return sectors[index];
	}

}
