package com.wsh.test;

import com.wsh.dao.JobDao;
import com.wsh.dao.UserDao;
import com.wsh.pojo.Job;
import com.wsh.pojo.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.record.DVALRecord;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huwenshuai
 * @date 2022/6/9 9:56
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Test {
    @Autowired
    private  UserDao userDao;
    @Autowired
    private  JobDao jobDao;


    @org.junit.Test
    public void findAll() {
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @org.junit.Test
    public void saveOne() {
        User user1 = new User(123,"李四","wsh@163.com","beijing");
        User user2 = new User(123,"王五","wsh@163.com","beijing");
        User user3 = new User(123,"赵六","wsh@163.com","beijing");
        Job job = new Job(123, "软件部", "主要负责软件研发");
        Job job1 = new Job(456, "硬件部", "主要负责硬件研发");
        List<Job> jobs = new ArrayList<>();
        jobs.add(job);
        jobs.add(job1);
        userDao.save(user1);
        userDao.save(user3);
        userDao.save(user2);

        jobDao.saveAll(jobs);
    }

}
