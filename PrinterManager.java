
public class PrinterManager extends ResourceManager {

	
	private Printer printers[];
	
	public PrinterManager(int numberOfItems, GuiOS os) {
		super(numberOfItems);
		printers = new Printer[numberOfItems];
		for(int i = 0; i < numberOfItems; ++i) {
			printers[i] = new Printer(i);
		}
		
		
	}
	
	public Printer getPrinter(int printer) {
		if(!printers[printer].numberSet())
			printers[printer].setNumber(printer + 1);
		return printers[printer];
	}
}
