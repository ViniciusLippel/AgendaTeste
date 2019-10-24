package PackAgenda;

import java.io.IOException;
import java.net.MalformedURLException;

public class MainTeste {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		PersistenciaJson json = new PersistenciaJson();
		Persistencia per = new Persistencia(json);
		json.importar();
	}

}
