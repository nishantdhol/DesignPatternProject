package schoolEnlightmentSystem;

import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;


//This class is the View of MVC(TeacherSubCoursesView,TeacherSubCoursesModel,TeacherSubCoursesController) pattern.
public class TeacherSubCoursesController {
	private TeacherSubCoursesView view;
    private TeacherSubCoursesModel model;
    String username,subcourse;

/*Initializing the TeacherSubCoursesController constructor and 
* also initializing TeacherSubCoursesView and TeacherSubCoursesModel objects */	 
public TeacherSubCoursesController(TeacherSubCoursesView view){
        this.view = view;
        model = new TeacherSubCoursesModel(username,subcourse);
        initView();
    }

//This method is providing the user inputs
public void initView() {
	   view.getSubject_textField();
	   view.getStd_textField();
	   view.getFilename_textField();
	   view.getFileext_textField();
	   view.getFile_textField();
	   view.getUploader_textField();
	  
   	
    }

/*This method is providing the user input data to the database model*/
public void checkFileDetails(String file, String stdname,String subname,String filename, String fileext, String uploder) {
	
	   model.setSub_input(file);
	   model.setStd_input(stdname);
	   model.setSub_input(subname);
	   model.setFilename_input(filename);
	   model.setFileext_input(fileext);
	   model.setUploader_input(uploder);
		if(file.equals("")) {
			view.setMessage("Enter the file path");
		}if(stdname.equals("")) {
			view.setMessage("Enter the standard");
		}
		
		if(subname.equals("")) {
			view.setMessage("Enter the subject");
		}
		if(filename.equals("")) {
			view.setMessage("Enter the filename");
		}
		if(fileext.equals("")) {
			view.setMessage("Re-Enter the file extension");
		}		
		if(uploder.equals("")) {
			view.setMessage("Enter the name of person uploading the file");
		}
		else
			try {
				model.getFileDetails(view);	
		
				view.setMessage("File Uploaded Successfully");
            
            
		 
	} catch (Exception e1) {
		view.setMessage("Check the details again");
		
	}
		

   }
}
