package com.example.javaassignment2207063;

public class course {

    private String CourseName;
    private String CourseCode;
    private double Credit;
    private String teacher1;
    private String teacher2;
    private String grade;
    public course(String courseName, String courseCode, double credit,
                  String teacher1, String teacher2, String grade) {
        this.CourseName = courseName;
        this.CourseCode = courseCode;
        this.Credit = credit;
        this.teacher1 = teacher1;
        this.teacher2 = teacher2;
        this.grade = grade;
    }

    // Getters and Setters
    public String getCourseName() { return CourseName; }
    public String getCourseCode() { return CourseCode; }
    public double getCredit() { return Credit; }
    public String getTeacher1() { return teacher1; }
    public String getTeacher2() { return teacher2; }
    public String getGrade() { return grade; }

    public void setCourseName(String courseName) { this.CourseName = courseName; }
    public void setCourseCode(String courseCode) { this.CourseCode = courseCode; }
    public void setCredit(double credit) { this.Credit = credit; }
    public void setTeacher1(String teacher1) { this.teacher1 = teacher1; }
    public void setTeacher2(String teacher2) { this.teacher2 = teacher2; }
    public void setGrade(String grade) { this.grade = grade; }
}


