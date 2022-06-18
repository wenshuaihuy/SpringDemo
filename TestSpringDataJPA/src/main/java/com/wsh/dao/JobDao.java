package com.wsh.dao;

import com.wsh.pojo.Job;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author huwenshuai
 * @date 2022/6/10 15:22
 */
public interface JobDao extends JpaRepository<Job,Integer> {

}
