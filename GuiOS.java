import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GuiOS extends JFrame {
	
	private JPanel userPanel;
	private JPanel diskPanel;
	private JPanel printerPanel;
	
	private JLabel userLabel;
	private JLabel diskLabel;
	private JLabel printerLabel;
	
	private JList userActionsList;
	private JList diskActionsList;
	private JList printerActionsList;
	
	private DefaultListModel userListModel;
	private DefaultListModel diskListModel;
	private DefaultListModel printerListModel;
	
	private JTextField userActionsTextField;
	private JTextField diskActionsTextField;
	private JTextField printerActionsTextField;
	
	private JScrollPane userScrollPane;
	private JScrollPane diskScrollPane;
	private JScrollPane printerScrollPane;
	
	private static final String USERS = "USERS";
	private static final String DISKS = "DISKS";
	private static final String PRINTERS = "PRINTERS";
	
	private int userListIndex = 0;
	private int diskListIndex = 0;
	private int printerListIndex = 0;
	
	private int sleepAmount = 1000;
	
	private JButton faster;
	private JButton slower;
	JPanel container;

	public GuiOS() {
		super();
		
		container = new JPanel();
		setTitle("Name: JUAN URZUA UCINetID: JPURZUA");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(545, 545);
		
		faster = new JButton("Faster");
		slower = new JButton("Slower");
		
		faster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				speedUpProcess();
			}
		});
		
		slower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				slowDownProcess();
			}
		});
		userPanel = new JPanel();
		userLabel = new JLabel(USERS);
		userListModel = new DefaultListModel();
		userActionsList = new JList(userListModel);
		userScrollPane = new JScrollPane(userActionsList);
		userPanel.add(userScrollPane, BorderLayout.SOUTH);
		
		diskPanel = new JPanel();
		diskLabel = new JLabel(DISKS);
		diskListModel = new DefaultListModel();
		diskActionsList = new JList(diskListModel);
		diskScrollPane = new JScrollPane(diskActionsList);
		diskPanel.add(diskScrollPane, BorderLayout.SOUTH);
		
		printerPanel = new JPanel();
		printerLabel = new JLabel(PRINTERS);
		
		printerListModel = new DefaultListModel();
		printerActionsList = new JList(printerListModel);
		printerScrollPane = new JScrollPane(printerActionsList);
		printerPanel.add(printerScrollPane);

		
		userPanel.setPreferredSize(new Dimension(500, 150));
		diskPanel.setPreferredSize(new Dimension(500, 150));
		printerPanel.setPreferredSize(new Dimension(500, 150));
		
		container.setSize(500, 450);
		container.add(userPanel);
		container.add(diskPanel);
		container.add(printerPanel);
		
		JPanel bottom = new JPanel();
		bottom.add(faster);
		bottom.add(slower);
		
		getContentPane().add(BorderLayout.NORTH, new JLabel("Name: JUAN URZUA UCInetID: JPURZUA"));
		getContentPane().add(BorderLayout.CENTER, container);
		getContentPane().add(BorderLayout.SOUTH, bottom);
		
		//getContentPane().add(BorderLayout.NORTH, userPanel);
		//getContentPane().add(BorderLayout.CENTER, diskPanel);
		//getContentPane().add(BorderLayout.SOUTH, printerPanel);
		
		
		setResizable(false);
	
		setVisible(true);
	}
	
	public synchronized void userListAdd(String action) {
		
		
		userListIndex++;
		userListModel.addElement(Integer.toString(userListIndex) + ". " + action);
		userActionsList.ensureIndexIsVisible( userActionsList.getModel().getSize() -1 );
		
		try {
			Thread.sleep(sleepAmount);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public synchronized void diskListAdd(String action) {
		
		diskListIndex++;
		diskListModel.addElement(action);
		diskActionsList.ensureIndexIsVisible( diskActionsList.getModel().getSize() -1 );
		
		try {
			Thread.sleep(sleepAmount);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public synchronized void printerListAdd(String action) {
	
		printerListIndex++;
		printerListModel.addElement(action);
		printerActionsList.ensureIndexIsVisible( printerActionsList.getModel().getSize() -1 );

		try {
			Thread.sleep((int)sleepAmount/10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void speedUpProcess() {
		if(sleepAmount >= 500)
			sleepAmount = sleepAmount - 500;
	}
	
	private void slowDownProcess() {
		sleepAmount += 500;
	}
	
}
