
public class PrintJobThread extends Thread {
	
	private PrinterManager pm;
	private FileInfo fileName;
	private DiskManager dm;
	private GuiOS os;
	
	public PrintJobThread(PrinterManager pm, FileInfo fileName, DiskManager dm, GuiOS os)
	{
		this.pm = pm;
		this.fileName = fileName;
		this.dm = dm;
		this.os = os;
	}
	
	public void run() {
		
		int printerNum = pm.request();
		Printer printer = pm.getPrinter(printerNum);
		Disk disk = dm.requestSpecificDiskForReading(fileName.getDiskNumber());
		for(int i = fileName.getStartingSector(); i < (fileName.getStartingSector() + fileName.getFileLength()); ++i) {
			try {
				printer.write(disk.getSector(i));
				if(os != null)
					os.printerListAdd("PRINTER" + printerNum + " is printing line " + disk.getSector(i));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		dm.release(fileName.getDiskNumber());
		pm.release(printerNum);
	
	}
	
}
