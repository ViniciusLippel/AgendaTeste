package PackAgenda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
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
		
        ListaPessoa list = new ListaPessoa();
		try {
			BufferedReader br = new BufferedReader(new FileReader("agenda.json"));
			String str = br.lines().collect(Collectors.joining());
			String strbr = str.replace("][", ",");
			Reader reader = new StringReader(strbr);
			br = new BufferedReader(reader);
			list = gson.fromJson(br, ListaPessoa.class);
		}
			catch (Exception e) {
	            e.printStackTrace();
			}
		return list.getPessoas();
	}
	
}


