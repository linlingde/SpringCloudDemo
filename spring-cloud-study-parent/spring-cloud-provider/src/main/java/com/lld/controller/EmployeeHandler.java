package com.lld.controller;

import com.lld.entity.Employee;
import com.lld.entity.ResultEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author linlingde
 * @version 1.0
 * @className EmployeeHandler
 * @description
 * @date 2022/7/27 14:48
 **/

@RestController
public class EmployeeHandler {


    @RequestMapping("/provider/get/employee/romote")
    public Employee getEmployeeRemote(HttpServletRequest request) {

        int serverPort = request.getServerPort();


        return new Employee(1, "LLD" + serverPort, 100000d);
    }

    @RequestMapping("/provider/get/employee/remote")
    public Employee getEmployeeRemote() {
        return new Employee(1, "LLDByFeiGn", 100000d);
    }

    @HystrixCommand(fallbackMethod = "getEmpBackup")
    @RequestMapping("/provider/circuit/breaker/get/emp")
    public ResultEntity<Employee> getEmp(@RequestParam("signal") String signal) {
        if ("bang".equals(signal)) {
            throw new RuntimeException();
        }
        return ResultEntity.successWithData(new Employee(666, "sam666", 666.66));
    }

    public ResultEntity<Employee> getEmpBackup(@RequestParam("signal") String signal) {
        return ResultEntity.failed("circuit break workded,with signal=" + signal);
    }
}
