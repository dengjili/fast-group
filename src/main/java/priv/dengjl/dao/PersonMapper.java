package priv.dengjl.dao;

import priv.dengjl.entity.Person;

public interface PersonMapper {
    int insert(Person record);

    int insertSelective(Person record);
}