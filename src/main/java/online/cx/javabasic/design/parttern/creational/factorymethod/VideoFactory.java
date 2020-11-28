package online.cx.javabasic.design.parttern.creational.factorymethod;

/**
 * Created on 2020/11/14.
 *
 * @author 曹鑫
 */
public abstract class VideoFactory {

//    public Video getVideo(String type) {
//        if ("java".equalsIgnoreCase(type)) {
//            return new JavaVideo();
//        }
//        if ("python".equalsIgnoreCase(type)) {
//            return new PythonVideo();
//        }
//        return null;
//    }
//
//    public Video getVideo(Class c) {
//        Video video = null;
//        try {
//            video = (Video) Class.forName(c.getName()).newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return video;
//    }

    public abstract Video getVideo();

}
