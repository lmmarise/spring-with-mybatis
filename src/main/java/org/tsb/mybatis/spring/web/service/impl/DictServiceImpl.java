package org.tsb.mybatis.spring.web.service.impl;

import com.sun.istack.internal.NotNull;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsb.mybatis.spring.model.SysDict;
import org.tsb.mybatis.spring.web.mapper.DictMapper;
import org.tsb.mybatis.spring.web.service.DictService;

import java.util.List;

/**
 * <p>@program: spring-with-mybatis </p>
 * <p>@description:  </p>
 * <p>@author: Arise Tang </p>
 * <p>@create: 2020-04-20 11:50 </p>
 **/
@Service
public class DictServiceImpl implements DictService {
    @Autowired
    private DictMapper dictMapper;

    public SysDict findById(@NotNull Long id) {
        return dictMapper.selectByPrimaryKey(id);
    }

    public List<SysDict> findBySysDictLimit(SysDict sysDict, Integer offset, Integer limit) {
        RowBounds rowBounds = RowBounds.DEFAULT;
        if (offset != null && limit != null) {
            rowBounds = new RowBounds(offset, limit);
        }
        return dictMapper.selectBySysDict(sysDict, rowBounds.getOffset(), rowBounds.getLimit());
    }

    public boolean saveOrUpdate(SysDict sysDict) {
        if (sysDict.getId() == null) {
            return dictMapper.insert(sysDict) == 1;
        } else {
            return dictMapper.updateById(sysDict) == 1;
        }
    }

    public boolean deleteById(Long id) {
        return dictMapper.deleteById(id) == 1;
    }
}
