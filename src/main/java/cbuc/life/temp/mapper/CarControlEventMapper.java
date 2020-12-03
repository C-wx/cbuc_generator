package cbuc.life.temp.mapper;

import cbuc.life.temp.bean.CarControlEvent;

public interface CarControlEventMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarControlEvent record);

    int insertSelective(CarControlEvent record);

    CarControlEvent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarControlEvent record);

    int updateByPrimaryKey(CarControlEvent record);
}