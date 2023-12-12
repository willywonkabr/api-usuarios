package service;

import dto.UsuarioDTOInput;
import dto.UsuarioDTOOutput;
import model.Usuario;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UsuarioService {
	private final List<Usuario> listaUsuarios = new ArrayList<>();
	private final ModelMapper modelMapper = new ModelMapper();
	public List<UsuarioDTOOutput> listar() {
		List<UsuarioDTOOutput> usuarioDTOOutputLista = modelMapper.map(listaUsuarios, List.class);
		return usuarioDTOOutputLista;
	}
	public UsuarioDTOOutput buscar(int id) {
		UsuarioDTOOutput usuarioDTOOutput = modelMapper.map(listaUsuarios.get(id), UsuarioDTOOutput.class);
		return usuarioDTOOutput;
	}
	public void inserir(UsuarioDTOInput usuarioDTOInput) {
		Usuario usuario = modelMapper.map(usuarioDTOInput, Usuario.class);
		listaUsuarios.add(usuario);
	}
	public void alterar(UsuarioDTOInput usuarioDTOInput) {
		Usuario usuario = modelMapper.map(usuarioDTOInput, Usuario.class);
		listaUsuarios.set(usuarioDTOInput.getId(), usuario);
	}
	public void excluir(int id) {
		listaUsuarios.remove(id);
	}
}
