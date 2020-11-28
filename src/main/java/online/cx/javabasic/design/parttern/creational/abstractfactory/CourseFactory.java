package online.cx.javabasic.design.parttern.creational.abstractfactory;

/**
 * Created on 2020/11/15.
 *
 * @author 曹鑫
 */
public interface CourseFactory {

    Video getVideo();
    Article getArticle();
}
