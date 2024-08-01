package com.toyproject.todolist.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
// Requset DB에 내용보낼때
// Delete 삭제시에는 id값만 받아서 int id만 전달해줌
public class ReqTodosDto {
    private String content;
    private String date;
}
