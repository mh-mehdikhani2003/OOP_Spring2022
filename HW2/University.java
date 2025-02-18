import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import java.lang.Math;
class InputProcessor {
    Scanner scanner = new Scanner(System.in);
    Manager manager = new Manager();
    boolean semester=false;
    boolean register=false;
    boolean show=false;
    //passing to the right method based by starting
    public void start() {
        String input = scanner.nextLine();
        while (!input.equals("endShow")) {
            if (input.startsWith("addStudent")) {
                if(!semester && !show) {
                    proses_addStudent(input.split("\\s"));
                }
            } else if (input.startsWith("addLecturer")) {
                if(!semester && !show) {
                    proses_addLecturer(input.split("\\s"));
                }
            } else if (input.contains("register")) {
                if (register) {
                    proses_register(input.split("\\s"));
                }
            } else if (input.contains("capacitate")) {
                if(semester && register && !show) {
                    proses_capacitance(input.split("\\s"));
                }
            } else if (input.startsWith("W")) {
                if( !show) {
                    proses_DELETE(input.split("\\s"));
                }
            } else if (input.contains("mark")) {
                if(semester && !register) {
                    proses_mark(input.split("\\s"));
                }
            } else if (input.startsWith("start semester")) {
                semester=true;
                register=true;
            }else if(input.contains("end semester")){
                semester=false;
                show=true;
            }else if(input.contains("end registration")){
                register=false;
                Iterator<Course> itr1 =Course.getCourses().iterator();
                while (itr1.hasNext()){
                    Course a= itr1.next();
                    if(a.getNumberOfRegisteredStudents()<3) {
                        itr1.remove();
                    }
                }
                Iterator<Student> itr2 =Student.getStudents().iterator();
                int units=0;
               while (itr2.hasNext()){
                   Student b= itr2.next();
                   units=0;
                   for (Course studentCourses : b.getStudentCourses()) {
                       units+=studentCourses.getUnit();
                   }
                   if(units<12){
                       itr2.remove();
                   }
               }
            }else if(input.contains("addCourse")) {
                if(!semester) {
                    proses_addCourse(input.split("\\s"));
                }
            }else if(input.contains("showCourse")) {
                if(show) {
                    proses_showCourse(input.split("\\s"));
                }
            }else if(input.contains("showRanks")) {
                if(show) {
                    proses_showRanks(input.split("\\s"));
                }
            }else if(input.contains("showAverage")) {
                if(show) {
                    proses_showAverage(input.split("\\s"));
                }
            }
            input = scanner.nextLine();
        }
    }
    private void proses_addStudent(String[] split_input){
        manager.addStudent(split_input[1]);
    }
    private void proses_addLecturer(String[] split_input){
        ArrayList<String> courses=new ArrayList<>();
        if(split_input.length>2){
            for (int i = 2; i < split_input.length; i++) {
                courses.add(split_input[i]);
            }
        }
        manager.addLecturer(split_input[1],courses );
    }
    private void proses_register(String[] split_input){
        ArrayList<String> courses=new ArrayList<>();
        for (int i = 2; i < split_input.length; i++) {
            courses.add(split_input[i]);
        }
        manager.register(split_input[0],courses );
    }
    private void proses_capacitance(String[] split_input){
        manager.capacitance(split_input[0], split_input[2],split_input[3] );
    }
    private void proses_DELETE(String[] split_input){
        manager.DELETE(split_input[2],split_input[1]);
    }
    private void proses_mark(String[] split_input){
        ArrayList<String> studentIDs=new ArrayList<>();
        ArrayList<String> marks=new ArrayList<>();
        if(split_input[4].equals("-all")){
            String mark=split_input[3];
            manager.mark2(split_input[0], split_input[2],mark );
        }else {
            for (int i = 3; i < split_input.length-1; i+=2) {
                studentIDs.add(split_input[i]);
                marks.add(split_input[i+1]);
            }
            manager.mark1(split_input[0], split_input[2],studentIDs,marks);
        }

    }

    private void proses_addCourse(String[] split_input){
        manager.addCourse(Integer.parseInt(split_input[1]), Integer.parseInt(split_input[2]));
    }
    private void proses_showCourse(String[] split_input){
        manager.showCourse(Integer.parseInt(split_input[1]),split_input[2]);
    }
    private void proses_showRanks(String[] split_input){
        if(split_input[1].equals("-all")){
            manager.showRanks2();
        }else {
            manager.showRanks1(split_input[1]);
        }
    }
    private void proses_showAverage(String[] split_input){
        manager.showAverage(Integer.parseInt(split_input[1]));
    }

}

