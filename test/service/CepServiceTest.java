package service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.Address;

public class CepServiceTest {

	private Address address = null;

	@Before
	public void fill() {
		address = new Address();
		address.setStreet("Street 0");
		address.setDistrict("District 0");
		address.setCity("City 0");
		address.setState("State 0");
	}

	@Test
	public void givenAValidCepReturnItsAddress() {

		CepService service = new CepServiceImpl();
		Address result = service.findByCep("63500000");

		Assert.assertEquals(address, result);
	}

	@Test
	public void givenAPartialValidCepWithOneDigitWrongReturnItsAddress() {

		CepService service = new CepServiceImpl();
		Address result = service.findByCep("63500006");

		Assert.assertEquals(address, result);
	}

	@Test
	public void givenAPartialValidCepWithTwoDigitWrongReturnItsAddress() {

		CepService service = new CepServiceImpl();
		Address result = service.findByCep("63500045");

		Assert.assertEquals(address, result);
	}

	@Test
	public void givenAPartialValidCepWithThreeDigitWrongReturnItsAddress() {

		CepService service = new CepServiceImpl();
		Address result = service.findByCep("63500745");

		Assert.assertEquals(address, result);
	}

	@Test
	public void givenAPartialValidCepWithFourDigitWrongReturnItsAddress() {

		CepService service = new CepServiceImpl();
		Address result = service.findByCep("63503745");

		Assert.assertEquals(address, result);
	}

	@Test
	public void givenAPartialValidCepWithFiveDigitWrongReturnItsAddress() {

		CepService service = new CepServiceImpl();
		Address result = service.findByCep("63583745");

		Assert.assertEquals(address, result);
	}

	@Test
	public void givenAPartialValidCepWithSixDigitWrongReturnItsAddress() {

		CepService service = new CepServiceImpl();
		Address result = service.findByCep("63983-745");

		address = new Address();
		address.setStreet("Street 1");
		address.setDistrict("District 1");
		address.setCity("City 1");
		address.setState("State 1");

		Assert.assertEquals(address, result);
	}

	@Test
	public void givenAPartialValidCepWithSevenDigitWrongReturnItsAddress() {

		CepService service = new CepServiceImpl();
		Address result = service.findByCep("69983-745");
		address = new Address();
		address.setStreet("Street 2");
		address.setDistrict("District 2");
		address.setCity("City 2");
		address.setState("State 2");

		Assert.assertEquals(address, result);
	}

}
