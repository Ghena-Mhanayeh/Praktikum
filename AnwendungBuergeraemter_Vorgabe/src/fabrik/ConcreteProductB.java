package fabrik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductB extends Product{
	BufferedReader ein;
	@Override
	public String[] leseAusDatei() throws IOException {
		 ein = new BufferedReader(new FileReader("Sportverein.txt"));
		 
		 String [] ergebniszeile= new String[5];
		 String zeile = ein.readLine();
		 int i = 0;
		 while( i< ergebniszeile.length) {
			 ergebniszeile[i] = zeile; 
			 zeile = ein.readLine();
			 i++;
		 }
		return ergebniszeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		// TODO Auto-generated method stub
		ein.close();
	}

}
