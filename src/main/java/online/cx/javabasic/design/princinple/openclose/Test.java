package online.cx.javabasic.design.princinple.openclose;

/**
 * Created on 2020/11/14.
 *
 * @author 曹鑫
 */
public class Test {
    public static void main(String[] args) {
        Course course = new JavaDiscountCourse(12, "不要钱 免费送", 12d);
        JavaDiscountCourse javaDiscountCourse = (JavaDiscountCourse) course;
        System.out.println("id:" + javaDiscountCourse.getId() + "name:" + javaDiscountCourse.getName() + "price:" + javaDiscountCourse.getPrice());
        System.out.println("原价" + javaDiscountCourse.getOriginPrice());
    }
}
