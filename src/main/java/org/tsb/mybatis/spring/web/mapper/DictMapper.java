package org.tsb.mybatis.spring.web.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.tsb.mybatis.spring.model.SysDict;

import java.util.List;

/**
 * (SysDict)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-20 10:48:08
 */
public interface DictMapper {

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysDict> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 根据实体进行分页查询
     */
    List<SysDict> queryBySysDictLimit(@Param("sysDict") SysDict sysDict, @Param("offset") int offset, @Param("limit") int limit);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysDict 实例对象
     * @return 对象列表
     */
    List<SysDict> queryAll(@Param("sysDict") SysDict sysDict);

    /**
     * 新增数据
     *
     * @param sysDict 实例对象
     * @return 影响行数
     */
    int insert(SysDict sysDict);

    /**
     * 修改数据
     *
     * @param sysDict 实例对象
     * @return 影响行数
     */
    int update(SysDict sysDict);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 通过id或code进行查询
     *
     * @param sysDict 对象
     * @return 符合条件的对象集合
     */
    List<SysDict> queryBySysDict(@Param("sysDict") SysDict sysDict);

    /**
     * 通过实体进行修改
     */
    int updateById(SysDict sysDict);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return SysDict实体
     */
    SysDict selectByPrimaryKey(Long id);

    /**
     * 根据实体进行分页查询
     */
    List<SysDict> selectBySysDict(SysDict sysDict, Integer offset, Integer limit);
}