package online.cx.javabasic.design.parttern.creational.builder;

/**
 * Created on 2020/11/16.
 *
 * @author 曹鑫
 */
public abstract class CourseBuilder {

    public abstract void buildName(String name);
    public abstract void buildPPT(String ppt);
    public abstract void buildVideo(String video);
    public abstract void buildArticle(String article);
    public abstract void buildQA(String QA);

    public abstract Course makeCourse();
}
