package PackAgenda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;




public class PersistenciaJson implements Igravacao{

	@Override
	public boolean gravar(List<Pessoa> list) {
		ListaPessoa l = new ListaPessoa();
		l.setPessoas(list);
		try {
			GsonBuilder builder = new GsonBuilder();

			Gson gson = builder.create();

			FileWriter writer = new FileWriter("agenda.json", true);

			writer.write(gson.toJson(l,ListaPessoa.class));

			writer.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} 
		return true;
	}

	@Override
	public List<Pessoa> ler() {
		Gson gson = new Gson();
		
        ListaPessoa obj = new ListaPessoa();
		try {
			BufferedReader br = new BufferedReader(new FileReader("agenda.json"));
			obj = gson.fromJson(br, ListaPessoa.class);
		}
			catch (Exception e) {
	            e.printStackTrace();
			}
		return obj.getPessoas();
	}
	
	public void importar() throws MalformedURLException, IOException {
		Gson gson = new Gson();
		
//		String caminho="http://www.curvello.com/gerador/pessoa/10";
		InputStream is = new URL("http://www.curvello.com/gerador/pessoa/10").openStream();
//        ListaPessoa list = new ListaPessoa();
		List<Pessoa> list = new ArrayList<Pessoa>();
        try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
//			list = gson.fromJson(br, ListaPessoa.class);
			Type collectionType = new TypeToken<Collection<Pessoa>>(){}.getType();
			list = gson.fromJson(br, collectionType);
		}catch (Exception e) {
			e.printStackTrace();
		}
        
        gravar(list);
        
//        for(Pessoa p : list) {
//        	System.out.println(p.getTelefone());
//        }
	}
	
}


