package online.cx.javabasic.reflect;

/**
 * @author 曹鑫 1428604355@qq.com
 * @date 2019/9/19 9:47
 */
public class Robot {

    private String name;

    public void sayHi(String helloSentence){
        System.out.println(helloSentence + " " +name);
    }

    private String throwHello(String tag){
        return "hello" + tag;
    }

}
