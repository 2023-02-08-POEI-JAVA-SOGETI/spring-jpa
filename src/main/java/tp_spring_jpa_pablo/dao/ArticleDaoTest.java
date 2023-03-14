package tp_spring_jpa_pablo.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArticleDaoTest {
	@Test
    public void testSave() {
		ArticleDao articleDao = new ArticleDao();
		Article article = new Article();
		Article savedArticle = articleDao.merge(article);
		Assertions.assertNotNull(savedArticle.getId());		
    }
	
}
