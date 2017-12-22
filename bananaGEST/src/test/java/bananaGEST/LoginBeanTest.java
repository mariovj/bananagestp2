package bananaGEST;

import static org.junit.Assert.*;
import com.generation.jwd.p1.beans.*;

import org.junit.Test;

public class LoginBeanTest {

	@Test
	public void testValidatorLoginCase1() {
		LoginBean usuario = new LoginBean();
		UserBean b1 = new UserBean("borja","11111");
		boolean admin = usuario.validator();
		String resultado = "borja";
		assertEquals(b1.getEmail(),resultado);
	}
	
//	@Test
//	public void testValidatorLogin2() {
//		UserBean fer = new UserBean();
//		
//		String resultadoreal = fer.getEmail("mario");
//		String resultadoesperado = "fernando";
//		assertEquals (resultadoreal, resultadoesperado);
//	}

}

//(usuario.getEmail()) && password.equals(usuario.getPassword()));
