package com.bigcorp.booking.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.bigcorp.booking.model.HerosFilms;

/**
 * Un Singleton gérant les heros
 */
public class FilmSingleton{
	
	public static final FilmSingleton INSTANCE = new FilmSingleton();
	
	private Map<Integer, HerosFilms> herosFilm = new HashMap<>();
	
	private FilmSingleton() {
		this.herosFilm.put(1, new HerosFilms(1, "Simba", "Le Roi Lion"));
		this.herosFilm.put(2, new HerosFilms(2, "Leeloo", "Le 5ème Element"));
		this.herosFilm.put(3, new HerosFilms(3, "John Cafe", "La Ligne Verte"));
		this.herosFilm.put(4, new HerosFilms(4, "Forest", "Forest Gump"));
		this.herosFilm.put(5, new HerosFilms(5, "Sarah Connor", "Terminator"));
		this.herosFilm.put(6, new HerosFilms(6, "Quasimodo", "Le Bossu de Notre Dame"));
		this.herosFilm.put(7, new HerosFilms(7, "Cooper", "Interstellar"));
		this.herosFilm.put(8, new HerosFilms(8, "Victoire", "La Boum"));
	}
	
	/**
	 * Renvoie un heros par son identifiant
	 * @param id
	 * @return
	 */
	public HerosFilms getHerosFilmById(Integer id) {
		return this.herosFilm.get(id);
	}
	
	/**
	 * Renvoie toutes les heros
	 * @return
	 */
	public Collection<HerosFilms> getAllHeros(){
		return new ArrayList<>(this.herosFilm.values());
	}

	/**
	 * Sauvegarde ce heros. Ne fait rien si 
	 * heros == null ou si heros.getId() == null
	 * @param heros
	 */
	public void saveHerosFilm(HerosFilms herosFilm) {
		if(herosFilm != null
				&& herosFilm.getId() != null) {
			this.herosFilm.put(herosFilm.getId(), herosFilm);			
		}
	}
	
	
}