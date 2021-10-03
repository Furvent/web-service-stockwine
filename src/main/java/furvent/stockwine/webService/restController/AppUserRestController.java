package furvent.stockwine.webService.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import furvent.stockwine.webService.restController.DTO.create.LoginForm;
import furvent.stockwine.webService.service.interfaces.AppUserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/login", headers = "Accept=application/json")
public class AppUserRestController {
	
	@Autowired
	AppUserService appUserService;
	
	@PostMapping("")
	public ResponseEntity<?> login(@RequestBody LoginForm loginForm) {
		try {
			if (appUserService.login(loginForm.getUsername(), loginForm.getPassword())) {
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
