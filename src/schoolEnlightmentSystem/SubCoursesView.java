package schoolEnlightmentSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

//This is the Subcourses class
public class SubCoursesView extends JFrame {


	private JPanel contentPane;
	private String username;
	private String standard;
	private String subcourse;
	private final JFileChooser openFileChooser;
	private BufferedImage originalBI;
	private JLabel messageLabel;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable_Files_Name;
	private String fileExtension;
	private String filename;
	

//class constructor
public SubCoursesView(String username,String subcourse) {
	openFileChooser = new JFileChooser();
	setTitle("SubCourses");
	this.username=username;
	this.subcourse=subcourse;
	initComponents();
    getFilesName();
   /* try {
		downloadBinaryFilesFromDatabase();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
   	
   	
	}
//public String getUsername() {
	//	return username;
	//}


private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    jTable_Files_Name = new javax.swing.JTable();

    //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jTable_Files_Name.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            }
    ));
    jScrollPane1.setViewportView(jTable_Files_Name);
    
    JButton download_button = new JButton("Download\r\n");
    filename = null;
	fileExtension = null;
    download_button.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		download();    		
    	}
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    layout.setHorizontalGroup(
    	layout.createParallelGroup(Alignment.LEADING)
    		.addGroup(layout.createSequentialGroup()
    			.addContainerGap()
    			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 575, GroupLayout.PREFERRED_SIZE)
    			.addPreferredGap(ComponentPlacement.RELATED)
    			.addComponent(download_button)
    			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
    	layout.createParallelGroup(Alignment.LEADING)
    		.addGroup(layout.createSequentialGroup()
    			.addContainerGap()
    			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    			.addContainerGap())
    		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
    			.addContainerGap(295, Short.MAX_VALUE)
    			.addComponent(download_button)
    			.addGap(108))
    );
    getContentPane().setLayout(layout);

    pack();
}// </editor-fold>                      


public void getFilesName()
{	
	
	Connection con;
	try {
		con= ConnectionProvider.getConnection();
		String select_query="SELECT files.file_name FROM files inner join student_data on student_data.standard=files.standard inner join courses on courses.course_name= files.Subjects and courses.Standard=files.Standard where student_data.user_name=? and files.Subjects=?";
		PreparedStatement st1=con.prepareStatement(select_query);
		st1.setString(1, username);
		st1.setString(2, subcourse);
		ResultSet rs=st1.executeQuery();
		//if(rs.next()) {
			 //String path= rs.getString("file_name");
			// File file = new File(getClass().getResource(select_query).getFile());
			 //File[] files = file.listFiles();

		
		ResultSetMetaData rsmd = rs.getMetaData(); 
		int columnCount = rsmd.getColumnCount();
		ArrayList<String> resultList= new ArrayList<>(columnCount); 
		while (rs.next()) {
		   int i = 1;
		   while(i <= columnCount) {
		        resultList.add(rs.getString(i++));
		   }
		}
			    DefaultTableModel model = (DefaultTableModel)jTable_Files_Name.getModel();

			    model.setColumnIdentifiers(new String[]{"Files Names"});

			    Object[] row = new Object[1];
			    
			    for(int i = 0; i < resultList.size(); i++)
			    {

			        row[0] = resultList.get(i);
			        

			        model.addRow(row);

			   }		
			 

	
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "Unable to load files!");
	}
}

public void download() {
	Connection connection;
	try {
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/client", "root", "");
	
	String SQL1="SELECT files.file,files.file_name,files.file_extension FROM files inner join student_data on student_data.standard=files.standard inner join courses on courses.course_name= files.Subjects and courses.Standard=files.Standard where student_data.user_name=? and files.Subjects=?";
	PreparedStatement ps1 = connection.prepareStatement(SQL1);
	ps1.setString(1, username);
	ps1.setString(2, subcourse);
	ResultSet rs = ps1.executeQuery();


while (rs.next()) {
	Blob file = rs.getBlob("files.file");
	String filename = rs.getString("files.file_name");
	String fileExtension = rs.getString("files.file_extension");
	
	InputStream inputStream = file.getBinaryStream();
	
	
	Files.copy(inputStream, Paths.get("InputFiles/"+filename+"."+fileExtension));
	
}
JOptionPane.showMessageDialog(null, "File Downloaded Successfully!");
} catch (IOException | SQLException e) {

	JOptionPane.showMessageDialog(null, "File Already Downloaded");
}
}

}

