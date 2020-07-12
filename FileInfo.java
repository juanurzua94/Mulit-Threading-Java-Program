
public class FileInfo {
	private int diskNumber;
	private int startingSector;
	private int fileLength;
	
	public FileInfo(int dn, int ss, int fl) {
		this.diskNumber = dn;
		this.startingSector = ss;
		this.fileLength = fl;
	}
	
	public int getDiskNumber() {
		return this.diskNumber;
	}
	
	public int getStartingSector() {
		return this.startingSector;
	}
	
	public int getFileLength() {
		return this.fileLength;
	}
	
	public void setDiskNumber(int dn) {
		this.diskNumber = dn;
	}
	
	public void setStartingSector(int ss) {
		this.startingSector = ss;
	}
	
	public void setFileLength(int fl) {
		this.fileLength = fl;
	}
}
