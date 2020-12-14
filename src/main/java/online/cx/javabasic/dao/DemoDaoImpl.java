package online.cx.javabasic.dao;


import online.cx.javabasic.entity.Demo;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


@Component
public class DemoDaoImpl implements DemoDao {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void save(Demo demo) {
        mongoTemplate.save(demo);
    }

    public void saveAll(List<Demo> demoList) {
        mongoTemplate.insertAll(demoList);
    }

    @Override
    public void update(Demo demo) {

        mongoTemplate.upsert(Query.query(Criteria.where("_id").is(demo.getId())), Update.update("title", demo.getTitle()), "demo");
    }

    @Override
    public void find() {
        List<Demo> demoList = mongoTemplate.findAll(Demo.class);
        System.out.println(demoList);
    }

    @Override
    public void remove(Demo demo) {
        mongoTemplate.remove(demo);
//        mongoTemplate.remove(Query.query(Criteria.where("title").regex("util")), Demo.class);
    }


    @Override
    public long count() {

//        Query query = TextQuery.queryText(Criteria.matchingDocumentStructure())

        return mongoTemplate.count(Query.query(Criteria.where("num").is(1)), Demo.class);

//        mongoTemplate.updateMulti(Query.query(Criteria.where("_id").ne(-1)), Update.update("date", new Date()),Demo.class);
//        return mongoTemplate.count(Query.query(Criteria.where("_id").ne(-1)), Demo.class);
    }

}
