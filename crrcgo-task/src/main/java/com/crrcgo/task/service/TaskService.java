package com.crrcgo.task.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.crrcgo.task.mapper.TaskMapper;
import com.crrcgo.task.model.Task;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;



@Service
public class TaskService {
	
	
	@Autowired
	private TaskMapper taskMapper;
	
	public List<Task> getAll(Task task) {
        if (task.getPage() != null && task.getRows() != null) {
            PageHelper.startPage(task.getPage(), task.getRows());
        }
        Example example = new Example(Task.class);
        Example.Criteria criteria = example.createCriteria();
        if (task.getTasktitle() != null && task.getTasktitle().length() > 0) {
            criteria.andLike("taskName", "%" + task.getTasktitle() + "%");
        }
        if (task.getTaskid() != null && task.getTaskid() > 0) {
            criteria.andLike("taskId", "%" + task.getTaskid() + "%");
        }
        return taskMapper.selectByExample(example);
    }

}
