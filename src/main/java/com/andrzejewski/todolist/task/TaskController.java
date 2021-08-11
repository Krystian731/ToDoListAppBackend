package com.andrzejewski.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/tasks")
public class TaskController {

    @Autowired
    private TaskService mTaskService;

    @GetMapping("/{userId}")
    public List<TaskEntity> getAllTasksByUserId(@PathVariable("userId") Long userId) {
        return mTaskService.getAllTasksByUserId(userId);
    }

    @PostMapping
    public void addNewTask(@RequestBody TaskEntity taskEntity) {
        mTaskService.addNewTask(taskEntity);
    }

    @DeleteMapping("/{userId}/{taskId}")
    public boolean deleteTaskById(@PathVariable Long userId, @PathVariable Long taskId) {
        return mTaskService.deleteTask(userId, taskId);
    }

    @PutMapping("/{taskId}")
    public void updateTask(@PathVariable Long taskId, @RequestParam(required = false) String text,
                           @RequestParam(required = false) LocalDateTime taskCompletionDate) {
        System.out.println(taskId + " " + text + " " + taskCompletionDate);
        mTaskService.updateTask(taskId, text, taskCompletionDate);
    }
}