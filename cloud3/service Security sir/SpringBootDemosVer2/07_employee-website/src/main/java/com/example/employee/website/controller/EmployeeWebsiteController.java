package com.example.employee.website.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.employee.pojo.Employee;

@Controller
public class EmployeeWebsiteController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("employeesURL","http://localhost:8989/employee/1/4");
		return modelAndView;
	}

	@RequestMapping("/employee/{start}/{count}")
	public ModelAndView getEmployeesByPage(@PathVariable("start") int start,
			@PathVariable("count") int count) {

		Resources resources = restTemplate.getForObject("http://localhost:8080/employee/"+start+"/"+count, 
				Resources.class);
		
		ModelAndView modelAndView = new ModelAndView("employees");

		List<Link> links = resources.getLinks();
		
		List<Employee> employeesList = new ArrayList<>();
		
		Collection<Map> employees = resources.getContent();
		for (Map employeeMap : employees) {
			int id = Integer.parseInt(employeeMap.get("id").toString());
			String firstName = employeeMap.get("firstName").toString();
			String lastName = employeeMap.get("lastName").toString();
			Employee employee = new Employee(id, firstName, lastName);
			employeesList.add(employee);
		}
		
		modelAndView.addObject("employees", employeesList);
		
		String stringURL1 = links.get(0).getHref();
		String stringURL2 = links.size()>1?links.get(1).getHref():null;
		
		URL url1 = null, url2 = null;
		try {
			url1 = new URL(stringURL1);
			url2 = stringURL2!=null?new URL(stringURL2):null;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		modelAndView.addObject(links.get(0).getRel(), url1.getPath());
		
		if(url2!=null) {
			modelAndView.addObject(links.get(1).getRel(), url2.getPath());
		}
		
		return modelAndView;
	}
}
