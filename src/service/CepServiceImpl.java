package service;

import dao.CepDao;
import dao.CepDaoImpl;
import model.Address;

public class CepServiceImpl implements CepService {

	private static final int ATTEMPTS = 7;
	private CepDao cepDao = null;
	private String[] cepAttempts = new String[] { "0", "00", "000","0000","00000","000000","0000000" };

	public CepServiceImpl() {
		cepDao = new CepDaoImpl();
	}

	public CepServiceImpl(CepDao dao) {
		cepDao = dao;
	}

	public Address findByCep(String cep) {
		Address address = null;
		String value = cep.replaceAll("[^\\d]", "");

		address = findByCep(value, 0);

		return address;
	}

	protected Address findByCep(String cep, int attempt) {
		Address address = null;
		int nextAttempt = attempt + 1;

		address = cepDao.findByCep(cep);

		if (address == null && attempt < ATTEMPTS) {
			String cepAttempt = replaceLastCharsByZeros(cep, nextAttempt);
			address = findByCep(cepAttempt, nextAttempt);

		}

		return address;
	}

	protected String replaceLastCharsByZeros(String value, int quantity) {

		if (quantity <= 0 || quantity > 7) {
			throw new IllegalArgumentException("quantity cannot be " + quantity + ". Must be a value between 1 and 7.");
		}

		if (value == null || value.length() < 1) {
			throw new IllegalArgumentException("value cannot be less than 1");
		}
		return value.substring(0, value.length() - quantity) + cepAttempts[quantity - 1];
	}

}