class Manager {
    public void addStudent(String studentID){
        boolean existence=false;
        for (Student student : Student.getStudents()) {
            if(student.getStudentID()==Integer.parseInt(studentID)){
                existence=true;break;
            }
        }
        if(!existence) {
            Student student = new Student();
            student.setStudentID(Integer.parseInt(studentID));
            student.setDeletedUnit(0);
            Student.addNewStudent(student);
        }
    }
    public void addLecturer(String lecturerID,ArrayList<String> courses){
        boolean existence=false;
        for (Lecturer lecturer : Lecturer.getLecturers()) {
            if(lecturer.getLecturerID()==Integer.parseInt(lecturerID)){
                existence=true;break;
            }
        }
        if(!existence){
            Lecturer lecturer =new Lecturer();
            lecturer.setLecturerID(Integer.parseInt(lecturerID));
            if(courses.size()>0){
                for (String s : courses) {
                    lecturer.addCourse(Integer.parseInt(s), Integer.parseInt(lecturerID));
                }
            }
            Lecturer.addNewLecturer(lecturer);
        }
    }
    public void register(String studentID,ArrayList<String> courseIDs){


        for (String courseID : courseIDs) {
            Student.registerCourse(Integer.parseInt(courseID),Integer.parseInt(studentID));
        }
    }
    public void capacitance(String lecturerID,String courseID,String n){
        Lecturer.addCapacity(Integer.parseInt(courseID),Integer.parseInt(lecturerID),
                Integer.parseInt(n));
    }
    public void DELETE(String studentID,String courseID){
        Student.deleteCourse(Integer.parseInt(courseID),Integer.parseInt(studentID));
    }
    public void mark1(String lecturerID,String courseId,ArrayList<String> studentIDs,
                      ArrayList<String>marks){
        for (int i = 0; i < studentIDs.size(); i++) {
            Lecturer.setMark(Integer.parseInt(courseId),Integer.parseInt(lecturerID),Double.parseDouble(marks.get(i)),
                    Integer.parseInt(studentIDs.get(i)));
        }
    }
    public void mark2(String lecturerID,String courseId,String markAll){

        for (Course course : Course.getCourses()) {
            if(course.getCourseID()==Integer.parseInt(courseId)){
                if(course.getLecturerID()==Integer.parseInt(lecturerID)){
                    for (int i = 0; i < course.getMarks().size(); i++) {
                        course.getMarks().set(i,Double.parseDouble(markAll));
                    }
                    for (int i = 0; i < course.getStudentIDs().size(); i++) {
                        for (Student student : Student.getStudents()) {
                            if(student.getStudentID()==course.getStudentIDs().get(i)){
                                student.setAverage(student.getAverage()+Double.parseDouble(markAll)*course.getUnit());break;
                            }
                        }
                    }
                }
            }
        }
    }
    public void addCourse(int courseID,int unit){
        boolean existence=false;
        for (Course course : Course.getCourses()) {
            if(course.getCourseID()==courseID){
                existence=true;break;
            }
        }
        if(!existence){
            Course course = new Course();
            course.setCourseID(courseID);
            course.setUnit(unit);
            course.setLecturerID(-1);
            course.setCapacity(15);
            Course.addNewCourse(course);
        }
    }

    public void showCourse(int courseID,String wanted){
        boolean existence=false;
        for (int i = 0; i < Course.getCourses().size(); i++) {
            if(Course.getCourses().get(i).getCourseID()==courseID){
                Course.getCourses().get(i).showCourse(wanted);
                existence=true;break;
            }
        }
        if(!existence){
            System.out.println("shoma daneshjoo nistid");
        }
    }

    public void showRanks1(String courseID){
        Course.show_ranks(Integer.parseInt(courseID));
    }
    public void showRanks2(){
        Student.showRanks_all();
    }
    public void showAverage(int StudentID){
        Student.showAverage(StudentID);
    }

}

class Lecturer {
    private static ArrayList<Lecturer>Lecturers = new ArrayList<>();
    private int LecturerID;
    private ArrayList<Course>courses = new ArrayList<>();

    public static void addNewLecturer(Lecturer lecturer){
        Lecturers.add(lecturer);
    }

    public void addCourse(int courseID,int lecturerID){
        for (Course cours : Course.getCourses()) {
            if(cours.getCourseID()==courseID){
                if(cours.getLecturerID()==-1){
                    cours.setLecturerID(lecturerID);
                    courses.add(cours);
                    break;
                }

            }
        }

    }

