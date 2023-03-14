package tp_spring_jpa_pablo.dao;


public class Main {

	public static void main(String[] args) {
		// Instantiating the Fournisseur class
        Fournisseur fournisseur = new Fournisseur();
        FournisseurDao fournisseurDao = new FournisseurDao();
        Article article = new Article();
        ArticleDao articleDao = new ArticleDao();

        
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
        
        article.getNom();
        article.getType();
        article.getDescription();
        
        articleDao.merge(article);

	}

}
