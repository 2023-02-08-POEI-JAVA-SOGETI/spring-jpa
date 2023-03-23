package com.bigcorp.booking.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.bigcorp.booking.model.HerosDisney;

/**
 * Un Singleton gérant les planètes
 */
public class DisneySingleton{
	
	public static final DisneySingleton INSTANCE = new DisneySingleton();
	
	private Map<Integer, HerosDisney> herosDisney = new HashMap<>();
	
	private DisneySingleton() {
		this.herosDisney.put(1, new HerosDisney(1, "Boo", "Monstres et Cie"));
		this.herosDisney.put(2, new HerosDisney(2, "Mulan", "Mulan"));
		this.herosDisney.put(3, new HerosDisney(3, "Kida", "Atlantide l'Empire Perdu"));
		this.herosDisney.put(4, new HerosDisney(4, "Jim", "La Planete au Trésor"));
	}
	
	/**
	 * Renvoie un heros par son identifiant
	 * @param id
	 * @return
	 */
	public HerosDisney getHerosDisneyById(Integer id) {
		return this.herosDisney.get(id);
	}
	
	/**
	 * Renvoie toutes les heros
	 * @return
	 */
	public Collection<HerosDisney> getAllHeros(){
		return new ArrayList<>(this.herosDisney.values());
	}

	/**
	 * Sauvegarde ce heros. Ne fait rien si 
	 * heros == null ou si heros.getId() == null
	 * @param heros
	 */
	public void saveHerosDisney(HerosDisney herosDisney) {
		if(herosDisney != null
				&& herosDisney.getId() != null) {
			this.herosDisney.put(herosDisney.getId(), herosDisney);			
		}
	}
	
	
}