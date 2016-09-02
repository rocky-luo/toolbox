package com.rocky.service;

import com.rocky.model.po.PersonPO;

/**
 * Created by rocky on 16/9/2.
 */
public interface IHelloWorldService {
    PersonPO getById(Long id);
}
