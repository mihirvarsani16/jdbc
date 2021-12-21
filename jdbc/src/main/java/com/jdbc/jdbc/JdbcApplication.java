package com.jdbc.jdbc;

import com.jdbc.jdbc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcApplication implements CommandLineRunner {

	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(JdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.userDao.createTable());

		// creating user
		// this.createUser();
	}

	// public void createUser() {
	// Scanner sc = new Scanner(System.in);
	// System.out.println("Enter user Id: ");
	// int id = sc.nextInt();
	// System.out.println("Enter user Name: ");
	// String name = sc.nextLine();
	// System.out.println("Enter user Age: ");
	// int age = sc.nextInt();
	// System.out.println("Enter user City: ");
	// String city = sc.nextLine();

	// User user = new User();
	// user.setId(id);
	// user.setName(name);
	// user.setAge(age);
	// user.setCity(city);
	// int i = this.userDao.insertData(user);
	// System.out.println(i);
	// }

}
