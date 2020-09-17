package schoolEnlightmentSystem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.toedter.calendar.JDateChooser;
import javax.swing.JFileChooser;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Scanner;

//This class is a user interface of UI model design pattern
public class CalenderUserInterface extends JFrame{
	String evntName,date,time;
	private JScrollPane scrollPane;	
	private JPanel minPanel,creatEventPanel,recentEventPanel,panel;
	private JTextField txtEvent;
	protected JTable table,table_1;
	private JTextField txtTime;
	private String username;
	private JMenuBar menuBar1;
	private JMenu mnFile,mnHome,mnHelp;
	private final JMenuItem itmExit;
	private JMenuItem itmSave,itmOpen,itmAbout;
	private JLabel lblEventName,lblDate,lblTime;
	private JButton btnNewButton,btnNewButton_1,btnNewButton_2,btnNewButton_3,btnOpen;
	private GroupLayout gl_recentEventPanel;
	protected JFileChooser fc;
	protected File directory;
	protected File file;
	private final JDateChooser dateCh;
	private DefaultTableModel model;
	protected JFrame f;
	protected JLabel lblabout1, lblabout2;
	private SimpleDateFormat dateFormat;
	
	
	
//class constructor
public CalenderUserInterface(String username) 
{	
		this.dateCh = new JDateChooser();
		//calendermodel.dateCh = new JDateChooser();
		this.itmExit = new JMenuItem("Exit");
		this.itmSave = new JMenuItem("Save");
		this.itmOpen = new JMenuItem("Open");
		this.itmAbout = new JMenuItem("About");
		this.btnNewButton = new JButton("Save");
		//this.btnNewButton_1 = new JButton("Edit");
		this.btnNewButton_2 = new JButton("Clear");
		this.btnNewButton_3 = new JButton("Delete");
		this.btnOpen = new JButton("Open");
		this.username=username;
		
		//calling UI elements creation
		initComponents();
		
		//exit item click action
		itmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()== itmExit){
					int x = JOptionPane.showConfirmDialog(
							rootPane, "Are you sure?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
					if(x==0){
						System.out.println(x);
						System.exit(0);
					}
				}
			}
		});
		
		//Save item click action
		itmSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					savemenuitem();
				
				}
		 });
		
		//Open item click action
		itmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayInTable();				
			}
		});
		
		//About item click action
		itmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutmenuitem();			    
			}
		});
		
		//Save button click action
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				savebutton();
			}
		});
		
		//Edit button click action
		//btnNewButton_1.addActionListener(new ActionListener() {
		//	public void actionPerformed(ActionEvent arg0) {
				//edit();
		//	}
		//});
		//Clear button click action
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			clear();
				}
		});
		
		//Delete button click action
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				delete();
			}
		});
		
		//Open button click action
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayInTable();			
			}
		});
}

