package com.ashishnitw.springbootservicetemplate.service;

import com.ashishnitw.springbootservicetemplate.model.Test;
import com.ashishnitw.springbootservicetemplate.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TestService {

    private final TestRepository testRepository;

    public Test save(String data) {
        log.info("Saving data: {}", data);
        return testRepository.save(Test.builder().data(data).build());
    }

    public Test get(long id) {
        Test res = testRepository.findById(id).orElse(null);
        log.info("Getting data: {}", res);
        return res;
    }

}
