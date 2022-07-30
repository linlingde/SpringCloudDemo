package com.lld.mvc.handler;

import com.lld.entity.Employee;
import com.lld.entity.ResultEntity;
import com.lld.remoteservice.EmployeeRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author linlingde
 * @version 1.0
 * @className HumanResourceHandler
 * @description
 * @date 2022/7/27 15:11
 **/

@RestController
public class HumanResourceHandler {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EmployeeRemoteService employeeRemoteService;

    @RequestMapping("/consumer/get/employee")
    public Employee getEmployeeRemote() {

        // 远程主机地址
        // 不添加Eureka,需要使用IP+端口号
        // String host = "http://localhost:8081"
        // 使用Eureka,使用别名+端口号
        // String host = "http://lld-provider:8081";
        // 使用Eureka+Ribbon,只使用别名
        //172.26.84.222:lld-provider:8081
        String host = "http://LLD-PROVIDER";
        // 远程URL地址
        String url = "/provider/get/employee/romote";

        return restTemplate.getForObject(host + url, Employee.class);
    }

    @RequestMapping("/feign/consumer/get/emp")
    public Employee getEmployeeRemoteByFeiGn() {
        return employeeRemoteService.getEmployeeRemote();
    }

    @RequestMapping("/hystrix/consumer/get/emp")
    public ResultEntity<Employee> getEmployeeRemoteByFeiGnAndHystrix(@RequestParam(name = "signal", defaultValue = "nihao") String signal) {

        return employeeRemoteService.getEmp(signal);

    }

}
