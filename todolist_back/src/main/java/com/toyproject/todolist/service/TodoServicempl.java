package com.toyproject.todolist.service;

import com.toyproject.todolist.dto.ReqTodosDto;
import com.toyproject.todolist.dto.RespTodosDto;
import com.toyproject.todolist.entity.Todos;
import com.toyproject.todolist.repository.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServicempl implements TodoService{

    @Autowired
    TodoMapper todoMapper;

    @Override
    public int save (ReqTodosDto DTO){
        Todos todos = Todos.builder()
                .content(DTO.getContent())
                .date(DTO.getDate())
                .build();

        return todoMapper.save(todos);
    }

    @Override
    public List<RespTodosDto> allListByDate(String date) {
        List <Todos> todos = todoMapper.todolist(date);

        List<RespTodosDto> respDto = new ArrayList<>();

        for(Todos toDto : todos) {
            RespTodosDto todoDto = RespTodosDto.builder()
                    .todoId(toDto.getTodoId())
                    .content(toDto.getContent())
                    .status(toDto.getStatus())
                    .date(toDto.getDate())
                    .build();

            respDto.add(todoDto);
        }


        return  respDto;

    }

    @Override
    public List<Todos> allList() {
        List<Todos> todos = todoMapper.alltodoList();

        List<RespTodosDto> allList = new ArrayList<>();

        for(Todos toDto : todos){
            RespTodosDto todoDto = RespTodosDto.builder()
                    .todoId(toDto.getTodoId())
                    .content(toDto.getContent())
                    .status(toDto.getStatus())
                    .date(toDto.getDate())
                    .build();
            allList.add(todoDto);
        }

        return allList ;
    }
    //    @Override
//    public List<RespTodosDto> allList (String date){
//        // 엔티티 리스트를 dto(list)로 전환 > 클라이언트(프론트)
////        List<Todos> todos = todoMapper.todolist(todoDate);
////        // Mapper 자료형을 엔터티 리스트타입으로 리턴했기 때문에
////
////        // 엔터티를 dto담아줄 새로운 리스트 생성
////        List<RespTodosDto> respDto = new ArrayList<>();
//
//        // todos배열의 길이만큼 반복 (toDto는 1개의 객체)
////        for(Todos toDto : todos){
////            RespTodosDto toSibal = RespTodosDto.builder()
////                    .todoId(toDto.getTodoId())
////                    .content(toDto.getContent())
////                    .date(toDto.getDate())
////                    .status(toDto.getStatus())
////                    .build();
////
////            // 반복돌면서 값이 담김
////            respDto.add(toSibal);
////        }
////
////        return respDto;
//
//        List<Todos> todosList = todoMapper.todolist(date);
//
//        return todosList.stream()
//                .map(todo -> RespTodosDto.builder()
//                        .todoId(todo.getTodoId())
//                        .content(todo.getContent())
//                        .date(todo.getDate())
//                        .status(todo.getStatus())
//                        .build())
//                .collect(Collectors.toList());
//    }
}
