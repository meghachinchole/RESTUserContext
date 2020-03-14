package com.Training;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Training.model.Account;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Servlet implementation class Users
 */
@WebServlet("/Users")
public class UsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
String body = request.getReader().lines().collect(Collectors.joining());
		
		ObjectMapper mapper = new ObjectMapper();
		
		//Print how a JSON looks like
		ObjectNode node = mapper.createObjectNode();
		
		Account acc = new Account();
		
		node.putPOJO("UsersDetails",acc);
		
		System.out.println(node.toString());
		
		//Get from Inputs
		
		JsonNode inNode = mapper.readTree(body);
		
		acc = mapper.treeToValue(inNode, Account.class);
		
		System.out.println(acc.Address + acc.FirstName + acc.LastName);
		
		
		
		doGet(request, response);
	}

}
