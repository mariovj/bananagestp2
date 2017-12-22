package bananaGEST;

import static org.junit.Assert.*;
import com.generation.jwd.p1.beans.*;

import org.junit.Test;

public class LoginBeanTest {
	
	LoginBean usuario = new LoginBean();
//	UserBean b1 = new UserBean("borja","11111");
//	boolean admin = usuario.validator();
	UserBean Mario = new UserBean(
			"muvalera",
			"12345"
			);
	
	UserBean Claudia = new UserBean(
			"claudiamas",
			"56789"
			);
	
	UserBean Daniel = new UserBean(
			"danilozano",
			"01010"
			);
	
	UserBean Borja = new UserBean(
			"borjaherranz",
			"11111"
			);
	
	UserBean Enrique = new UserBean(
			"enriqueruiz",
			"99999"
			);
	
	UserBean[] users = {Mario, Claudia, Daniel, Borja, Enrique};

	@Test
	public void testValidatorWithEmailBorjaReturnCorrectData() {
		
		String name = Borja.getEmail();
		String result = "borjaherranz";
		assertEquals(name,result);
	}
	
	@Test
	public void testValidatorWithEmailMarioReturnCorrectData() {
		
		String name = Mario.getEmail();
		String result = "muvalera";
		assertEquals(name,result);
	}

	@Test
	public void testValidatorWithEmailClaudiaReturnCorrectData() {
		
		String name = Claudia.getEmail();
		String result = "claudiamas";
		assertEquals(name,result);
	}

	@Test
	public void testValidatorWithEmailDanielReturnCorrectData() {
		
		String name = Daniel.getEmail();
		String result = "danilozano";
		assertEquals(name,result);
	}

	@Test
	public void testValidatorWithEmailEnriqueReturnCorrectData() {
		
		String name = Enrique.getEmail();
		String result = "enriqueruiz";
		assertEquals(name,result);
	}
	
	@Test
	public void testValidatorWithPassBorjaReturnCorrectData() {
		
		String name = Borja.getPassword();
		String result = "11111";
		assertEquals(name,result);
	}
	
	@Test
	public void testValidatorWithPassMarioReturnCorrectData() {
		
		String name = Mario.getPassword();
		String result = "12345";
		assertEquals(name,result);
	}
	
	@Test
	public void testValidatorWithPassClaudiaReturnCorrectData() {
		
		String name = Claudia.getPassword();
		String result = "56789";
		assertEquals(name,result);
	}
	
	@Test
	public void testValidatorWithPassDanielReturnCorrectData() {
		
		String name = Daniel.getPassword();
		String result = "01010";
		assertEquals(name,result);
	}
	
	@Test
	public void testValidatorWithPassEnriqueReturnCorrectData() {
		
		String name = Enrique.getPassword();
		String result = "99999";
		assertEquals(name,result);
	}
}


	
