import java.util.Hashtable;

public class DirectoryManager {
	
	private Hashtable<String, FileInfo> table;
	
	public DirectoryManager() {
		table = new Hashtable<String, FileInfo>();
	}
	
	public void enter(String key, FileInfo file) {
		
		table.put(key, file);
		
	}
	
	public FileInfo lookup(String key) {
		
		if(!table.containsKey(key)) {
			return null;
		}
		
		
		return table.get(key);
	}
}
