package PackAgenda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Importacao {
	
	public void importar() throws MalformedURLException, IOException {
		PersistenciaJson pJson = new PersistenciaJson();
		Gson gson = new Gson();
		InputStream is = new URL("http://www.curvello.com/gerador/pessoa/10").openStream();
		List<Pessoa> list = new ArrayList<Pessoa>();
        try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			Type collectionType = new TypeToken<Collection<Pessoa>>(){}.getType();
			list = gson.fromJson(br, collectionType);
		}catch (Exception e) {
			e.printStackTrace();
		}
        
        pJson.gravar(list);
        
	}
	
	public void sincronizar() {
		PersistenciaJson json = new PersistenciaJson();
		PersistenciaXML xml = new PersistenciaXML();
		PersistenciaCSV csv = new PersistenciaCSV();
		List<Pessoa> list = json.ler();
		
		xml.gravar(list);
		csv.gravar(list);
	}
}
