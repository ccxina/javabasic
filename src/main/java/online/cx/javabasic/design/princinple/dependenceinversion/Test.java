package online.cx.javabasic.design.princinple.dependenceinversion;

/**
 * Created on 2020/11/14.
 *
 * @author 曹鑫
 */
public class Test {

    // v1
//    public static void main(String[] args) {
//        Caoxin caoxin = new Caoxin();
//        caoxin.studyJava();
//    }


    public static void main(String[] args) {

        Caoxin caoxin = new Caoxin();
        caoxin.studyCourse(new JavaCourse());
        caoxin = new Caoxin(new JavaCourse());
        caoxin.studyCourse();
        caoxin.setCourse(new PythonCourse());
        caoxin.studyCourse();
    }
}
