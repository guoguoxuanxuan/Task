package com.crrcgo.task.control;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.crrcgo.task.model.Task;
import com.crrcgo.task.service.TaskService;


@RestController
@RequestMapping("/taskDatas")
public class TaskRestControl {

	@Autowired
	private TaskService taskService;
	
	@RequestMapping("/task")
    public Task getTask() {
        Task task = new Task() ;
        task.setId(0);
        task.setTaskshortname("task1");
        task.setTaskdescribe("test ");
        return task;
    }
}
