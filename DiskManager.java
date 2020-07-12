
public class DiskManager extends ResourceManager {
	
	private DirectoryManager directoryManager;
	private Disk disks[];
	private int freeSector[];
	
	public DiskManager(int numberOfItems, GuiOS os) {
		super(numberOfItems);
		disks = new Disk[numberOfItems];
		for(int i = 0; i < numberOfItems; ++i) {
			disks[i] = new Disk();
		}
		freeSector = new int[numberOfItems];
		directoryManager = new DirectoryManager();
	}
	
	public Disk getDisk(int disk) {
		return disks[disk];
	}
	
	@Override
	public synchronized void release(int index) {
		int oldloc = freeSector[index];
		int i;
		for(i = oldloc; disks[index].getSector(i) != null; ++i);
		freeSector[index] = i;
		super.release(index);
	}
	
	public Disk requestSpecificDiskForReading(int index) {
		return disks[index];
	}
	
	public int getStartingPos(int disk) {
		return freeSector[disk];
	}
	
	public synchronized void newFile(String name, FileInfo file) {
		directoryManager.enter(name, file);
	}
	
	public synchronized FileInfo getFileInfo(String name) {
		return directoryManager.lookup(name);
	}
	

}
