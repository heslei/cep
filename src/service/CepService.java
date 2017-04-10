package service;

import model.Address;

public interface CepService {

	Address findByCep(String cep);
}
