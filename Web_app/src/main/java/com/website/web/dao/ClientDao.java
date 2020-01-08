package com.website.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.website.web.model.Client;

public class ClientDao {
	public Client getClient(String email_address, String password) {
		Client c = new Client();


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Website", "root",
					"password");// arguments
																											// are
																											// url,username,
																											// password.
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from Website.login where email_address= '" + email_address + "'"
					+ " and password = '" + password + "'");
			if (rs.next()) {
				c.setFullName(rs.getString("fullname"));
				c.setEmail_address(rs.getString("email_address"));
				c.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		// close connection

		return c;
	}
}
