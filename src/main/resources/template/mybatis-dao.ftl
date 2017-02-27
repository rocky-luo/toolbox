@Repository
public interface ${table.camelTableName}Dao {
    /**
    * 新增
    */
    void insert(${table.camelTableName}Po po);

    /**
    * 批量新增
    */
    void batchInsert(List${'<'}${table.camelTableName}Po${'>'} pos);

    /**
    * 批量删除
    */
    void batchDeleteByIds(List${'<'}${table.primaryField.type}${'>'} ${table.primaryField.camelField}s);

    /**
    * 更新
    */
    void updateById (${table.camelTableName}Po po);

    /**
    * 批量更新
    */
    void batchUpdateByIds(List${'<'}${table.camelTableName}Po${'>'} pos);

    /**
    * 根据主键查询
    */
    ${table.camelTableName}Po getById(${table.primaryField.type} ${table.primaryField.camelField});

    /**
    * 根据主键批量查询
    */
    List${'<'}${table.camelTableName}Po${'>'} getByIds(List${'<'}${table.primaryField.type}${'>'} ${table.primaryField.camelField}s);
}