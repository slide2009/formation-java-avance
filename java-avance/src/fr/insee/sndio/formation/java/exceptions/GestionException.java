package fr.insee.sndio.formation.java.exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GestionException {
	private List<Integer> listeNombre;

	public GestionException () {
		listeNombre = new ArrayList<>();
		listeNombre.add(1);
		listeNombre.add(2);
		listeNombre.add(3);
		listeNombre.add(0);
	}

	public void lireNombre(int index) {
		try {			
			System.out.println("Le nombre en position " + index + " est :  " + listeNombre.get(index));
			System.out.println("Le résultat de l'index divisé par ce nombre :  " 
					+ index/listeNombre.get(index));
		}
		catch (IndexOutOfBoundsException | ArithmeticException e) {
			e.printStackTrace();
		}
//		catch (ArithmeticException e) {
//			e.printStackTrace();
//		}
		// éventuellement :
		finally {
			System.out.println("Fin de l'exécution");
		}	
	}
	
	public void lireFichierTexte () throws IOException  { //pour l'exemple, pas à faire
		Path path = Paths.get("C:\\Users\\kivt18\\Documents\\data\\data.txt");		
		BufferedReader bufferedReader = Files.newBufferedReader(path);
		String ligne = bufferedReader.readLine();
		while(ligne != null) {
			System.out.println(ligne);
			ligne = bufferedReader.readLine();
		}		
		bufferedReader.close();
	}
	
}