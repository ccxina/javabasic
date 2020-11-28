package online.cx.javabasic.design.parttern.creational.simplefactory;

/**
 * Created on 2020/11/14.
 *
 * @author 曹鑫
 */
public class Test {
    public static void main(String[] args) {
        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.getVideo("java");
        video.produce();
        video = videoFactory.getVideo(PythonVideo.class);
        video.produce();
    }

}
