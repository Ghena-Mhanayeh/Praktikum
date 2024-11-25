package fabrik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import business.Sportverein;

public class ConcreteProduct extends Product {

	BufferedReader ein;
	@Override
	public String[] leseAusDatei() throws IOException {
		 ein = new BufferedReader(new FileReader("Sportverein.csv"));
			String[] zeile = ein.readLine().split(";");
			
		return zeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		ein.close();
		// TODO Auto-generated method stub
		
	}

}
