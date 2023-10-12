package br.com.spindolasoft.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private ITaskRepository taskRepository;

    @PostMapping("/tasks")
    public TaskModel create(@RequestBody TaskModel taskModel){
        return this.taskRepository.save(taskModel);
    }
}
