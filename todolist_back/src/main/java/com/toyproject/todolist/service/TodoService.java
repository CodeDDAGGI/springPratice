package com.toyproject.todolist.service;

import com.toyproject.todolist.dto.ReqTodosDto;
import com.toyproject.todolist.dto.RespTodosDto;
import com.toyproject.todolist.entity.Todos;

import java.util.List;

//서비스에서 요청받은 dto 매개변수로 받아야함
public interface TodoService {
    // 저장할때 리턴값은 인트
    int save(ReqTodosDto DTO);
    List<Todos> allListByDate(String date);
    List<Todos> allList();
}
