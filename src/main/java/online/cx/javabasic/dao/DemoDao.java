package online.cx.javabasic.dao;


import online.cx.javabasic.entity.Demo;

import java.util.List;

public interface DemoDao {

    void save(Demo demo);

    void update(Demo demo);

    void find();

    void remove(Demo demo);

    void saveAll(List<Demo> demoList);

    long count();

}
