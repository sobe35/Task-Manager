package com.example.TaskManager.Controller;

import com.example.TaskManager.Service.TaskService;
import com.example.TaskManager.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
        private final TaskService taskService;

        public TaskController(TaskService taskService) {
            this.taskService = taskService;
        }

        @GetMapping("/get-all-tasks")
        public ResponseEntity<?> getAllTasks() {
            List<Task> tasks = taskService.getAllTasks();
            return ResponseEntity.ok(tasks);
        }


        @GetMapping("/{id}")
        public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
            try{
                Task task = taskService.getTaskById(id);
                return new ResponseEntity<>(task,HttpStatus.OK);
            }catch(Exception e){
                e.printStackTrace();

                ResponseEntity<Task> taskResponseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
                return taskResponseEntity;
            }
        }

        @PostMapping
        public ResponseEntity<Task> createTask(@RequestBody Task task) {
            Task createdTask = taskService.createTask(task);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
            Task updatedTask = taskService.updateTask(id, task);
            if (updatedTask != null) {
                return ResponseEntity.ok(updatedTask);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build();
        }




    }



