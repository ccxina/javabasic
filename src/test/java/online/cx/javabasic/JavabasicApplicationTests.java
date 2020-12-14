package online.cx.javabasic;

import online.cx.javabasic.dao.DemoDao;
import online.cx.javabasic.dao.DemoRepository;
import online.cx.javabasic.entity.Demo;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootTest
class JavabasicApplicationTests {


    @Autowired
    DemoDao demoDao;

    @Autowired
    DemoRepository demoRepository;

    @Test
    void contextLoads() {

//        List<Demo> demoList = new ArrayList<>(1000);
////        for (long i = 0; i < 1000; i++) {
////            Demo demo = new Demo();
////            demo.setId(i);
////            demo.setTitle(RandomStringUtils.random(5, "qwsdcdsirwejkmslknsjllmskln"));
////            demoList.add(demo);
////        }
////        System.out.println(demoList);
////        demoDao.saveAll(demoList);
////        demoDao.update(demo);
//        demoDao.find();
////        demoDao.remove(new Demo(999L, ""));
//        demoDao.find();
//        System.out.println(demoDao.count());


        List<Demo> demoList = demoRepository.findAll();
//        demoList.forEach(System.out::println);
//        Date date = demoList.get(0).getDate();
//        System.out.println(date.getTime());
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time = simpleDateFormat.format(date);
//        System.out.println(time);
//        System.out.println(demoRepository.findFirstByDate(date));
//        System.out.println(demoRepository.count());
//        System.out.println(demoRepository.findDistinctByIdBetween(2L, 7L));
        String[] typeList = {"电脑", "键盘", "鼠标"};
        demoList.forEach(demo -> {
            int i = RandomUtils.nextInt(0, 3);
            demo.setType(typeList[i]);
//            demo.setNum(demo.getNum() + RandomUtils.nextInt(1, 4));
        });

        demoRepository.saveAll(demoList);
//
//        demoList.forEach(System.out::println);
        System.out.println(demoDao.count());
//        System.out.println(demoRepository.countByNum1());
        Sort sort = Sort.by(Sort.Order.asc("_id"));

        Pageable pageable = PageRequest.of(2, 10, sort);

        Page<Demo> pages = demoRepository.findAll(pageable);
        pages.getTotalElements();
        demoList = pages.toList();
        System.out.println(demoList);
        demoList = pages.getContent();
        System.out.println(demoList.get(1));
    }


    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void TestMap() {
//        Criteria criteria = Criteria.where("");


    }

}
