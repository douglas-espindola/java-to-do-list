package br.com.spindolasoft.todolist.task;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private ITaskRepository taskRepository;

    @PostMapping("/tasks")
    public TaskModel create(@RequestBody TaskModel taskModel, HttpServletRequest request){
        taskModel.setIdUser((UUID) request.getAttribute("idUser"));
        return this.taskRepository.save(taskModel);
    }
}
