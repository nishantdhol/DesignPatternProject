package schoolEnlightmentSystem;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

//This class in the Controller in MVC(CoursesView,CoursesModel,CoursesController) pattern
public class CoursesController {
	CoursesModel model;
	CoursesView view;
	private String username;
	private ArrayList<String> subjects_input;
	private String standard_input;
    private JButton[] btn_input;
 
//class constructor and objects creation on CoursesModel and CoursesView class
public CoursesController(CoursesView view){
		this.view=view;
		username=view.getUsername();
		model=new CoursesModel(username);
		initView();
	}

//This method is providing the model input to view	
public void initView() {

			view.setStandard(standard_input);
			view.setSubjects(subjects_input);
			view.setBtn(btn_input);
			view.getCourseframe();
		    }

//This method is checking the courses available against the logged in user and opening sub courses window
public void checkCourses() {
		
		model.getCourses();
		standard_input=model.getStandard();
		subjects_input=model.getSubjects();
		view.courseframe= new JFrame("Courses");
		
		
		for (int i = 0; i < subjects_input.size(); i++) {
		btn_input=model.getBtn();
		btn_input[i] = new JButton(subjects_input.get(i));

		view.courseframe.add(btn_input[i]);
		view.courseframe.setTitle("Courses Window");
			String subcourse = subjects_input.get(i);
			btn_input[i].addMouseListener(new java.awt.event.MouseAdapter() {
	        	@Override
	        	public void mouseClicked(java.awt.event.MouseEvent evt) {
	        		SubCoursesView sc =new SubCoursesView(username,subcourse);
	        		sc.setVisible(true);
	        		sc.setTitle(subcourse+"Window");
	        		sc.setSize(800, 800);
	        	}
	        });
		}
		view.courseframe.setLayout(new GridLayout(0, 1));
		view.courseframe.setSize(600, 600);
		view.courseframe.setVisible(true);
	}

}
