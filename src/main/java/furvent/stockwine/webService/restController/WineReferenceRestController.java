package furvent.stockwine.webService.restController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import furvent.stockwine.webService.entity.WineReference;
import furvent.stockwine.webService.restController.DTO.read.WineReferenceDTO;
import furvent.stockwine.webService.service.interfaces.WineReferenceService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/wine-reference", headers = "Accept=application/json")
public class WineReferenceRestController {

	@Autowired
	WineReferenceService wineReferenceService;

	/**
	 * 
	 * @param name Optional, can performs a research by name to get all matching
	 *             elements.
	 * @return A list of wine references.
	 */
	@GetMapping("")
	public ResponseEntity<?> getAllWineReferences(@RequestParam(required = false) String name) {
		List<WineReference> wineReferencesList;
		try {
			if (name != null) {
				wineReferencesList = wineReferenceService.getAllWineReferencesByName(name);
			} else {
				wineReferencesList = wineReferenceService.getAllWineReference();
			}
			List<WineReferenceDTO> wineReferencesDTOList = wineReferencesList.stream()
					.map(wineReference -> new WineReferenceDTO(wineReference)).collect(Collectors.toList());
			return new ResponseEntity<List<WineReferenceDTO>>(wineReferencesDTOList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{publicId}")
	public ResponseEntity<?> getWineReference(@PathVariable String publicId) {
		try {
			Optional<WineReference> optionalWineReferenceEntity = wineReferenceService
					.getWineReferenceByPublicId(publicId);
			if (optionalWineReferenceEntity.isEmpty())
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<WineReferenceDTO>(new WineReferenceDTO(optionalWineReferenceEntity.get()),
						HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
