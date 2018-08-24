package br.com.pratica.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.logging.Level;

public class Main {
	
	public static void main(String[] args) {
		JSONObject jSONObject;
		JSONParser parser = new JSONParser();
		
		Pessoa pessoa = new Pessoa();
		
	
		try {
			jSONObject = (JSONObject) parser.parse(new FileReader("dados.json"));
			pessoa.setNome((String) jSONObject.get("nome"));
			pessoa.setSobreNome((String) jSONObject.get("sobreNome"));
			
			System.out.println("Pessoa Recuperada do JSON = " + pessoa.toString());
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}catch(ParseException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
