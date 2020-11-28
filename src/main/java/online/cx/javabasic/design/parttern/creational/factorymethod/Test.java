package online.cx.javabasic.design.parttern.creational.factorymethod;

/**
 * Created on 2020/11/14.
 *
 * @author 曹鑫
 */
public class Test {
    public static void main(String[] args) {
        VideoFactory videoFactory = new JavaVideoFactory();
        Video video = videoFactory.getVideo();
        videoFactory = new PythonVideoFactory();
        video.produce();
        video = videoFactory.getVideo();
        video.produce();
    }

}