    public static void addCapacity (int courseID,int lecturerID,int number){
        for (Course course : Course.getCourses()) {
            if(course.getCourseID()==courseID){
                if(course.getLecturerID()==lecturerID){
                    course.setCapacity(course.getCapacity()+number);break;
                }
            }
        }
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public int getLecturerID() {
        return LecturerID;
    }

    public void setLecturerID(int lecturerID) {
        LecturerID = lecturerID;
    }

    public static ArrayList<Lecturer> getLecturers() {
        return Lecturers;
    }

    public static void setMark (int courseID, int lecturerID, double mark, int StudentID){
        for (Course course : Course.getCourses()) {

            if(course.getCourseID()==courseID){
                if(course.getLecturerID()==lecturerID){
                    for (int i = 0; i < course.getStudentIDs().size(); i++) {
                        if(course.getStudentIDs().get(i)==StudentID){
                            course.getMarks().set(i,mark);
                            for (Student student : Student.getStudents()) {
                                if(student.getStudentID()==StudentID){
                                    student.setAverage(student.getAverage()+mark*course.getUnit());
                                }
                            }
                        }
                    }
                }
            }

        }

    }
}

class Course {
    private static ArrayList<Course>courses = new ArrayList<>();
    private ArrayList<Integer> StudentIDs = new ArrayList<>();
    private ArrayList<Double> marks = new ArrayList<>();
    private int LecturerID;
    private int courseID;
    private int unit;
    private int capacity;
    private int numberOfRegisteredStudents;

    public int getLecturerID() {
        return LecturerID;
    }

    public void setLecturerID(int lecturerID) {
        LecturerID = lecturerID;
    }

    public ArrayList<Double> getMarks() {
        return marks;
    }


    public ArrayList<Integer> getStudentIDs() {
        return StudentIDs;
    }

    public void setStudentIDs(ArrayList<Integer> studentIDs) {
        StudentIDs = studentIDs;
    }

    public static void addNewCourse(Course course){
        courses.add(course);
    }
    public void incrementNumberOfRegisteredStudents(){

    }
    public void decrementNumberOfRegisteredStudents(){

    }
    public void addCapacity (int number){

    }


    public int getNumberOfRegisteredStudents() {
        return numberOfRegisteredStudents;
    }

    public void setNumberOfRegisteredStudents(int numberOfRegisteredStudents) {
        this.numberOfRegisteredStudents = numberOfRegisteredStudents;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public static ArrayList<Course> getCourses() {
        return courses;
    }


    public void showCourse (String wanted ){
        if(wanted.equals("students")){
            for (Integer id : StudentIDs) {
                System.out.print(id+" ");
            }
            System.out.println();
        }
        else if(wanted.equals("lecturer")){
            System.out.println(LecturerID);
        }else if(wanted.equals("capacity")){
            System.out.println(capacity);
        }else if(wanted.equals("average")){
            double average=0.0;
            for (Double mark : marks) {
                average+=mark;
            }
            average=average/marks.size();
            if(Math.round(average*10)%10==0){
                System.out.println( Math.round(average*10)/10);
            }else {
                System.out.println((double) Math.round(average*10)/10);
            }
        }
    }
    public static void show_ranks(int courseID){
        ArrayList<Double> B;
        int [] top = new int[3];
        Double first, second, third;
        top[0] =-1;
        top[1] = -1;
        top[2] = -1;
        third = first = second = Double.MIN_VALUE;

        for (Course course : courses) {
            if(course.getCourseID()==courseID){
                B=course.getMarks();
                for (int i = 0; i < B.size(); i++) {
                    if (B.get(i) > first) {
                        third = second;
                        top[2]=top[1];
                        second = first;
                        top[1]=top[0];
                        first = B.get(i);
                        top[0]=i;
                    }
                    else if (B.get(i) > second) {
                        third = second;
                        top[2]=top[1];
                        second = B.get(i);
                        top[1]=i;
                    } else if (B.get(i) > third){
                        third = B.get(i) ;
                        top[2]=i;
                    }
                }
                for (int i = 0; i < top.length-1; i++) {
                    if(top[i]>=0){
                        top[i]=course.getStudentIDs().get(top[i]);
                        System.out.print(top[i]+" ");
                    }
                }
                if(top[2]>=0){
                    top[2]=course.getStudentIDs().get(top[2]);
                    System.out.println(top[2]);
                }
                break;
            }

        }
    }
}

class Student {
    private static ArrayList<Student> students = new ArrayList<>();
    private ArrayList <Course> StudentCourses = new ArrayList<>();
    private int studentID;
    private double average;
    private int DeletedUnit;


    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public ArrayList<Course> getStudentCourses() {
        return StudentCourses;
    }


    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static void addNewStudent(Student student){
        students.add(student);
    }

