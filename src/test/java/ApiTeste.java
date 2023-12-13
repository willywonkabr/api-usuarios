import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class ApiTeste {
	@Test
	public void apiTeste() throws IOException {
		URL apiUrl = new URL("http://localhost:4567/usuarios");
		HttpURLConnection conexao = (HttpURLConnection) apiUrl.openConnection();
		conexao.setRequestMethod("GET");
		int codigoRespostaHttp = conexao.getResponseCode();
		assertEquals(200, codigoRespostaHttp);
	}
}
