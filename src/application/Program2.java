package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById =====");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n=== TEST 3: department findByAll =====");
		List<Department> depList= departmentDao.findAll();
		for (Department obj : depList) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 4: department insert =====");
		Department dep = new Department(9, "new Department");
		departmentDao.insert(dep);
		System.out.println("Departamento inserido!");
		
		System.out.println("\n=== TEST 5: department update =====");
		department = departmentDao.findById(8);
		department.setName("General services");
		departmentDao.update(department);
		System.out.println("Atualização completa!");
		
		System.out.println("\n=== TEST 6: department delete =====");
		int resp = sc.nextInt();
		departmentDao.deleteById(resp);
		System.out.println("Deletado!");
		
		sc.close();
	}

}