    public static void registerCourse(int courseID,int studentID){
        boolean existence=false;
        for (Course course : Course.getCourses()) {
            if(course.getCourseID()==courseID){
                if(course.getNumberOfRegisteredStudents()<course.getCapacity()) {

                    for (Student student : students) {

                        if (student.getStudentID() == studentID) {
                            for (Integer id : course.getStudentIDs()) {
                                if(id==studentID){
                                    existence=true;break;
                                }
                            }
                            if(!existence){
                                student.addCourse(course);
                                course.getStudentIDs().add(studentID);
                                course.getMarks().add(-1.0);
                                course.setNumberOfRegisteredStudents(course.getNumberOfRegisteredStudents() + 1);
                                break;
                            }

                        }
                    }

                }

            }
        }
    }

    public void addCourse (Course course){
        StudentCourses.add(course);
    }

    public int getDeletedUnit() {
        return DeletedUnit;
    }

    public void setDeletedUnit(int deletedUnit) {
        DeletedUnit = deletedUnit;
    }

    public static void deleteCourse(int courseID, int studentID){

        for (Student student : Student.students) {
            if(student.getStudentID()==studentID){
                if(student.getDeletedUnit()<=3){
                    Iterator<Course> itr =student.getStudentCourses().iterator();
                    while (itr.hasNext()){
                        Course a= itr.next();
                        if(a.getCourseID()==courseID){
                            if(a.getUnit()+student.getDeletedUnit()<=3 ) {
                                student.setDeletedUnit(student.getDeletedUnit()+a.getUnit());
                                itr.remove();
                            }else {
                                student.setDeletedUnit(student.getDeletedUnit()+a.getUnit());
                            }
                        }
                    }
                }
            }
        }
        for (Course course : Course.getCourses()) {
            if(course.getCourseID()==courseID){
                int index=-1;
                for (int i = 0; i < course.getStudentIDs().size(); i++) {
                    if(course.getStudentIDs().get(i)==studentID){
                        index=i;break;
                    }
                }
                for (Student student : Student.students) {
                    if(student.getStudentID()==studentID){
                        student.setAverage(student.getAverage()-course.getMarks().get(index)*course.getUnit());
                        break;
                    }
                }
                course.getStudentIDs().remove(index);
                course.getMarks().remove(index);
                break;
            }
        }
    }


    public static void showAverage(int studentID){
        boolean cout =false;
        double unitsCourses=0;
        for (Student student : students) {
            if(student.getStudentID()==studentID){
                double score = student.getAverage();
                for (Course course : student.getStudentCourses()) {
                    for (int i = 0; i < course.getStudentIDs().size(); i++) {
                        if(course.getStudentIDs().get(i)==studentID){
                            if(course.getMarks().get(i)>=0){
                                unitsCourses+=course.getUnit();
                            }
                        }
                    }
                }
                score=score/unitsCourses;
                if( Math.round(score*10)%10==0){
                    System.out.println( Math.round(score*10)/10);
                }else {
                    System.out.println((double) Math.round(score*10)/10);
                }
                cout=true;
            }
        }
        if(!cout){
            System.out.println("shoma daneshjoo nistid");
        }
    }

    public static void showRanks_all(){
        ArrayList<Double> B=new ArrayList<>();
        double unitsWanted=0;
        for (Student student : students) {
            unitsWanted=0;
            for (Course course : student.getStudentCourses()) {
                for (int i = 0; i < course.getStudentIDs().size(); i++) {
                    if(course.getStudentIDs().get(i)==student.getStudentID()){
                        if(course.getMarks().get(i)>=0){
                            unitsWanted+=course.getUnit();
                        }
                    }
                }
            }
            B.add(student.getAverage()/unitsWanted);
        }
        int [] top = new int[3];
        Double first, second, third;
        top[0] =-1;
        top[1] = -1;
        top[2] = -1;
        third = first = second = Double.MIN_VALUE;
        for (int i = 0; i < B.size(); i++) {
            if (B.get(i) > first) {
                third = second;
                top[2]=top[1];
                second = first;
                top[1]=top[0];
                first = B.get(i);
                top[0]=i;
            }
            else if (B.get(i) > second) {
                third = second;
                top[2]=top[1];
                second = B.get(i);
                top[1]=i;
            } else if (B.get(i) > third){
                third = B.get(i) ;
                top[2]=i;
            }
        }
        for (int i = 0; i < top.length-1; i++) {
            if(top[i]>=0){
                top[i]=students.get(top[i]).getStudentID();
                System.out.print(top[i]+" ");
            }
        }
        if(top[2]>=0){
            top[2]=students.get(top[2]).getStudentID();
            System.out.println(top[2]);
        }
    }
}

public class main {

    public static void  main(String[] args) {
        InputProcessor inputProcessor = new InputProcessor();
        inputProcessor.start();
    }
}
