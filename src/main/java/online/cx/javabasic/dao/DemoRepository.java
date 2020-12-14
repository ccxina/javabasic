package online.cx.javabasic.dao;

import online.cx.javabasic.entity.Demo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DemoRepository extends MongoRepository<Demo, Long> {

    Demo findFirstByDate(Date date);

    List<Demo> findDistinctByIdBetween(Long id1, Long id2);

    List<Demo> findDistinctIdByIdEndingWith(Long id);

    Integer countByNum(Integer num);

}
