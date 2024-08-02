import React, { useEffect, useState } from 'react';
import axios from 'axios';
/** @jsxImportSource @emotion/react */


function TodolistTest() {
    
    const [todo , setTodo] = useState({
        content:"",
        date:""
    })

    const [date, setDate] = useState("");

    const [todos, setTodos] = useState([]);

    const handleInputChange = (e) => {
        setTodo({
            ...todo,
            [e.target.name]: e.target.value
        });
    }
    
    const fetchTodos = async () => {
        try {
            const response = await axios.get("http://localhost:8080/api/v1/todos");
            setTodos(response.data); // 상태에 할 일 목록 저장
        } catch (error) {
            console.error("Error fetching todos:", error);
        }
    };

    const handleAddClick = async() => {
        
        try {
            const response = await axios.post("http://localhost:8080/api/v1/todo", todo);
            console.log(response.data);
            console.log(todo);
            fetchTodos();
            setTodos([...todos, response.data]);
            setTodo({content:"" , date:""});
        } catch (error) {
            console.error(error);
        }
    };

    const handleDateSet = (e) => {
        const selectedDate = e.target.value;
        if (selectedDate) { // 유효한 날짜가 선택된 경우에만
            setDate(selectedDate);
            setTodo({
                ...todo,
                date: selectedDate
            });
        }
    };

    // 날짜 변경시 호출
    useEffect(() => {
        if (date) {
            handleGetTodoListByDate(date);
        }
    }, [date]);

    const handleGetTodoListByDate = async(date)=> {
        try {
            const response = await axios.get(`http://localhost:8080/api/v1/todo/${date}`);
            console.log(date);
            console.log(response.data);
        } catch (error) {
            console.error(error);
        }
    }

        
    return (
        <div>
            <div>
                <input value={date} 
                    type="month" 
                    name="todoDate" 
                    onChange={handleDateSet}/>
                <input onChange={handleInputChange} 
                        name='content' 
                        value={todo.content}/>
                <button onClick={handleAddClick}>제출</button>        
            </div>
            <div>
            <h2>할 일 목록</h2>
                <ul>
                    {todos.length > 0 ? (
                        todos.map((item, index) => (
                            <li key={index}>
                                <strong>날짜:</strong> {item.date} <br />
                                <strong>내용:</strong> {item.content}
                            </li>
                        ))
                    ) : (
                        <li>등록된 할 일이 없습니다.</li>
                    )}
                </ul>
            </div>
        </div>
    );
}

export default TodolistTest;