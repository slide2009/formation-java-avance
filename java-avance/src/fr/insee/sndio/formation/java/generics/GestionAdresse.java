package fr.insee.sndio.formation.java.generics;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import fr.insee.sndio.formation.java.model.Adresse;
import fr.insee.sndio.formation.java.model.Point;

public class GestionAdresse< T extends Adresse>  {
	// Cette méthode traite Adresse et ses sous classes
	public Point getPointFromXy(T adresse) {
		Point point = new Point();
		String [] tableauCoord = adresse.getXy().substring(1).split("x");							
		point.setX(Double.valueOf(tableauCoord[0].replace(",", ".")));
		point.setY(Double.valueOf(tableauCoord[1].replace(",", ".").replace(";", "")));		
		return point;
	}
	
	public Map<Long, Set<String>> mapperIdXy(List< ? extends Adresse> liste) {
		
		return liste.stream().collect(Collectors.groupingBy(
				adresse -> adresse.getVoie().getId(),
				Collectors.mapping(Adresse::getXy, Collectors.toSet())
				));
	}
}