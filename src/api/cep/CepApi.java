package api.cep;

import javax.validation.ValidationException;
import javax.validation.constraints.Pattern;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Address;
import service.CepServiceImpl;

@Path("/cep")
public class CepApi {

	private CepServiceImpl cepService = new CepServiceImpl();

	@GET
	@Path("{value}")
	@Produces(MediaType.APPLICATION_JSON)
	public Address addressByCep(
			final @PathParam("value") @Pattern(regexp = "\\d{5}[-]?\\d{3}", message = "CEP Inválido") String cep) {

		Address address = cepService.findByCep(cep);

		if (address == null) {
			throw new ValidationException("CEP inválido");
		}
		return address;
	}
}
