package com.lld;

import com.lld.entity.Employee;
import com.lld.entity.ResultEntity;
import com.lld.remoteservice.EmployeeRemoteService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author linlingde
 * @version 1.0
 * @className MyFallBackFactory
 * @description
 * @date 2022/7/30 10:37
 **/
@Component
public class MyFallBackFactory implements FallbackFactory<EmployeeRemoteService> {
    // cause 对象是失败原因对应的异常对象
    @Override
    public EmployeeRemoteService create(Throwable cause) {

        return new EmployeeRemoteService() {

            @Override
            @RequestMapping("/provider/get/employee/remote")
            public Employee getEmployeeRemote() {
                return new Employee(444,
                        "call provider failed,fall back here, reasonis " + cause.getClass().getName() + " " + cause.getMessage(),
                        444.444);
            }


            @Override
            @RequestMapping("/provider/circuit/breaker/get/emp")
            public ResultEntity<Employee> getEmp(String signal) {
                return null;
            }
        };
    }
}
