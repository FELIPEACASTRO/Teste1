package br.com.campanha.restful.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.campanha.restful.model.Campanha;
import br.com.campanha.restful.service.CampanhaService;

@RestController
@RequestMapping("/campanha")
public class CampanhaController {
	
	
	final static Logger logger = Logger.getLogger(CampanhaController.class);

	@Autowired
	CampanhaService campService;


	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Campanha> addCampanha(@RequestBody Campanha campanha) {
		campService.save(campanha);
		logger.debug("Added:: " + campanha);
		return new ResponseEntity<Campanha>(campanha, HttpStatus.CREATED);
	}


	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> updateCampanha(@RequestBody Campanha campanha) {
		Campanha existingCamp = campService.getById(campanha.getId());
		if (existingCamp == null) {
			logger.debug("Campanha id " + campanha.getId() + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			campService.save(campanha);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Campanha> getCampanha(@PathVariable("id") Long id) {
		Campanha campanha = campService.getById(id);
		if (campanha == null) {
			logger.debug("Campanha id " + id + " does not exists");
			return new ResponseEntity<Campanha>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Found Campanha:: " + campanha);
		return new ResponseEntity<Campanha>(campanha, HttpStatus.OK);
	}


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Campanha>> getAllCampanhas() {
		List<Campanha> campanhas = campService.getAll();
		if (campanhas.isEmpty()) {
			logger.debug("Campanha does not exists");
			return new ResponseEntity<List<Campanha>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + campanhas.size() + " Campanhas");
		logger.debug(Arrays.toString(campanhas.toArray()));
		return new ResponseEntity<List<Campanha>>(campanhas, HttpStatus.OK);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCampanha(@PathVariable("id") Long id) {
		Campanha campanha = campService.getById(id);
		if (campanha == null) {
			logger.debug("Campanha id " + id + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			campService.delete(id);
			logger.debug("Campanha with id " + id + " deleted");
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}

}
