import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

	File studentsFile = new File("students.txt");

	public void writeStudentList(List<Student> student) {

		try (FileOutputStream fos = new FileOutputStream(studentsFile);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(student);
			oos.flush();
		} catch (IOException e) {
			System.out.println("Unable to write student list to file: " + e);
		}

	}

	public List<Student> readStudentList() {
		List<Student> studentList = new ArrayList<>();

		try (FileInputStream fos = new FileInputStream(studentsFile);
				ObjectInputStream oos = new ObjectInputStream(fos)) {
			studentList = (List<Student>) oos.readObject();
		} catch (Exception e) {
			System.out.println("Unable to read student list from file:" + e);
		}

		return studentList;
	}

	public void addStudent(Student student) {
		List<Student> studentList = readStudentList();
		studentList.add(student);
		writeStudentList(studentList);
	}

	public void deleteStudent(int index) {
		List<Student> studentList = readStudentList();
		studentList.remove(index);
		writeStudentList(studentList);
	}


}
