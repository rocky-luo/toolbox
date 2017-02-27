package com.rocky.toolbox.dao;

import com.google.common.collect.Lists;
import com.rocky.toolbox.model.TestPo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by rocky on 17/2/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:applicationContext-mysql.xml"})
public class TestDaoTest {
    @Resource
    private TestDao testDao;
    @Test
    public void insert() throws Exception {
        testDao.insert(getOne());
        Assert.assertTrue(true);
    }

    @Test
    public void batchInsert() throws Exception {
        testDao.batchInsert(Lists.newArrayList(getOne(), getOne()));
        Assert.assertTrue(true);
    }

    @Test
    public void batchDeleteByIds() throws Exception {
        testDao.batchDeleteByIds(Lists.newArrayList(1,2));
        Assert.assertTrue(true);
    }

    @Test
    public void updateById() throws Exception {
        TestPo testPo = new TestPo();
        testPo.setId(4);
        testPo.setDoubleNum(123.456);
        testDao.updateById(testPo);
        Assert.assertTrue(true);
    }

    @Test
    public void batchUpdateByIds() throws Exception {
        TestPo po = getOne();
        po.setId(3);
        po.setPic("123fff".getBytes());
        TestPo po1 = getOne();
        po1.setId(4);
        po1.setCake("ab");
        testDao.batchUpdateByIds(Lists.newArrayList(po, po1));
        Assert.assertTrue(true);
    }

    @Test
    public void getById() throws Exception {
        TestPo po = testDao.getById(3);
        Assert.assertTrue(po != null);
    }

    @Test
    public void getByIds() throws Exception {
        List<TestPo> pos = testDao.getByIds(Lists.newArrayList(3,4));
        Assert.assertTrue(pos.size() == 2);
    }

    private static TestPo getOne() {
        TestPo testPo = new TestPo();
        testPo.setActivityId(123L);
        testPo.setPosition(2);
        testPo.setTitle("dddf");
        testPo.setCake("哈罗");
        testPo.setOk(false);
        testPo.setFuDian(12.4f);
        testPo.setDoubleNum(2345.664);
        testPo.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        testPo.setLetDate(new Date());
        testPo.setPic("dasdf".getBytes());
        return testPo;
    }

}