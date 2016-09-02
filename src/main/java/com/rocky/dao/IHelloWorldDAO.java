package com.rocky.dao;

import com.rocky.model.po.PersonPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by rocky on 16/9/2.
 */
@Repository
public interface IHelloWorldDAO {
    PersonPO getById(@Param("id") Long id);
    void insert(@Param("person") PersonPO personPO);
}
