package service;

import org.junit.Assert;
import org.junit.Test;


public class ReplacementTest {

	@Test
	public void given000000008Returns00000000() {
		CepServiceImpl service = new CepServiceImpl();
		String result = service.replaceLastCharsByZeros("00000888", 1);
		Assert.assertEquals("00000880", result);

	}
	
	@Test
	public void given00000088Returns00000000() {
		CepServiceImpl service = new CepServiceImpl();
		String result = service.replaceLastCharsByZeros("00000888", 2);
		Assert.assertEquals("00000800", result);

	}
	
	@Test
	public void given12345888Returns12345000() {
		CepServiceImpl service = new CepServiceImpl();
		String result = service.replaceLastCharsByZeros("12345888", 3);
		Assert.assertEquals("12345000", result);

	}
	
	@Test
	public void given00000000Returns00000000() {
		CepServiceImpl service = new CepServiceImpl();
		String result = service.replaceLastCharsByZeros("00000000", 1);
		Assert.assertEquals("00000000", result);

	}
}
