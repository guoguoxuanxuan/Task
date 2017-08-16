package com.crrcgo.task.model;

import javax.persistence.*;


public class Task extends BaseEntity {
    @Id
    private Integer taskid;

    @Column(name = "taskTitle")
    private String tasktitle;

    @Column(name = "taskShortName")
    private String taskshortname;

    @Column(name = "taskDescribe")
    private String taskdescribe;

    /**
     * @return taskid
     */
    public Integer getTaskid() {
        return taskid;
    }

    /**
     * @param taskid
     */
    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    /**
     * @return taskTitle
     */
    public String getTasktitle() {
        return tasktitle;
    }

    /**
     * @param tasktitle
     */
    public void setTasktitle(String tasktitle) {
        this.tasktitle = tasktitle;
    }

    /**
     * @return taskShortName
     */
    public String getTaskshortname() {
        return taskshortname;
    }

    /**
     * @param taskshortname
     */
    public void setTaskshortname(String taskshortname) {
        this.taskshortname = taskshortname;
    }

    /**
     * @return taskDescribe
     */
    public String getTaskdescribe() {
        return taskdescribe;
    }

    /**
     * @param taskdescribe
     */
    public void setTaskdescribe(String taskdescribe) {
        this.taskdescribe = taskdescribe;
    }
}