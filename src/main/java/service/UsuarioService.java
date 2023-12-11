package service;

import dto.UsuarioDTOInput;
import dto.UsuarioDTOOutput;
import model.Usuario;
import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.List;

public class UsuarioService {
	List<Usuario> listaUsuarios;

	private final ModelMapper modelMapper = new ModelMapper();

	public List<UsuarioDTOOutput> listar() {
		List<UsuarioDTOOutput> usuarioDTOOutputLista = modelMapper.map(listaUsuarios, List.class);
		return usuarioDTOOutputLista;
	}

	public UsuarioDTOOutput buscar(int id) {
		// caso exista um usuario com esse id dentro da lista,
		// pegar esse objeto usuario e converter em usuarioDTOInput com a biblioteca ModelMapper
		// retornar esse objeto recem convertido
		UsuarioDTOOutput usuarioDTOOutput = modelMapper.map(listaUsuarios.get(id), UsuarioDTOOutput.class);
		return usuarioDTOOutput;
	}

	public void inserir(UsuarioDTOInput usuarioDTOInput) {
		// usar biblioteca ModelMapper para converter o ususarioDTOInput em um objeto da classe Usuario
		// adicionar o objeto usuario recem convertido na listaUsuarios
		Usuario usuario = modelMapper.map(usuarioDTOInput, Usuario.class);
		listaUsuarios.add(usuario);
	}

	public void alterar(UsuarioDTOInput usuarioDTOInput) {
		// usar biblioteca ModelMapper para converter o ususarioDTOInput em um objeto da classe Usuario
		// substituir o objeto usuario recem convertido na listaUsuarios
		Usuario usuario = modelMapper.map(usuarioDTOInput, Usuario.class);
		//listaUsuarios.replaceAll(usuario);
		listaUsuarios.set(usuarioDTOInput.getId(), usuario);
	}

	public void excluir(int id) {
		// buscar dentro da listaUsuarios um objeto com esse id e remover
		listaUsuarios.remove(id);
	}
}
