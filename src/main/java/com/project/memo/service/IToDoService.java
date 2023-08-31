package com.project.memo.service;

import com.project.memo.entity.ToDo;

import java.util.List;

public interface IToDoService {

    List<ToDo> findTodosByEventId(Integer eventId);

    ToDo findById(Long id);

    void save(ToDo toDo);

    void update(ToDo toDo);

    void delete(Long id);
}
