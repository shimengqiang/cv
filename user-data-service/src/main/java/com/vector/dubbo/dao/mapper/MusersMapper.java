package com.vector.dubbo.dao.mapper;

import com.vector.dubbo.dao.model.Musers;
import java.util.List;

public interface MusersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Musers record);

    Musers selectByPrimaryKey(Long id);

    List<Musers> selectAll();

    int updateByPrimaryKey(Musers record);
}