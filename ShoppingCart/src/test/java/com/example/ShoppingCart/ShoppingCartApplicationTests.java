package com.example.ShoppingCart;

import com.example.ShoppingCart.Repo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ListIterator;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ShoppingCartApplicationTests {

	@Autowired
	CartProductRepo cartProductRepo;

	@Autowired
	CartRepo cartRepo;

	@Autowired
	CategoryRepo categoryRepo;

	@Autowired
	ProductRepo productRepo;

	@Autowired
	RoleRepo roleRepo;

	@Autowired
	UserRepo userRepo;

	@Test
	@Order(1)
	public void dbCategoryDefaultData() throws Exception {

		String[] categories = {"Fashion", "Electronics", "Books", "Groceries", "Medicines"};
		for (ListIterator<?> it = ((JSONArray) new JSONParser()
				.parse(new ObjectMapper().writeValueAsString(categoryRepo.findAll()))).listIterator(); it.hasNext(); )
			assertEquals(categories[it.nextIndex()], ((JSONObject) it.next()).get("categoryName").toString());
	}

	@Test
	@Order(2)
	public void dbuserDefaultData() throws Exception {
		String[] users = {"jack", "bob", "apple", "glaxo"};
		for (ListIterator<?> it = ((JSONArray) new JSONParser()
				.parse(new ObjectMapper().writeValueAsString(userRepo.findAll()))).listIterator(); it.hasNext(); ) {
			assertEquals(users[it.nextIndex()], ((JSONObject) it.next()).get("username").toString());
			assertEquals("pass word", ((JSONObject) it.next()).get("password").toString());
		}
	}
}
