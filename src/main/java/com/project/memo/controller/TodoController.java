package com.project.memo.controller;

import com.project.memo.entity.ToDo;
import com.project.memo.service.IToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@Controller
public class TodoController extends BaseController{


    @Autowired
    private IToDoService toDoService;


    @GetMapping("/todo/{id}")
    public String todoPage(@PathVariable("id") Long id, Model model,HttpSession session) {
        ToDo toDo = toDoService.findById(id);
        model.addAttribute("todo", toDo);
        return "todo";
    }

    @GetMapping("/changeTodoStatus/{id}/{complete}")
    public String changeStatus(Model model,@PathVariable("id") Long id,@PathVariable("complete") Boolean complete,HttpSession session){
        System.out.println(id);
        System.out.println(complete);
        ToDo toDo = toDoService.findById(id);
        Integer eventId = getEventIdFromSession(session);

        toDo.setComplete(!complete);
        toDoService.update(toDo);
        List<ToDo> todos = toDoService.findTodosByEventId(eventId);
        model.addAttribute("todos", todos);
        return "redirect:/detail/" + eventId;
    }


    @GetMapping("/todo/create")
    public String createTodoPage(Model model) {
        model.addAttribute("todo", new ToDo());
        return "todo";
    }


    @PostMapping("/todo/create")
    public String createTodoPost(@ModelAttribute("todo") @Valid ToDo toDo,
                                 HttpSession session,
                                 BindingResult result) {
        if (result.hasErrors()) return "todo";
        Integer eventId = getEventIdFromSession(session);
        if (toDo.getId() == null){
            toDo.setEventId(Long.valueOf(eventId));
            toDoService.save(toDo);
        }else{
            toDoService.update(toDo);
        }
        return "redirect:/detail/" + eventId;
    }


    @GetMapping("/todo/delete/{id}")
    public String deleteTodo(@PathVariable Long id, HttpSession session) {
        toDoService.delete(id);
        Integer eventId = getEventIdFromSession(session);
        return "redirect:/detail/" + eventId;
    }
}
