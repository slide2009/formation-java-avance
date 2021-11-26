package fr.insee.sndio.formation.java.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;

import fr.insee.sndio.formation.java.model.Voie;

public class ReflectionTest {

	@Test
	void reflectionTest() {
		//Afficher tous les champs privés ou non
		
		try {
			Class<?> classe = Class.forName("fr.insee.sndio.formation.java.model.Voie");
			Field[] fields = classe.getDeclaredFields();
			for(int i =0; i < fields.length; i++) {
				System.out.println(fields[i].getName());				
			}
			
			Voie voie = (Voie) classe.getConstructor().newInstance();
			//Voie a un libellé private avec un getter
			Field field = classe.getDeclaredField("libelleCache"); 
			field.setAccessible(true);
			field.set(voie, "Libellé mis via reflection");
			System.out.println(voie.getLibelleCache());
			
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | NoSuchFieldException e) {
			e.printStackTrace();
		}
	}
}
