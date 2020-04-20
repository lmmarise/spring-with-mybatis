package org.tsb.mybatis.spring.web.service;

import org.tsb.mybatis.spring.model.SysDict;

import java.util.List;

/**
 * <p>@program: spring-with-mybatis </p>
 * <p>@description: SysDict的service层 </p>
 * <p>@author: Arise Tang </p>
 * <p>@create: 2020-04-20 11:16 </p>
 **/
public interface DictService {
    SysDict findById(Long id);

    List<SysDict> findBySysDictLimit(SysDict sysDict, Integer offset, Integer limit);

    boolean saveOrUpdate(SysDict sysDict);

    boolean deleteById(Long id);
}
