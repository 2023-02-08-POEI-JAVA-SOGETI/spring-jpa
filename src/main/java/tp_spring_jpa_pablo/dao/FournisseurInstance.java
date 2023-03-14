package tp_spring_jpa_pablo.dao;


public class FournisseurInstance {

	public static void main(String[] args) {
		// Instantiating the Fournisseur class
        Fournisseur fournisseur = new Fournisseur();
        FournisseurDao fournisseurDao = new FournisseurDao();
        

        
        // Setting the values for the attributes
        // fournisseur.setId(1);
        fournisseur.setNom("Example Inc.");
        fournisseur.setEmail("example@example.com");
        fournisseur.setAdresse("123 Main St.");
        
        // Using the getters to retrieve the values
        System.out.println(fournisseur.getId());
        System.out.println(fournisseur.getNom());
        System.out.println(fournisseur.getEmail());
        System.out.println(fournisseur.getAdresse());
        
        fournisseurDao.merge(fournisseur);

	}

}
