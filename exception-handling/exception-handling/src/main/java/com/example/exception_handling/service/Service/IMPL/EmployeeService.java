package com.example.exception_handling.service.Service.IMPL;

import com.example.exception_handling.dto.DtoDepartment;
import com.example.exception_handling.dto.DtoEmployee;
import com.example.exception_handling.dto.IUEmployee;
import com.example.exception_handling.entity.Department;
import com.example.exception_handling.entity.Employee;
import com.example.exception_handling.exception.BaseException;
import com.example.exception_handling.exception.ErrorMessage;
import com.example.exception_handling.exception.MessageType;
import com.example.exception_handling.repository.DepartmentRepository;
import com.example.exception_handling.repository.EmployeeRepository;
import com.example.exception_handling.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DtoEmployee findById(Long id) {
       Optional<Employee> employee =  repository.findById(id);
       if(employee.isEmpty()){
           throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST," id : " + id + " bulunamadı"));
       }else{
                DtoEmployee dtoEmployee = new DtoEmployee();
                BeanUtils.copyProperties(employee.get(), dtoEmployee);
                DtoDepartment department = new DtoDepartment();
                BeanUtils.copyProperties(employee.get().getDepartment(), department);
                dtoEmployee.setDepartment(department);
                return dtoEmployee;
       }
    }

    @Override
    public DtoEmployee createEmployee(IUEmployee employee) {
       Optional<Department> department = departmentRepository.findById(employee.getDepartment_id());
       if(!department.isEmpty()){
           DtoDepartment dtoDepartment = new DtoDepartment();
              BeanUtils.copyProperties(department.get(), dtoDepartment);
              Employee createdEmployee = new Employee();
              BeanUtils.copyProperties(employee, createdEmployee);
              createdEmployee.setDepartment(department.get());
              Employee dbEmployee = repository.save(createdEmployee);
              DtoEmployee dtoEmployee = new DtoEmployee();
              BeanUtils.copyProperties(dbEmployee, dtoEmployee);
              dtoEmployee.setDepartment(dtoDepartment);
              return dtoEmployee;
       }else {
           return  null;
       }
    }

    @Override
    public List<DtoEmployee> getAllEmployees() {
        return repository.findAll().stream()
                .map(employee -> {
                    DtoEmployee dtoEmployee = new DtoEmployee();
                    BeanUtils.copyProperties(employee, dtoEmployee);
                    DtoDepartment department = new DtoDepartment();
                    BeanUtils.copyProperties(employee.getDepartment(), department);
                    dtoEmployee.setDepartment(department);
                    return dtoEmployee;
                }).toList();
    }
}
