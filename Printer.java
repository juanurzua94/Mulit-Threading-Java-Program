import java.io.*;

public class Printer {
	private int number;
	private File file;
	
	public Printer(int num) {
		this.number = num + 1;
		file = new File("PRINTER" + Integer.toString(this.number));
		try {
			if(file.exists()) {
				file.delete();
				file.createNewFile();
			}
		} catch(Exception e) {
			
		}
		
	}
	
	public boolean numberSet() {
		if(this.number == -1)
			return false;
		return true;
	}
	
	public void setNumber(int num) {
		this.number = num;
	}
	
	public void write(StringBuffer line) throws InterruptedException {
		FileWriter fw;
		BufferedWriter bw;
		try {
			
			Thread.sleep(2750);
			if(!file.exists()) {
				file.createNewFile();
			}
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			bw.write(line.toString() + "\n");
			bw.flush();
			bw.close();
			fw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
