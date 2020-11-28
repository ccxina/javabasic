package online.cx.javabasic.design.parttern.creational.builder;

import lombok.Builder;
import lombok.Data;

/**
 * Created on 2020/11/16.
 *
 * @author 曹鑫
 */
public class Course {

    private String name;
    private String ppt;
    private String video;
    private String article;

    private String QA;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPpt() {
        return ppt;
    }

    public void setPpt(String ppt) {
        this.ppt = ppt;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getQA() {
        return QA;
    }

    public void setQA(String QA) {
        this.QA = QA;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", ppt='" + ppt + '\'' +
                ", video='" + video + '\'' +
                ", article='" + article + '\'' +
                ", QA='" + QA + '\'' +
                '}';
    }
}
