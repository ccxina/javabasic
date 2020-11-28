package online.cx.javabasic.design.princinple.openclose;

/**
 * Created on 2020/11/14.
 *
 * @author 曹鑫
 */
public class JavaDiscountCourse extends JavaCourse{
    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    @Override
    public Double getPrice() {
        return super.getPrice() * 0.8;
    }

    public Double getOriginPrice() {
        return super.getPrice();
    }
}
