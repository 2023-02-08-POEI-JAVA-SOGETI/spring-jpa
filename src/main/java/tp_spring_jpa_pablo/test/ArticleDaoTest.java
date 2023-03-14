package tp_spring_jpa_pablo.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tp_spring_jpa_pablo.dao.ArticleDao;
import tp_spring_jpa_pablo.model.Article;

public class ArticleDaoTest {
	@Test
    public void testSave() {
		ArticleDao articleDao = new ArticleDao();
		Article article = new Article();
		Article savedArticle = articleDao.merge(article);
		Assertions.assertNotNull(savedArticle.getId());		
    }	
}
