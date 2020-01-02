package com.website.web.dao;

import java.sql.Connection;

import com.website.web.model.Client;

public class ClientDao {
	public Client getClient(String fullName) {
		Client c = new Client();
		c.setFullName("David Miller");
		c.setEmail_address("d.miller@gmail.com");
		c.setPassword("david");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager("jdbc:mysql://localhost:3306/Website", "root", "");// arguments are url,
																								// username, password.
		} catch (Exception e) {
			System.out.println(e);
		}

		return c;
	}
}
