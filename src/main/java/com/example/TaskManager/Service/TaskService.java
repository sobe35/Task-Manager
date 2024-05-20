package com.example.TaskManager.Service;

import com.example.TaskManager.Repository.TaskRepository;
import com.example.TaskManager.entity.Task;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

    @Service
    public class TaskService {
        private final TaskRepository taskRepository;

        @Autowired
        public TaskService(TaskRepository taskRepository) {
            this.taskRepository = taskRepository;
        }

        public List<Task> getAllTasks() {
            return taskRepository.findAll();
        }

        public Task getTaskById(Long id) {
            try{
                Optional<Task> byId = taskRepository.findById(id);
                Task task = null;
                if(byId.isPresent()) {
                    task= byId.get();
                }
                return task;
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }

        }

        public Task createTask(Task task) {
            return taskRepository.save(task);
        }

        public Task updateTask(Long id, Task taskDetails) {
            Optional<Task> optionalTask = taskRepository.findById(id);
            if (optionalTask.isPresent()) {
                Task existingTask = optionalTask.get();
          //      existingTask.setTitle(taskDetails.getTitle());
                existingTask.setDescription(taskDetails.getDescription());
                existingTask.setCompleted(taskDetails.isCompleted());
                return taskRepository.save(existingTask);
            } else {
                return null; // Task with given id not found
            }
        }

        public void deleteTask(Long id) {
            taskRepository.deleteById(id);
        }
    }


