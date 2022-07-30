package com.lld.remoteservice;

import com.lld.entity.Employee;
import com.lld.entity.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author linlingde
 * @version 1.0
 * @interfaceName EmployeeRemoteService
 * @description
 * @date 2022/7/30 09:42
 **/

@Component
@FeignClient(value = "LLD-PROVIDER")
public interface EmployeeRemoteService {

    @RequestMapping("/provider/get/employee/remote")
    public Employee getEmployeeRemote();


    @RequestMapping("/provider/circuit/breaker/get/emp")
    public ResultEntity<Employee> getEmp(@RequestParam("signal") String signal);
}
