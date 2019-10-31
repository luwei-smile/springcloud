package com.app.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.DepartmentDao;
import com.app.dao.EmployeeDao;
import com.app.pojo.Department;
import com.app.pojo.Employee;

@Controller
public class Emps_Operate {

	@Autowired
	EmployeeDao employeedao;

	@Autowired
	DepartmentDao departmentdao;

	// 显示全部员工列表
	@RequestMapping(value = "/emps_list")
	public String emps_getall(Model model) {
		Collection<Employee> Emp_Collections = employeedao.getAll();
		model.addAttribute("Emp_Collections", Emp_Collections);
		return "list";
	}

	// 来到添加员工页面
	@RequestMapping(value = "/to_emp_add")
	public String to_emp_add(Model model) {

		// 查询出全部Department先是在页面中
		Collection<Department> departments = departmentdao.getDepartments();
		model.addAttribute("departments", departments);
		return "add";
	}

	// 添加员工
	@PostMapping("/add_emp")
	public String add_emp(Employee employee) {
		employeedao.save(employee);
		return "redirect:/emps_list";
	}

	// 员工删除
	@RequestMapping("/delete_emp/{id}")
	public String delete_emp(@PathVariable(value = "id") Integer id) {
		System.out.println("wqwqw");
		employeedao.delete(id);
		return "redirect:/emps_list";
	}

	// 来到员工修改页面，员工进行回显
	@RequestMapping("/alter_emp/{id}")
	public String alter_emp(@PathVariable(value = "id") Integer id, Model model) {
		Employee employee = employeedao.get(id);
		model.addAttribute("employee", employee);

		// 显示所有部门
		Collection<Department> departments = departmentdao.getDepartments();
		model.addAttribute("departments", departments);
		return "add";
	}

	// 修改员工信息
	@PutMapping("/add_emp")
	public String alter(Employee employee) {
		System.out.println(employee);
		employeedao.save(employee);
		return "redirect:/emps_list";
	}

}
