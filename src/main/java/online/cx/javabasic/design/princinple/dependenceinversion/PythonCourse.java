package online.cx.javabasic.design.princinple.dependenceinversion;

/**
 * Created on 2020/11/14.
 *
 * @author 曹鑫
 */
public class PythonCourse implements Course {
    @Override
    public void study() {
        System.out.println("学习 python !");
    }
}
