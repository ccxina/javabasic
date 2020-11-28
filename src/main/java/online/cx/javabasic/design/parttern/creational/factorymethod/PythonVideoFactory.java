package online.cx.javabasic.design.parttern.creational.factorymethod;

/**
 * Created on 2020/11/14.
 *
 * @author 曹鑫
 */
public class PythonVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }
}
