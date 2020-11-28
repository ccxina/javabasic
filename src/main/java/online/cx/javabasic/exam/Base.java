package online.cx.javabasic.exam;

/**
 * Created on 2020/11/28.
 *
 * @author 曹鑫
 */
public abstract class Base {
    public String deleteString(String s) {
        this.judgeString(s);
        return "";
    }

    abstract public boolean judgeString(String s);
}
