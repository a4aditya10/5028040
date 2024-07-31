public class Test {
    public static void main(String[] args) {

        // Creating model
        Student model = new Student("1", "Rushda Aliya", "A");

        // Creating view
        StudentView view = new StudentView();

        // Creating controller
        StudentController controller = new StudentController(model, view);

        // Retrieve and print student name
        System.out.printf("Student Name: %s%n\n", controller.getStudentName());

        // Display initial student details
        controller.updateView();

        // Updating student details
        controller.setStudentName("Ritika Verma");
        controller.setStudentGrade("A+");

        // Display updated student details
        controller.updateView();
    }
}
