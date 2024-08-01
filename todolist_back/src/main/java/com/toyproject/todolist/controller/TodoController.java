package com.toyproject.todolist.controller;


import com.toyproject.todolist.dto.ReqTodosDto;
import com.toyproject.todolist.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/api/v1")
public class TodoController {

    // 컨트롤러 > 서비스 > dto(req, resp) > Mapper > xml
    // 다시 역순
    @Autowired
    TodoService todoService;

    @PostMapping("/todo")
    public ResponseEntity <?> todoInsert(@RequestBody ReqTodosDto dto){
        log.info("{}", dto);
        return ResponseEntity.ok().body(todoService.save(dto)) ;
    }

    @GetMapping("/todo/{date}")
    public ResponseEntity<?> getTodolist(@PathVariable String date){
        log.info("{}", date);
        return ResponseEntity.ok().body(todoService.allList(date));
    }


}
