package com.doctor.bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
	/**
	 * Charge la liste des propriétés contenu dans le fichier spécifié
	 * 
	 * @param filename
	 *            le fichier contenant les propriétés
	 * @return un objet Properties contenant les propriétés du fichier
	 */
	public static Properties load(String filename) throws IOException,
			FileNotFoundException {
		Properties properties = new Properties();
		FileInputStream input = new FileInputStream(filename);
		try {
			properties.load(input);
			return properties;
		} finally {
			input.close();
		}
	}

	public static void main(String[] args) {
		try {
			// chargement des propriétés Mrs2aWorkspace
		//	Properties prop = PropertyLoader.load("..\\p.properties");
			// Affichage des propriétés
			// Récupère la propriété ma.cle
			// Si la propriété n'existe pas, retourne la valeur par défaut
			// "vide"
		//	System.out.println("ma.cle: " + prop.getProperty("nbl"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}