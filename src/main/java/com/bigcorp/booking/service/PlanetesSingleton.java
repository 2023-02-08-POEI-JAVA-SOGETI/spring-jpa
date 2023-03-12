package com.bigcorp.booking.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.bigcorp.booking.model.Planete;

/**
 * Un Singleton gérant les planètes
 */
public class PlanetesSingleton{
	
	public static final PlanetesSingleton INSTANCE = new PlanetesSingleton();
	
	private Map<Integer, Planete> planetes = new HashMap<>();
	
	private PlanetesSingleton() {
		this.planetes.put(1, new Planete(1, "Mercure", 1000));
		this.planetes.put(2, new Planete(2, "Terre", 2000));
		this.planetes.put(3, new Planete(3, "Mars", 1500));
		this.planetes.put(4, new Planete(4, "Jupiter", 2_000_000));
	}
	
	/**
	 * Renvoie une planète par son identifiant
	 * @param id
	 * @return
	 */
	public Planete getPlaneteById(Integer id) {
		return this.planetes.get(id);
	}
	
	/**
	 * Renvoie toutes les planètes
	 * @return
	 */
	public Collection<Planete> getAllPlanetes(){
		return new ArrayList<>(this.planetes.values());
	}

	/**
	 * Sauvegarde cette planète. Ne fait rien si 
	 * planete == null ou si planete.getId() == null
	 * @param planete
	 */
	public void savePlanete(Planete planete) {
		if(planete != null
				&& planete.getId() != null) {
			this.planetes.put(planete.getId(), planete);			
		}
	}
	
	
}