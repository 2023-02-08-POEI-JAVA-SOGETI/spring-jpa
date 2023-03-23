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
		this.herosDisney.put(1, new HerosDisney(1, "Kuzco", "Kuzco l'empereur mégalo"));
		this.herosDisney.put(2, new HerosDisney(2, "Simba", "Le Roi Lion"));
		this.herosDisney.put(3, new HerosDisney(3, "Aurore", "La Belle Au Bois Dormant"));
		this.herosDisney.put(4, new HerosDisney(4, "Merida", "Rebelle"));
		this.herosDisney.put(5, new HerosDisney(5, "Megara", "Hercule"));
		this.herosDisney.put(6, new HerosDisney(6, "Quasimodo", "Le Bossu de Notre Dame"));
		this.herosDisney.put(7, new HerosDisney(7, "Mirabel", "Encanto"));
		this.herosDisney.put(8, new HerosDisney(8, "Tarzan", "Tarzan"));
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