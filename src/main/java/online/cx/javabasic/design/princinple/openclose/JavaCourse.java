package online.cx.javabasic.design.princinple.openclose;

/**
 * Created on 2020/11/14.
 *
 * @author 曹鑫
 */
public class JavaCourse implements Course {

    private Integer id;
    private String name;
    private Double price;


    public JavaCourse(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