//This method is creating UI elements
public void initComponents() {
		setBounds(100, 100, 811, 417);
		setLocationRelativeTo(null);
		setTitle("Reminder");
		
		menuBar1 = new JMenuBar();
		menuBar1.setBackground(Color.WHITE);
		setJMenuBar(menuBar1);
		
		mnFile = new JMenu("File");
		menuBar1.add(mnFile);
		mnFile.add(itmOpen);	
		mnFile.add(itmSave);
		mnFile.add(itmExit);
		itmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));
		itmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
		mnHelp = new JMenu("Help");
		menuBar1.add(mnHelp);
		mnHelp.add(itmAbout);
		itmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
		itmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
		
		minPanel = new JPanel();
		minPanel.setForeground(Color.LIGHT_GRAY);
		minPanel.setBackground(new Color(51, 102, 204));
		minPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(minPanel);
		minPanel.setLayout(null);
		
		creatEventPanel = new JPanel();
		creatEventPanel.setBackground(new Color(51, 102, 204));
		creatEventPanel.setBorder(new TitledBorder(null, "Set New Event", TitledBorder.CENTER, TitledBorder.TOP, null, Color.ORANGE));
		creatEventPanel.setName("");
		creatEventPanel.setBounds(486, 13, 298, 295);
		minPanel.add(creatEventPanel);
		creatEventPanel.setLayout(null);
		
		lblEventName = new JLabel("Event Name");
		lblEventName.setForeground(Color.WHITE);
		lblEventName.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblEventName.setBounds(10, 23, 80, 23);
		creatEventPanel.add(lblEventName);
		
		txtEvent = new JTextField();
		txtEvent.setBackground(Color.LIGHT_GRAY);
		txtEvent.setBounds(108, 21, 161, 29);
		creatEventPanel.add(txtEvent);
		txtEvent.setColumns(10);
		
		lblDate = new JLabel("Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblDate.setBounds(10, 74, 46, 29);
		creatEventPanel.add(lblDate);
		
	    
		dateCh.setForeground(Color.LIGHT_GRAY);
		dateCh.setBorder(null);
		dateCh.setBackground(Color.LIGHT_GRAY);
		dateCh.setBounds(108, 74, 161, 29);
		creatEventPanel.add(dateCh);
		
		lblTime = new JLabel("Time");
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblTime.setBounds(10, 137, 46, 29);
		creatEventPanel.add(lblTime);
	    	
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(120, 194, 100, 23);
		creatEventPanel.add(btnNewButton);
		
		txtTime = new JTextField();
		txtTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTime.setHorizontalAlignment(SwingConstants.CENTER);
		txtTime.setText("00:00:00");
		txtTime.setBounds(108, 139, 161, 27);
		creatEventPanel.add(txtTime);
		txtTime.setColumns(10);
		
	/*	btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(81, 194, 89, 23);
		creatEventPanel.add(btnNewButton_1);*/
		recentEventPanel = new JPanel();
		recentEventPanel.setBackground(new Color(51, 102, 204));
		recentEventPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Recent Events", TitledBorder.CENTER, TitledBorder.TOP, null, Color.ORANGE));
		recentEventPanel.setBounds(12, 13, 462, 295);
		minPanel.add(recentEventPanel);
		
		scrollPane = new JScrollPane();
		
		panel = new JPanel();
		panel.setBackground(new Color(51, 102, 204));
		gl_recentEventPanel = new GroupLayout(recentEventPanel);
		gl_recentEventPanel.setHorizontalGroup(
			gl_recentEventPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_recentEventPanel.createSequentialGroup()
					.addGroup(gl_recentEventPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_recentEventPanel.setVerticalGroup(
			gl_recentEventPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_recentEventPanel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"EVENT", "DATE", "TIME"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(119);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(76);
		scrollPane.setViewportView(table_1);
		panel.setLayout(null);
		
		
		btnNewButton_2.setBounds(177, 21, 89, 23);
		panel.add(btnNewButton_2);
		
		
		btnNewButton_3.setBounds(311, 21, 89, 23);
		panel.add(btnNewButton_3);
		
		
		btnOpen.setBounds(33, 21, 89, 23);
		panel.add(btnOpen);
		recentEventPanel.setLayout(gl_recentEventPanel);
	}

//This method is providing data on the frame in table format
public void displayInTable() {
	InputStream is = null;
	fc = new JFileChooser(directory);
	int option = fc.showOpenDialog(rootPane);
	if(option == JFileChooser.APPROVE_OPTION){
		file = fc.getSelectedFile();
		directory = fc.getCurrentDirectory();
		try{
			File f = file;
			is = new FileInputStream(f);
			Scanner scan = new Scanner(is);
			String[] arr;
			while(scan.hasNextLine()){
				String line = scan.nextLine();
				if(line.indexOf(",")>1){
					arr = line.split(",");
				}else{
					arr = line.split("\n");
				}
				Object[] data = new Object[arr.length];
				for(int i=0;i<data.length;i++){
					data[i] = arr[i];
				}
				DefaultTableModel model = (DefaultTableModel)table_1.getModel();
				model.addRow(data);
			}
		}
		catch(Exception e1){
			JOptionPane.showMessageDialog(null,"Can not open the file!");
		}
		finally{
			try{
				if(is!=null){
					is.close();
				}
			}catch(Exception e2){
				JOptionPane.showMessageDialog(null,"No input data available!");
			}
		}
	}
}

//This method clears all the data available 
public void clear() {
	DefaultTableModel model = (DefaultTableModel)table_1.getModel();
	if(table_1.getRowCount()>0){
		for(int i = table_1.getRowCount()-1; i>-1; i--){
			model.removeRow(i);
		}
	}
}
//This method is to delete any stored event
public void delete() {
	DefaultTableModel model  = (DefaultTableModel)table_1.getModel();
	if(table_1.getSelectedRow()==-1){
		if(table_1.getRowCount()==0){
			JOptionPane.showMessageDialog(null,"No data to be deleted.!");
		}
		else{
			JOptionPane.showMessageDialog(null,"You must select an item.!");
		}
	}
	else{
		model.removeRow(table_1.getSelectedRow());
	}
}
//This method is to edit an event
/*public void edit() {
	model = (DefaultTableModel)table_1.getModel();
    model.setValueAt(txtEvent.getText(),table_1.getSelectedRow(),0);
    dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    model.setValueAt(dateFormat.format(dateCh.getDate()),table_1.getSelectedRow(),1);
    model.setValueAt(txtTime.getText(),table_1.getSelectedRow(),2);
	
}*/

//This method is to save the event details
public void savebutton() {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	String date = dateFormat.format(dateCh.getDate());
	String event = txtEvent.getText();
	String time = txtTime.getText();
	
	if(event.isEmpty()){
		JOptionPane.showMessageDialog(null,"Please Enter An Event.");
		txtEvent.requestFocus();
	}
	else{
		DefaultTableModel model = (DefaultTableModel)table_1.getModel();
		model.addRow(new Object[]{event,date,time});
	}
}

//This method is to save the data
public void savemenuitem() {
	fc = new JFileChooser(directory);
	// add file filter
	FileNameExtensionFilter filter;
	filter = new FileNameExtensionFilter("*.txt", new String[]{"txt"});
	fc.addChoosableFileFilter(filter);
	int option = fc.showSaveDialog(rootPane);
	if(option == JFileChooser.APPROVE_OPTION){
		directory = fc.getCurrentDirectory();
		
		file = fc.getSelectedFile();
		try {
			//calendermodel.writeAll();
			BufferedWriter bw = null;
			try{
				String ext = "";
				String extension = fc.getFileFilter().getDescription();
				if(extension.equals("*.txt")){
					ext = ".txt";
				}
				bw = new BufferedWriter(new FileWriter(file+ext,false));
				
				for(int i=0;i<table_1.getRowCount();i++){
					for(int j=0;j<table_1.getColumnCount();j++){
						bw.write((String)table_1.getModel().getValueAt(i,j)+" , ");
					}
					bw.write("\r\n");
				}
				bw.write("\n");
				JOptionPane.showMessageDialog(null,"Data saved !");
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,"Unable to save data!");
			}
			finally{
				if(bw!=null){
					bw.close();
				}
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"No data to put in buffered writer!");
		}
		
	}
}
//This method gives information about the 
public void aboutmenuitem() {
	JFrame f = new JFrame("About");
	f.setVisible(true);
	f.setSize(300,300);
	f.setLocationRelativeTo(null);
	f.getContentPane().setLayout(new FlowLayout());
	lblabout1 = new JLabel();
	lblabout2 = new JLabel();
	f.add(lblabout1);
	f.add(lblabout2);
						
	lblabout1.setText("The calender application is used to save the event details. The developers of this application are: Pooja And Nishant");
	lblabout2.setText("For any query contact +12434543672");
	
}

}
