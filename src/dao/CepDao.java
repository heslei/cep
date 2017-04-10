package dao;

import model.Address;

public interface CepDao {

	Address findByCep(String cep);
}
