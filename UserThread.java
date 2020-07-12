import java.io.*;
public class UserThread extends Thread {
	
	private String userFile;
	private DiskManager dm;
	private PrinterManager pm;
	private FileReader fr;
	private BufferedReader br;
	private StringBuffer local;
	private GuiOS os;
	private String userName;
	
	public UserThread(int num, DiskManager dm, PrinterManager pm, GuiOS os) {
		this.userName = "USER" + Integer.toString(num);
		this.userFile = "inputs/" + this.userName;
		this.dm = dm;
		this.pm = pm;
		this.os = os;
	}
	
	public void run() {
		File file = new File(userFile);
		try {
			if(!file.exists()) {
				System.out.println("Error, Couldnt find file for " + userFile);
			} else {
				fr = new FileReader(file.getAbsoluteFile());
				br = new BufferedReader(fr);
				
				String st;
				String currentLine[];
				while((st = br.readLine()) != null) {
				
					currentLine = st.split(" ");
					if(currentLine[0].equals(".save")) {
						save(currentLine[1]);
					} else if (currentLine[0].equals(".print")){
						print(currentLine[1]);
					}
				}
				
				fr.close();
				br.close();
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void save(String name) {
		try {
			int diskNum = dm.request();
			Disk disk = dm.getDisk(diskNum);
			int startingPos = dm.getStartingPos(diskNum);
			int counter = 0;
			String st;
			
				
			while(!(st = br.readLine()).equals(".end")) {
				local = new StringBuffer(st);
				disk.writeToStorage(local, startingPos + counter);
				counter++;
				
				if(os != null) {
					os.userListAdd(userName + " is writing to disk " + Integer.toString(diskNum));;
					os.diskListAdd("DISK" + Integer.toString(diskNum) + " saving " + local + " to sector " + Integer.toString(startingPos + counter));
				}
			}
			
			FileInfo fi = new FileInfo(diskNum, startingPos, counter);
			
			
			dm.newFile(name, fi);
			
			dm.release(diskNum);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void print(String name) {
		//System.out.println(name);
		FileInfo file = dm.getFileInfo(name);
		//System.out.println(file.getDiskNumber());
		//System.out.println(file.getStartingSector());
		//System.out.println(file.getFileLength());
		new PrintJobThread(pm, file, dm, os).start();
	}
	
	
}
