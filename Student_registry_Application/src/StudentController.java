import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class StudentController {

	StudentDAO studentDAO = new StudentDAO();
	int noteIndex=-1;

	@FXML
	private ListView<Student> lvStudents;

	@FXML
	private BorderPane mainBody;

	@FXML
	private Button btnAddStudent;

	@FXML
	private ToggleGroup enrollmentType;

	@FXML
	private RadioButton rtEnrollmentTypeFT;

	@FXML
	private RadioButton rtEnrollmentTypePT;

	@FXML
	private TextField txtStudentFirstName;

	@FXML
	private TextField txtStudentId;

	@FXML
	private TextField txtStudentLastName;

	@FXML
	private TextField txtStudentProgram;

	@FXML
	void addStudent(ActionEvent event) {
		setView("AddStudentView");
	}

	@FXML
	void saveStudent(ActionEvent event) {
		String id = txtStudentId.getText();
		String firstName = txtStudentFirstName.getText();
		String lastName = txtStudentLastName.getText();
		String program = txtStudentProgram.getText();

		Student student;

		if (rtEnrollmentTypeFT.isSelected()) {
			student = new FullTimeStudent(id, firstName, lastName, program);
		} else {
			student = new PartTimeStudent(id, firstName, lastName, program);
		}

		studentDAO.addStudent(student);
		setView("ListStudentView");
		viewStudentList();
	}

	@FXML
	void viewStudentList(ActionEvent event) {
		setView("ListStudentView");
		viewStudentList();
	}

	public void setView(String name) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(name + ".fxml"));
			loader.setController(this);
			Pane view = loader.load();
			mainBody.setCenter(view);

		} catch (Exception e) {
			System.out.println("Error loading " + name + ".fxml " + e);
		}
	}

	@FXML
    private TextField DtxtStudentFirstName;

    @FXML
    private TextField DtxtStudentId;

    @FXML
    private TextField DtxtStudentLastName;

    @FXML
    private TextField DtxtStudentProgram;

    @FXML
    private Button btnDeleteStudent;

    @FXML
    private ToggleGroup DenrollmentType;

    @FXML
    private RadioButton rFEnrollmentType;

    @FXML
    private RadioButton rPEnrollmentType;

    @FXML
    void deleteStudent(ActionEvent event) 
	{
		studentDAO.deleteStudent(noteIndex);
        
		setView("ListStudentView");
		viewStudentList();
	 }

	 void viewStudentList()
	{
         List<Student> studentList;
		try {
			studentList = studentDAO.readStudentList();
			lvStudents.getItems().setAll(studentList);
		} catch (Exception e) {
			System.out.println("Error occured during show student list view: " + e);
		}
	}

	@FXML
    void openStudent(MouseEvent event) {
	
	Student student = (Student) lvStudents.getSelectionModel().getSelectedItem();
	noteIndex = lvStudents.getSelectionModel().getSelectedIndex();

	setView("DeleteStudentView");
	setStudent(student);
    }

	public void setStudent(Student student)
	{
       DtxtStudentFirstName.setText(student.getFirstName());
	   DtxtStudentId.setText(student.getId());
	   DtxtStudentLastName.setText(student.getLastName());
	   DtxtStudentProgram.setText(student.getProgram());
	   if(student.getEnrollmentType().equals("Full Time"))
	   {
		 rFEnrollmentType.setSelected(true);
		 rPEnrollmentType.setSelected(false);
	   }
	   else
	   {
		rPEnrollmentType.setSelected(true);
		rFEnrollmentType.setSelected(false);
	   }

	}


}

