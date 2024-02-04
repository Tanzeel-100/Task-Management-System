package com.taskManager.repository.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Integer taskId;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_description")
    private String taskDescription;

    @Column(name = "task_status")
    private String taskStatus;

    @Column(name = "task_assignee")
    private String taskAssignee;

    @Column(name = "task_priority")
    private String taskPriority;

    @Column(name = "task_assigned_date")
    private Date taskAssignedDate;

    @Column(name = "task_deadline")
    private Date taskDeadline;

}
