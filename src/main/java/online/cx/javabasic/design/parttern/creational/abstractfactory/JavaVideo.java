package online.cx.javabasic.design.parttern.creational.abstractfactory;

/**
 * Created on 2020/11/15.
 *
 * @author 曹鑫
 */
public class JavaVideo extends Video{
    @Override
    public void produce() {
        System.out.println("录制java视频");
    }
}
