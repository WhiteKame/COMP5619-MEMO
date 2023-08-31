package com.project.memo.service.impl;

import com.project.memo.entity.ToDo;
import com.project.memo.mapper.ToDoMapper;
import com.project.memo.service.IToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServiceImpl implements IToDoService {
    @Autowired
    private ToDoMapper toDoMapper;

    @Override
    public List<ToDo> findTodosByEventId(Integer eventId) {
        return toDoMapper.findTodosByEventId(eventId);
    }

    @Override
    public ToDo findById(Long id) {
        return toDoMapper.findById(id);
    }

    @Override
    public void save(ToDo toDo) {
        toDoMapper.save(toDo);
    }

    @Override
    public void update(ToDo toDo) {
        toDoMapper.update(toDo);
    }

    @Override
    public void delete(Long id) {
        toDoMapper.delete(id);
    }
}
