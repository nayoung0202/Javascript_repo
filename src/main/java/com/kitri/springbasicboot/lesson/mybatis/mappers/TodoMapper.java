package com.kitri.springbasicboot.lesson.mybatis.mappers;

import com.kitri.springbasicboot.lesson.mybatis.dto.RequestTodo;
import com.kitri.springbasicboot.lesson.mybatis.dto.ResponseTodo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {

    List<ResponseTodo> findAll(); //XML에서 받아온 DB 데이터를 자바 객체에 매핑
    ResponseTodo findById(Long id);
    void save(RequestTodo todo);
    void update(RequestTodo todo);
    void deleteById(Long id);
}
