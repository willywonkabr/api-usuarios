package controller;

import dto.UsuarioDTOInput;
import service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.Spark.delete;

public class UsuarioController {
	private final UsuarioService usuarioService = new UsuarioService();
	private final ObjectMapper objectMapper = new ObjectMapper();

	public UsuarioController() {
		respostasRequisicioes();
	}

	void respostasRequisicioes() {
		get("/usuarios", (request, response) -> {
			String respostaJson = objectMapper.writeValueAsString(usuarioService.listar());
			response.type("application/json");
			response.status(200);
			return respostaJson;
		});

		get("/usuarios/:id", (request, response) -> {
			String idUrl = request.params("id");
			int id = Integer.valueOf(idUrl);
			String respostaJson = objectMapper.writeValueAsString(usuarioService.buscar(id));
			response.type("application/json");
			response.status(200);
			return respostaJson;
		});

		post("/usuarios", (request, response) -> {
			UsuarioDTOInput usuarioDTOInput = objectMapper.readValue(request.body(), UsuarioDTOInput.class);
			usuarioService.inserir(usuarioDTOInput);
			response.type("application/json");
			response.status(201);
			return "Usuario criado com sucesso!";
		});

		put("/usuarios", (request, response) -> {
			UsuarioDTOInput usuarioDTOInput = objectMapper.readValue(request.body(), UsuarioDTOInput.class);
			usuarioService.alterar(usuarioDTOInput);
			response.type("application/json");
			response.status(200);
			return "Usuario alterado com sucesso!";
		});

		delete("/usuarios/:id", (request, response) -> {
			String idUrl = request.params("id");
			int idUsuario = Integer.valueOf(idUrl);
			usuarioService.excluir(idUsuario);
			response.type("application/json");
			response.status(200);
			return "Usuario deletado com sucesso!";
		});
	}
}
