package com.toyproject.todolist.repository;

import com.toyproject.todolist.dto.ReqTodosDto;
import com.toyproject.todolist.dto.RespTodosDto;
import com.toyproject.todolist.entity.Todos;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
// 엔티티 받아서 xml에 받기
public interface TodoMapper {
    int save(Todos todos);
    // Todos todos 파라미터 타입 xml에 파라미터값을 넣어주면댐
    // 컨트롤러의 매개변수를 게속 건네줌
    List<Todos> todolist(String date);
    // xml갓다옴
    List<RespTodosDto> alltodoList();
}
