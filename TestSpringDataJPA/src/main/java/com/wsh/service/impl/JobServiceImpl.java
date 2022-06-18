package com.wsh.service.impl;

import com.wsh.dao.JobDao;
import com.wsh.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huwenshuai
 * @date 2022/6/10 15:24
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class JobServiceImpl implements JobService {

    private final JobDao jobDao;
}
