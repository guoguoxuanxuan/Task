package com.crrcgo.task.control;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.crrcgo.task.model.Task;
import com.crrcgo.task.service.TaskService;
import com.crrcgo.task.util.LocalMessageService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private LocalMessageService lms ;
			
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
	
	@RequestMapping("/i18n")
	public ModelAndView getList(Model model) {
        model.addAttribute("crrcgo",lms.getMessage("com.crrcgo.title")) ;
        model.addAttribute("tableTitle",lms.getMessage("com.crrcgo.task.table.title")) ;
        model.addAttribute("taskTableId",lms.getMessage("com.crrcgo.task.table.id")) ;
        model.addAttribute("taskTableTitle",lms.getMessage("com.crrcgo.task.table.title")) ;
        model.addAttribute("taskTableDescribe",lms.getMessage("com.crrcgo.task.table.describe")) ;
        ModelAndView result = new ModelAndView("taskMain");
        return result;
    }

}
