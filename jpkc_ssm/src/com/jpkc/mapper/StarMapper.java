package com.jpkc.mapper;

import com.jpkc.pojo.Star;
import com.jpkc.pojo.StarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StarMapper {
    int countByExample(StarExample example);

    int deleteByExample(StarExample example);

    int deleteByPrimaryKey(String starId);

    int insert(Star record);

    int insertSelective(Star record);

    List<Star> selectByExample(StarExample example);

    Star selectByPrimaryKey(String starId);

    int updateByExampleSelective(@Param("record") Star record, @Param("example") StarExample example);

    int updateByExample(@Param("record") Star record, @Param("example") StarExample example);

    int updateByPrimaryKeySelective(Star record);

    int updateByPrimaryKey(Star record);
}