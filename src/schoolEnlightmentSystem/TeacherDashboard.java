package schoolEnlightmentSystem;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;


//This class is creating student dash board 
public class TeacherDashboard extends JFrame {
		private String username;
	    private JLabel exit, financial_accnt_jLabel_img,jLabel13,
	    jLabel14, jLabel15, jLabel16, notifications_jLabel_img, 
	    profile_jlabel_img,courses_jLabel_img, grades_jLabel_img, settings_jLabel_img;
	    private JPanel jPanel1, jPanel2, notifications_jPanel,
	    home_jPanel, course_jPanel5, grades_jPanel, settings_jPanel,finacial_accnt_jPanel;
	    private javax.swing.JSeparator jSeparator1;
	    private JTextField jTextField1;
	    int xx,xy;
	    private JLabel settings_jlabel,courses_jlabel, financial_account_jlabel, grades_jlabel, library_jlabel;
	     
	//class constructor	
	public TeacherDashboard(String username) {
	        this.username=username;
	    	initComponents();
	 }

	public String getUsername() {
			return username;
	}
		
	//This method is creating UI elements
	public void initComponents() {

			        jPanel1 = new javax.swing.JPanel();
			        jPanel2 = new javax.swing.JPanel();
			        jLabel13 = new javax.swing.JLabel();
			        exit = new javax.swing.JLabel();
			        jLabel15 = new javax.swing.JLabel();
			        jLabel15.setText(username);
			        //jTextField1 = new javax.swing.JTextField();
			        //jSeparator1 = new javax.swing.JSeparator();
			        jLabel14 = new javax.swing.JLabel();
			        //jLabel16 = new javax.swing.JLabel();
			        notifications_jPanel = new javax.swing.JPanel();
			        notifications_jLabel_img = new javax.swing.JLabel();
			        notifications_jLabel_img.setIcon(new ImageIcon("Images\\icons8-notification-96.png"));
			        home_jPanel = new javax.swing.JPanel();
			        home_jPanel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
			        home_jPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			        home_jPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
			        profile_jlabel_img = new javax.swing.JLabel();
			        
			        profile_jlabel_img.addMouseListener(new MouseAdapter() {
			        	@Override
			        	public void mouseEntered(MouseEvent arg0) {
			        	}
			        });
			        profile_jlabel_img.setIcon(new ImageIcon("Images\\icons8-profile-96.png"));
			        course_jPanel5 = new javax.swing.JPanel();
			        courses_jLabel_img = new javax.swing.JLabel();
			        courses_jLabel_img.setIcon(new ImageIcon("Images\\icons8-books-96.png"));
			        grades_jPanel = new javax.swing.JPanel();
			        grades_jLabel_img = new javax.swing.JLabel();
			        grades_jLabel_img.setIcon(new ImageIcon("Images\\icons8-planner-96.png"));
			        settings_jPanel = new javax.swing.JPanel();
			        settings_jPanel.setForeground(new Color(0, 0, 0));
			        settings_jLabel_img = new javax.swing.JLabel();
			        settings_jLabel_img.setIcon(new ImageIcon("Images\\icons8-briefcase-settings-96.png"));
			        finacial_accnt_jPanel = new javax.swing.JPanel();
			        financial_accnt_jLabel_img = new javax.swing.JLabel();
			        financial_accnt_jLabel_img.setIcon(new ImageIcon("Images\\icons8-email-open-96.png"));

			        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
			        setLocationByPlatform(true);
			        setUndecorated(true);
			        setPreferredSize(new java.awt.Dimension(800, 650));

			        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
			        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));
			        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
			        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

			        jPanel2.setBackground(new java.awt.Color(51, 102, 204));
			        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			            public void mouseDragged(java.awt.event.MouseEvent evt) {
			                jPanel2MouseDragged(evt);
			            }
			        });
			        
			        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
			            public void mousePressed(java.awt.event.MouseEvent evt) {
			            	 xx = evt.getX();
			  		        xy = evt.getY();
			            }
			        });
			        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

			        jLabel13.setFont(new Font("Comic Sans MS", Font.BOLD, 30)); // NOI18N
			        jLabel13.setForeground(SystemColor.desktop);
			        jLabel13.setText("Welcome to Dashboard");
			        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, -1, -1));

			        exit.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
			        exit.setForeground(new java.awt.Color(255, 255, 255));
			        exit.setText("X");
			        exit.addMouseListener(new java.awt.event.MouseAdapter() {
			            public void mousePressed(java.awt.event.MouseEvent evt) {
			            	System.exit(0);
			            }
			        });
			        jPanel2.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 22, -1));

			        jLabel15.setFont(new java.awt.Font("Comic Sans MS", Font.BOLD, 30)); // NOI18N
			        jLabel15.setForeground(SystemColor.desktop);
			        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, -1, -1));

			       // jTextField1.setBackground(new java.awt.Color(45, 118, 232));
			        //jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
			        //jTextField1.setForeground(new java.awt.Color(255, 255, 255));
			        //jTextField1.setBorder(null);
			        //jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 340, 25));
			        //jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 340, -1));
			        
			        jLabel14.setIcon(new ImageIcon("Images\\student_graduate.jpg")); // NOI18N
			        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 300));

			        //jLabel16.setIcon(new javax.swing.ImageIcon("Images\\search_20px_1.png")); // NOI18N
			        //jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 150, -1, -1));

			        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 300));

			        notifications_jPanel.setBackground(new Color(255, 127, 80));
			        notifications_jPanel.addMouseListener(new java.awt.event.MouseAdapter() {
			            public void mouseEntered(java.awt.event.MouseEvent evt) {
			            	setColor(notifications_jPanel);
			            }
			            public void mouseExited(java.awt.event.MouseEvent evt) {
			                resetColor(notifications_jPanel);
			            }
			        	@Override
			        	public void mouseClicked(java.awt.event.MouseEvent evt) {
			        		LibraryView library=new LibraryView(username);
					    	library.setVisible(true);
			        	}
			        });

			        notifications_jLabel_img.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
			        notifications_jLabel_img.setForeground(new java.awt.Color(45, 118, 232));
			        
			        library_jlabel = new JLabel("Library");
			        library_jlabel.setAlignmentY(Component.TOP_ALIGNMENT);
			        library_jlabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));

			        javax.swing.GroupLayout gl_notifications_jPanel = new javax.swing.GroupLayout(notifications_jPanel);
			        gl_notifications_jPanel.setHorizontalGroup(
			        	gl_notifications_jPanel.createParallelGroup(Alignment.LEADING)
			        		.addGroup(gl_notifications_jPanel.createSequentialGroup()
			        			.addGroup(gl_notifications_jPanel.createParallelGroup(Alignment.TRAILING)
			        				.addGroup(gl_notifications_jPanel.createSequentialGroup()
			        					.addContainerGap()
			        					.addComponent(library_jlabel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
			        				.addGroup(Alignment.LEADING, gl_notifications_jPanel.createSequentialGroup()
			        					.addGap(19)
			        					.addComponent(notifications_jLabel_img, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
			        			.addContainerGap(19, Short.MAX_VALUE))
			        );
			        gl_notifications_jPanel.setVerticalGroup(
			        	gl_notifications_jPanel.createParallelGroup(Alignment.LEADING)
			        		.addGroup(Alignment.TRAILING, gl_notifications_jPanel.createSequentialGroup()
			        			.addComponent(library_jlabel)
			        			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			        			.addComponent(notifications_jLabel_img, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
			        			.addGap(8))
			        );
			        notifications_jPanel.setLayout(gl_notifications_jPanel);

			        jPanel1.add(notifications_jPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 460, 140, 120));

			        home_jPanel.setBackground(new Color(204, 51, 102));
			        home_jPanel.addMouseListener(new java.awt.event.MouseAdapter() {
			            public void mouseEntered(java.awt.event.MouseEvent evt) {
			            	setColor(home_jPanel);
			            }
			            public void mouseExited(java.awt.event.MouseEvent evt) {
			      	        resetColor(home_jPanel);
			            }
			            
			            public void mouseClicked(java.awt.event.MouseEvent evt) { 
			            	ProfileView view=new ProfileView(username);
					    	view.setVisible(true);
			            }
			        });

			        profile_jlabel_img.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); // NOI18N
			        profile_jlabel_img.setForeground(new java.awt.Color(45, 118, 232));
			        
			        JLabel profile_jlabel = new JLabel("Profile");
			        profile_jlabel.setForeground(new Color(0, 0, 0));
			        profile_jlabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));

			        javax.swing.GroupLayout gl_home_jPanel = new javax.swing.GroupLayout(home_jPanel);
			        gl_home_jPanel.setHorizontalGroup(
			        	gl_home_jPanel.createParallelGroup(Alignment.LEADING)
			        		.addGroup(gl_home_jPanel.createSequentialGroup()
			        			.addGap(32)
			        			.addGroup(gl_home_jPanel.createParallelGroup(Alignment.LEADING)
			        				.addComponent(profile_jlabel_img)
			        				.addComponent(profile_jlabel))
			        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			        );
			        gl_home_jPanel.setVerticalGroup(
			        	gl_home_jPanel.createParallelGroup(Alignment.LEADING)
			        		.addGroup(gl_home_jPanel.createSequentialGroup()
			        			.addComponent(profile_jlabel)
			        			.addGap(6)
			        			.addComponent(profile_jlabel_img, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
			        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			        );
			        home_jPanel.setLayout(gl_home_jPanel);

			        jPanel1.add(home_jPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 140, 120));

			        course_jPanel5.setBackground(new java.awt.Color(204, 204, 51));
			        course_jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
			            public void mouseEntered(java.awt.event.MouseEvent evt) {
			               setColor(course_jPanel5);
			            }
			            public void mouseExited(java.awt.event.MouseEvent evt) {
			                resetColor(course_jPanel5);
			            }
			            
			        	@Override
			        	public void mouseClicked(java.awt.event.MouseEvent evt) {
			        		TeacherCoursesView courses = new TeacherCoursesView(username);
			        	}
			        });

			        courses_jLabel_img.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
			        courses_jLabel_img.setForeground(new java.awt.Color(45, 118, 232));
			        
			        courses_jlabel = new JLabel("Courses");
			        courses_jlabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));

			        javax.swing.GroupLayout gl_course_jPanel5 = new javax.swing.GroupLayout(course_jPanel5);
			        gl_course_jPanel5.setHorizontalGroup(
			        	gl_course_jPanel5.createParallelGroup(Alignment.LEADING)
			        		.addGroup(gl_course_jPanel5.createSequentialGroup()
			        			.addGroup(gl_course_jPanel5.createParallelGroup(Alignment.LEADING)
			        				.addGroup(gl_course_jPanel5.createSequentialGroup()
			        					.addGap(42)
			        					.addComponent(courses_jlabel))
			        				.addGroup(gl_course_jPanel5.createSequentialGroup()
			        					.addGap(21)
			        					.addComponent(courses_jLabel_img)))
			        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			        );
			        gl_course_jPanel5.setVerticalGroup(
			        	gl_course_jPanel5.createParallelGroup(Alignment.LEADING)
			        		.addGroup(gl_course_jPanel5.createSequentialGroup()
			        			.addComponent(courses_jlabel)
			        			.addGap(6)
			        			.addComponent(courses_jLabel_img, GroupLayout.PREFERRED_SIZE, 81, Short.MAX_VALUE)
			        			.addContainerGap())
			        );
			        course_jPanel5.setLayout(gl_course_jPanel5);

			        jPanel1.add(course_jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 140, 120));

			        grades_jPanel.setBackground(new Color(153, 102, 204));
			        grades_jPanel.addMouseListener(new java.awt.event.MouseAdapter() {
			            public void mouseEntered(java.awt.event.MouseEvent evt) {
			                //jPanel6MouseEntered(evt);
			            	setColor(grades_jPanel);
			            }
			            public void mouseExited(java.awt.event.MouseEvent evt) {
			                //jPanel6MouseExited(evt);
			            	resetColor(grades_jPanel);
			            }
			        	@Override
			        	public void mouseClicked(java.awt.event.MouseEvent evt) {
			        	CalenderUserInterface calender = new CalenderUserInterface(username);
			 			   calender.setVisible(true);
			 		    	 
			        	}
			        });

			        grades_jLabel_img.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
			        grades_jLabel_img.setForeground(new java.awt.Color(45, 118, 232));
			        
			        grades_jlabel = new JLabel("Calender");
			        grades_jlabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));

			        javax.swing.GroupLayout gl_grades_jPanel = new javax.swing.GroupLayout(grades_jPanel);
			        gl_grades_jPanel.setHorizontalGroup(
			        	gl_grades_jPanel.createParallelGroup(Alignment.TRAILING)
			        		.addGroup(gl_grades_jPanel.createSequentialGroup()
			        			.addGroup(gl_grades_jPanel.createParallelGroup(Alignment.LEADING)
			        				.addGroup(gl_grades_jPanel.createSequentialGroup()
			        					.addGap(38)
			        					.addComponent(grades_jlabel))
			        				.addGroup(gl_grades_jPanel.createSequentialGroup()
			        					.addGap(22)
			        					.addComponent(grades_jLabel_img)))
			        			.addContainerGap(22, Short.MAX_VALUE))
			        );
			        gl_grades_jPanel.setVerticalGroup(
			        	gl_grades_jPanel.createParallelGroup(Alignment.LEADING)
			        		.addGroup(gl_grades_jPanel.createSequentialGroup()
			        			.addComponent(grades_jlabel)
			        			.addPreferredGap(ComponentPlacement.RELATED)
			        			.addComponent(grades_jLabel_img, GroupLayout.PREFERRED_SIZE, 84, Short.MAX_VALUE)
			        			.addContainerGap())
			        );
			        grades_jPanel.setLayout(gl_grades_jPanel);

			        jPanel1.add(grades_jPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 140, 120));

			        settings_jPanel.setBackground(new Color(255, 204, 204));
			        settings_jPanel.addMouseListener(new java.awt.event.MouseAdapter() {
			            public void mouseEntered(java.awt.event.MouseEvent evt) {
			                //jPanel7MouseEntered(evt);
			            	setColor(settings_jPanel);
			            }
			            public void mouseExited(java.awt.event.MouseEvent evt) {
			                //jPanel7MouseExited(evt);
			            	resetColor(settings_jPanel);
			            }
			        	@Override
			        	public void mouseClicked(java.awt.event.MouseEvent evt) {
			        		SettingsView settings = new SettingsView(username);
							settings.setVisible(true);
			        	}
			        });

			        settings_jLabel_img.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
			        settings_jLabel_img.setForeground(new java.awt.Color(45, 118, 232));
			        
			        settings_jlabel = new JLabel("Settings");
			        settings_jlabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));

			        javax.swing.GroupLayout gl_settings_jPanel = new javax.swing.GroupLayout(settings_jPanel);
			        gl_settings_jPanel.setHorizontalGroup(
			        	gl_settings_jPanel.createParallelGroup(Alignment.TRAILING)
			        		.addGroup(gl_settings_jPanel.createSequentialGroup()
			        			.addContainerGap(34, Short.MAX_VALUE)
			        			.addGroup(gl_settings_jPanel.createParallelGroup(Alignment.TRAILING)
			        				.addGroup(gl_settings_jPanel.createSequentialGroup()
			        					.addComponent(settings_jLabel_img)
			        					.addGap(20))
			        				.addGroup(gl_settings_jPanel.createSequentialGroup()
			        					.addComponent(settings_jlabel)
			        					.addGap(41))))
			        );
			        gl_settings_jPanel.setVerticalGroup(
			        	gl_settings_jPanel.createParallelGroup(Alignment.LEADING)
			        		.addGroup(gl_settings_jPanel.createSequentialGroup()
			        			.addComponent(settings_jlabel)
			        			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			        			.addComponent(settings_jLabel_img, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
			        			.addContainerGap())
			        );
			        settings_jPanel.setLayout(gl_settings_jPanel);

			        jPanel1.add(settings_jPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 460, 140, 120));

			        finacial_accnt_jPanel.setBackground(new Color(255, 102, 153));
			        finacial_accnt_jPanel.addMouseListener(new java.awt.event.MouseAdapter() {
			            public void mouseEntered(java.awt.event.MouseEvent evt) {
			               setColor(finacial_accnt_jPanel);
			            }
			            public void mouseExited(java.awt.event.MouseEvent evt) {
			                 resetColor(finacial_accnt_jPanel);
			            }
			        	@Override
			        	public void mouseClicked(java.awt.event.MouseEvent evt) {
			        		Notifications notifications = new Notifications(username);
			 				notifications.setVisible(true);
			        	}
			        });

			        financial_accnt_jLabel_img.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
			        financial_accnt_jLabel_img.setForeground(new java.awt.Color(45, 118, 232));
			        
			        financial_account_jlabel = new JLabel("Inbox");
			        financial_account_jlabel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

			        javax.swing.GroupLayout gl_Finacial_accnt_jPanel = new javax.swing.GroupLayout(finacial_accnt_jPanel);
			        gl_Finacial_accnt_jPanel.setHorizontalGroup(
			        	gl_Finacial_accnt_jPanel.createParallelGroup(Alignment.TRAILING)
			        		.addGroup(gl_Finacial_accnt_jPanel.createSequentialGroup()
			        			.addContainerGap(21, Short.MAX_VALUE)
			        			.addGroup(gl_Finacial_accnt_jPanel.createParallelGroup(Alignment.TRAILING)
			        				.addComponent(financial_accnt_jLabel_img, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
			        				.addComponent(financial_account_jlabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
			        			.addGap(25))
			        );
			        gl_Finacial_accnt_jPanel.setVerticalGroup(
			        	gl_Finacial_accnt_jPanel.createParallelGroup(Alignment.TRAILING)
			        		.addGroup(Alignment.LEADING, gl_Finacial_accnt_jPanel.createSequentialGroup()
			        			.addComponent(financial_account_jlabel)
			        			.addPreferredGap(ComponentPlacement.RELATED)
			        			.addComponent(financial_accnt_jLabel_img, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
			        			.addContainerGap(39, Short.MAX_VALUE))
			        );
			        finacial_accnt_jPanel.setLayout(gl_Finacial_accnt_jPanel);
			        
			        jPanel1.add(finacial_accnt_jPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, 140, 120));
			        
			        JLabel lblNewLabel = new JLabel("New label");

			        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
			        layout.setHorizontalGroup(
			        	layout.createParallelGroup(Alignment.LEADING)
			        		.addGroup(layout.createSequentialGroup()
			        			.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
			        			.addPreferredGap(ComponentPlacement.RELATED)
			        			.addComponent(lblNewLabel)
			        			.addGap(400))
			        );
			        layout.setVerticalGroup(
			        	layout.createParallelGroup(Alignment.LEADING)
			        		.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 650, Short.MAX_VALUE)
			        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
			        			.addContainerGap(594, Short.MAX_VALUE)
			        			.addComponent(lblNewLabel)
			        			.addGap(40))
			        );
			        getContentPane().setLayout(layout);

			        pack();
			    }// </editor-fold>//GEN-END:initComponents

	 private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
			        // TODO add your handling code here:
			        int x = evt.getXOnScreen();
			        int y = evt.getYOnScreen();
			        this.setLocation(x - xx, y - xy);  
			    }//GEN-LAST:event_jPanel2MouseDragge 
				    
	public void setColor(JPanel panel)
			 {
			     panel.setBackground(new java.awt.Color(197, 197, 197));
			 }
			 
	public void resetColor(JPanel panel)
			 {
			     panel.setBackground(new java.awt.Color(240,240,240));
			 }
			   
	}



