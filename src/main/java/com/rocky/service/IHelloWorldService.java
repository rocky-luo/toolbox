package com.rocky.service;

import com.rocky.model.po.PersonPO;

import java.util.List;

/**
 * Created by rocky on 16/9/2.
 */
public interface IHelloWorldService {
    PersonPO getById(Long id);
    void batchInsert(List<PersonPO> personPOList);
}
