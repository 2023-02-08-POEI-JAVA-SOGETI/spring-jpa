//package rest;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import com.bigcorp.booking.dao.spring.UtilisateurDao;
//import com.bigcorp.booking.model.Utilisateur;
//import com.bigcorp.booking.rest.UtilisateurRestController;
//import com.bigcorp.booking.service.UtilisateurService;
//import com.bigcorp.booking.dto.UtilisateurRestDto;
//
//@ExtendWith(MockitoExtension.class)
//public class UtilisateurRestControllerTest {
//	
//	@InjectMocks
//	UtilisateurRestController utilisateurRestController;
//	
//	@Mock
//	@Autowired
//	UtilisateurService utilisateurService;
//
//	
//	@Test
//	public void testAddUtilisateur() {
//		MockHttpServletRequest request = new MockHttpServletRequest();
//		
//		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//		
//		when(utilisateurService.save(any(Utilisateur.class))).thenReturn(new Utilisateur());
//		
//		Utilisateur utilisateur = new Utilisateur(78, "Brando", "Dio", null, null, null);
//		
//		UtilisateurRestDto utilisateurRestDto = new UtilisateurRestDto(utilisateur);
//		
//		utilisateurRestDto = utilisateurRestController.save(utilisateurRestDto);
//		
//		
//		
//	}
//}
