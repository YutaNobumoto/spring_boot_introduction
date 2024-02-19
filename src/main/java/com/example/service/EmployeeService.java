package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeService {
    // Repositoryをフィールドに用意する
    private final EmployeeRepository employeeRepository;

    // コンストラクタでRepositoryをインジェクション(下記はコンストラクタ・インジェクション)
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    // ビジネスロジック用のメソッドを以降に定義
    
    //全件取得処理
    public List<Employee> findAllEmployee() {
    	return this.employeeRepository.findAll();//employeeテーブルのデータをemployeeオブジェクトにつめて全件取得する
    }
    
    //主キーでの1件検索
    public Employee findEmployee(Integer employeeId) {
    	Optional<Employee> optionalEmployee=this.employeeRepository.findById(employeeId);
    	Employee employee=optionalEmployee.get();//OptionalからEntityクラスの取得を試みている
    	return employee;
    }
    
    public List<Employee> findByName(String name) {
    	return this.employeeRepository.findByName(name);
    }
    
    //新規登録処理
    public Employee insert(String name, String department) {
    	Employee employee=new Employee();//保存したいEntityクラスのインスタンスを作成
    	employee.setName(name);
    	employee.setDepartment(department);
    	return this.employeeRepository.save(employee);
    }
    
    //更新処理
    public Employee update(Integer employeeId, String name, String department) {
    	//更新したいデータの取得
    	Optional<Employee> optionalEmployee=this.employeeRepository.findById(employeeId);
    	Employee employee=optionalEmployee.get();
    	//Entityクラスのフィールドに更新内容のセット
    	employee.setName(name);
    	employee.setDepartment(department);
    	//データベースに保存
    	return this.employeeRepository.save(employee);
    }
    
    //削除処理
    public void delete(Integer id) {
    	this.employeeRepository.deleteById(id);
    }
}
