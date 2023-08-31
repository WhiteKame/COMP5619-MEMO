package com.project.memo.mapper;

import com.project.memo.entity.ToDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ToDoMapper {
    List<ToDo> findTodosByEventId(@Param("eventId") Integer eventId);

    ToDo findById(@Param("id")Long id);

    void save(ToDo toDo);

    void update(ToDo toDo);

    void delete(Long id);

}
