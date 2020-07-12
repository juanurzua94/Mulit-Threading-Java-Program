import java.awt.BorderLayout;

import javax.swing.*;

public class OS {
	
	public static void main(String args[]) {
		
		int totalUsers = Integer.parseInt(String.valueOf(args[0].charAt(1)));
		int followUp = totalUsers + 1;
		int totalDisks = Integer.parseInt(String.valueOf(args[followUp].charAt(1)));
		int totalPrinters = Integer.parseInt(String.valueOf(args[followUp + 1].charAt(1)));
		
		boolean containsGUI = false;
		if(!(followUp + 2 < args.length))
			containsGUI = true;
		
		GuiOS os = null;
		
		if(containsGUI)
			os = new GuiOS();
		
		DiskManager dm = new DiskManager(totalDisks, os);
		PrinterManager pm = new PrinterManager(totalPrinters, os);
		
		
		int i;
		for(i = 0; i < totalUsers; ++i) {
			new UserThread(i + 1, dm, pm, os).start();
		}
		
		
		
	}
}
