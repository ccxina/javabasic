package online.cx.javabasic.design.princinple.dependenceinversion;

/**
 * Created on 2020/11/14.
 *
 * @author 曹鑫
 */
public class Caoxin {

    public void studyJava() {
        System.out.println("学习 Java");
    }

    public void studyWeb() {
        System.out.println("学习 Web");
    }

    public void studyPython() {
        System.out.println("学习 Python");
    }

    public void studyCourse(Course course) {
        course.study();
    }

    private Course course;

    public Caoxin() {
    }

    public Caoxin(Course course) {
        this.course = course;
    }

    public void studyCourse() {
        this.course.study();
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
