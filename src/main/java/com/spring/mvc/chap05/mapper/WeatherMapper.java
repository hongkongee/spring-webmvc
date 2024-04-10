package com.spring.mvc.chap05.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface WeatherMapper {

    // class를 만들기 아까울 때는 Map (겨우 좌표 줄려고 테이블 조회하는데...)
    Map<String, Integer> getCoord(@Param("area1") String area1, @Param("area2") String area2);


}
