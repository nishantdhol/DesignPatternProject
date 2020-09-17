package schoolEnlightmentSystem;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//This class is the model of MVC pattern(TeacherSubCoursesModel,TeacherSubCoursesView,TeacherSubCoursesController)
public class TeacherSubCoursesModel {
	private String username,subcourse;
	private String sub_input,std_input,filename_input,fileext_input,file,uploader_input;

//class constructor
public TeacherSubCoursesModel(String username,String subcourse) {
	this.username=username;
	this.subcourse=subcourse;
}

//getters and setters
public String getSub_input() {
		return sub_input;
	}


	public void setSub_input(String sub_input) {
		this.sub_input = sub_input;
	}


	public String getStd_input() {
		return std_input;
	}


	public void setStd_input(String std_input) {
		this.std_input = std_input;
	}


	public String getFilename_input() {
		return filename_input;
	}


	public void setFilename_input(String filename_input) {
		this.filename_input = filename_input;
	}


	public String getFileext_input() {
		return fileext_input;
	}


	public void setFileext_input(String fileext_input) {
		this.fileext_input = fileext_input;
	}


	public String getFile() {
		return file;
	}


	public void setFile(String file) {
		this.file = file;
	}


	public String getUploader_input() {
		return uploader_input;
	}


	public void setUploader_input(String uploader_input) {
		this.uploader_input = uploader_input;
	}

//This method is uploading file into database
public void getFileDetails(TeacherSubCoursesView tscview) {
		
		sub_input=tscview.getSubject_textField().getText();
		std_input=tscview.getStd_textField().getText();
		filename_input=tscview.getFilename_textField().getText();
		fileext_input=tscview.getFileext_textField().getText();
		file=tscview.getFile_textField().getText();
		uploader_input=tscview.getUploader_textField().getText();
		try {
			Connection con= ConnectionProvider.getConnection();
        
		PreparedStatement ps=con.prepareStatement("insert into files values(?,?,?,?,?,?)");  
		File f=new File(file);             
		FileReader fr=new FileReader(f);  
		              
		ps.setCharacterStream(1,fr,(int)f.length());
		ps.setString(2, std_input);
		ps.setString(3, sub_input);
		ps.setString(4, filename_input);
		ps.setString(5, fileext_input);
		ps.setString(6, uploader_input);
		ps.executeUpdate();  
		  
		              
		con.close();  
		              
		}catch (Exception e) {
			tscview.setMessage("Could not establish the connection!");  
			
		} 
	}
}
