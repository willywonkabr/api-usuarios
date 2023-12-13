import dto.UsuarioDTOInput;
import org.junit.Test;
import service.UsuarioService;

import static org.junit.Assert.assertEquals;

public class ServiceTeste {
	@Test
	public void serviceTeste() {
		UsuarioService usuarioService = new UsuarioService();
		UsuarioDTOInput usuarioDTOInput = new UsuarioDTOInput();
		usuarioDTOInput.setId(0);
		usuarioDTOInput.setNome("João Victor");
		usuarioDTOInput.setSenha("admin123");

		usuarioService.inserir(usuarioDTOInput);

		assertEquals(1, usuarioService.listar().size());
	}
}
