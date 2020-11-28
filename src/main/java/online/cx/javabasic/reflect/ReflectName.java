package online.cx.javabasic.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 曹鑫 1428604355@qq.com
 * @date 2019/9/19 9:49
 */
public class ReflectName {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class rc = Class.forName("online.cx.javabasic.reflect.Robot");
        //创建实例
        Robot r = (Robot) rc.newInstance();
        System.out.println("Class name is: "+rc.getName());
        // 获取声明的方法  throwHello 接受一个 String 类型的参数
        // 不能获取继承、实现 的方法
        Method getHello = rc.getDeclaredMethod("throwHello", String.class);
        getHello.setAccessible(true);
        Object str = getHello.invoke(r, "Bob");
        System.out.println("getHello result is" + str);
        // getMethod 只能获取public 和继承与实现的方法
        Method sayHi = rc.getMethod("sayHi", String.class);
        sayHi.invoke(r, "Welcome");
        Field name = rc.getDeclaredField("name");
        name.setAccessible(true);
        name.set(r, "Alice");
        sayHi.invoke(r, "Welcome");
    }
}
