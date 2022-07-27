package com.example.ShoppingCart;

import com.example.ShoppingCart.Repo.*;
import com.example.ShoppingCart.model.Cart;
import com.example.ShoppingCart.model.Product;
import com.example.ShoppingCart.model.Users;
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

import java.util.List;
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

	@Test
	@Order(3)
	public void dbProductDefaultData() throws Exception {

		String[] products = {"apple ipad 10.2 8th gen wifi ios tablet", "crocin pain relief tablet"};
		String[] prices = {"29190", "10"};
		for (ListIterator<?> it = ((JSONArray) new JSONParser()
				.parse(new ObjectMapper().writeValueAsString(productRepo.findAll()))).listIterator(); it.hasNext(); ) {
			assertEquals(products[it.nextIndex()],
					((JSONObject) it.next()).get("productName").toString().toLowerCase());
			assertEquals(prices[it.nextIndex()],
					String.valueOf(Math.round((Double) ((JSONObject) it.next()).get("price"))));
		}
	}

	@Test
	@Order(4)
	public void dbCartDefaultData() throws Exception {
		List<Cart> arr = cartRepo.findAll();
		assertEquals(2, arr.size());
		assertEquals("20.0", arr.get(0).getTotalAmount().toString());
		assertEquals("0.0", arr.get(1).getTotalAmount().toString());
		assertEquals("2", arr.get(0).getCartProducts().get(0).getProduct().getProductId().toString());
		assertEquals("2", arr.get(0).getCartProducts().get(0).getQuantity().toString());
		assertEquals("10.0", arr.get(0).getCartProducts().get(0).getProduct().getPrice().toString());
		assertEquals("Crocin pain relief tablet",
				arr.get(0).getCartProducts().get(0).getProduct().getProductName().toString());
		assertEquals("5", arr.get(0).getCartProducts().get(0).getProduct().getCategory().getCategoryId().toString());
		assertEquals("Medicines",
				arr.get(0).getCartProducts().get(0).getProduct().getCategory().getCategoryName().toString());
		assertEquals(0, arr.get(1).getCartProducts().size());
	}

	@Test
	@Order(5)
	public void updateUser() {
		Users user = userRepo.findById(1).get();
		assertEquals("jack", user.getUsername());
		user.setUsername("jackie");
		userRepo.save(user);
		user = userRepo.findById(3).get();
		assertEquals("apple", user.getUsername());
		user.setUsername("apple inc");
		userRepo.save(user);
	}

	@Test
	@Order(6)
	public void checkUpdatedUsers() throws Exception {
		String[] users = {"jackie", "bob", "apple inc", "glaxo"};
		ListIterator<?> it;
		for (it = ((JSONArray) new JSONParser()
				.parse(new ObjectMapper().writeValueAsString(userRepo.findAll()))).listIterator(); it.hasNext(); ) {
			assertEquals(users[it.nextIndex()], ((JSONObject) it.next()).get("username").toString());
		assertEquals("pass_word", ((JSONObject) it.next()).get("password").toString());
	}}

	@Test
	@Order(7)
	public void updateProduct() {
		Product p = productRepo.findById(1).get();
		assertEquals("apple ipad 10.2 8th gen wifi ios tablet",p.getProductName().toString().toLowerCase());
		assertEquals("29190", String.valueOf(Math.round((Double) p.getPrice())));
		p.setProductName("apple iphone");
		p.setPrice(30000.0);
		productRepo.save(p);
}
}