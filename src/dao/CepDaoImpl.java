package dao;

import java.util.HashMap;
import java.util.Map;

import model.Address;

public class CepDaoImpl implements CepDao {

	private static Map<String, Address> addresses = new HashMap<String, Address>();

	static {

		String[] cep = new String[] { "63500000", "63000000","60000000","63500001", "63500011", "63500111", "08743-239" };
		for (int i = 0; i < cep.length; i++) {
			Address address = new Address();
			address.setStreet("Street " + i);
			address.setDistrict("District " + i);
			address.setCity("City " + i);
			address.setState("State " + i);
			addresses.put(cep[i], address);

		}
	}

	public Address findByCep(String cep) {

		return addresses.get(cep);
	}

}
