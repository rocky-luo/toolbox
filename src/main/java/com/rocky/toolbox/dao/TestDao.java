package com.rocky.toolbox.dao;

import com.rocky.toolbox.model.TestPo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rocky on 17/2/27.
 */
@Repository
public interface TestDao {
    /**
     * 新增
     */
    void insert(TestPo po);

    /**
     * 批量新增
     */
    void batchInsert(List<TestPo> pos);

    /**
     * 批量删除
     */
    void batchDeleteByIds(List<Integer> ids);

    /**
     * 更新
     */
    void updateById (TestPo po);

    /**
     * 批量更新
     */
    void batchUpdateByIds(List<TestPo> pos);

    /**
     * 根据主键查询
     */
    TestPo getById(Integer id);

    /**
     * 根据主键批量查询
     */
    List<TestPo> getByIds(List<Integer> ids);
}
