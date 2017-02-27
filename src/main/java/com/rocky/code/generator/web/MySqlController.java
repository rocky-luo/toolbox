package com.rocky.code.generator.web;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.rocky.code.generator.db.Structure;
import com.rocky.code.generator.model.converts.FieldConvert;
import com.rocky.code.generator.model.converts.TableConvert;
import com.rocky.code.generator.template.Generator;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by rocky on 17/2/23.
 */
@RequestMapping("/mysql")
@Controller
public class MySqlController {
    @Value("#{dbProperties['db.mysql.driver']}")
    private String mysqlDriver;
    @Value("#{dbProperties['db.mysql.url']}")
    private String mysqlUrl;
    @Value("#{dbProperties['db.mysql.user']}")
    private String mysqlUser;
    @Value("#{dbProperties['db.mysql.password']}")
    private String mysqlPassword;

    private Connection con = null;

    @PostConstruct
    private void init() throws ClassNotFoundException {
        Class.forName(mysqlDriver);
    }

    @RequestMapping("/mybatis")
    public String mybatis() {
        return "mybatis";
    }

    @RequestMapping("/databases")
    @ResponseBody
    public DataResult dataBases() throws SQLException {
        Connection con = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPassword);
        ResultSet rs = con.getMetaData().getCatalogs();
        List<String> databaseNames = Lists.newArrayList();
        while (rs.next()) {
            databaseNames.add(rs.getString("TABLE_CAT"));
        }
        con.close();
        return new SuccessResult(databaseNames);
    }

    @RequestMapping("/tables")
    @ResponseBody
    public DataResult tables(String database) throws SQLException {
        Connection con = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPassword);
        ResultSet rs = con.getMetaData().getTables(database, null, "%", null);
        List<String> tableNames = Lists.newArrayList();
        while (rs.next()) {
            tableNames.add(rs.getString("TABLE_NAME"));
        }
        con.close();
        return new SuccessResult(tableNames);
    }

    @RequestMapping("/javabean")
    @ResponseBody
    public DataResult javaBean(String database, String table) throws SQLException, IOException, TemplateException {
        Connection con = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPassword);
        String sql = "show full columns from " + database + "." + table;
        ResultSet rs = con.createStatement().executeQuery(sql);
        Structure structure = new Structure(rs, table);
        Map<String, Object> vos = Maps.newHashMapWithExpectedSize(structure.fieldSize() + 5);
        vos.put("table", TableConvert.structure2Vo(structure));
        String strJavaBean = Generator.classpathTemplateGen("template/mybatis-javabean.ftl", vos);
        con.close();
        return new SuccessResult(strJavaBean);
    }

    @RequestMapping("/mapper")
    @ResponseBody
    public DataResult mapper(String database, String table) throws SQLException {
        Connection con = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPassword);
        String sql = "show full columns from " + database + "." + table;
        ResultSet rs = con.createStatement().executeQuery(sql);
        Structure structure = new Structure(rs, table);
        Map<String, Object> vos = Maps.newHashMapWithExpectedSize(structure.fieldSize() + 5);
        vos.put("table", TableConvert.structure2Vo(structure));
        String strJavaBean = Generator.classpathTemplateGen("template/mybatis-mapper.ftl", vos);
        con.close();
        return new SuccessResult(strJavaBean);
    }

    @RequestMapping("/dao")
    @ResponseBody
    public DataResult dao(String database, String table) throws SQLException {
        Connection con = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPassword);
        String sql = "show full columns from " + database + "." + table;
        ResultSet rs = con.createStatement().executeQuery(sql);
        Structure structure = new Structure(rs, table);
        Map<String, Object> vos = Maps.newHashMapWithExpectedSize(structure.fieldSize() + 5);
        vos.put("table", TableConvert.structure2Vo(structure));
        String strJavaBean = Generator.classpathTemplateGen("template/mybatis-dao.ftl", vos);
        con.close();
        return new SuccessResult(strJavaBean);
    }

}
