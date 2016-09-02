package com.rocky.service.impl;

import com.rocky.dao.IHelloWorldDAO;
import com.rocky.model.po.PersonPO;
import com.rocky.service.IHelloWorldService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by rocky on 16/9/2.
 */
@Service
public class HelloWorldImpl implements IHelloWorldService {
    @Resource
    private IHelloWorldDAO helloWorldDAO;


    @Override
    public PersonPO getById(Long id) {
        PersonPO po = helloWorldDAO.getById(id);
        return po;
    }

    @Override
    @Transactional
    public void batchInsert(List<PersonPO> personPOList) {
        for (PersonPO po : personPOList) {
            helloWorldDAO.insert(po);
        }
    }

}
