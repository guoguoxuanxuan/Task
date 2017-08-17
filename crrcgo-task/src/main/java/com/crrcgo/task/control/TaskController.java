package com.crrcgo.task.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.crrcgo.task.model.Task;
import com.crrcgo.task.service.TaskService;
import com.github.pagehelper.PageInfo;



@Controller
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
		
	
	@RequestMapping
    public ModelAndView getAll(Task task) {
        ModelAndView result = new ModelAndView("taskMain");
        List<Task> taskList = taskService.getAll(task);
        result.addObject("pageInfo", new PageInfo<Task>(taskList));
        result.addObject("queryParam", task);
        result.addObject("page", task.getPage());
        result.addObject("rows", task.getRows());
        return result;
    }
	
	
}
