package br.com.campanha.restful.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.campanha.restful.model.Campanha;
import br.com.campanha.restful.repository.CampanhaRepository;


@Service
public class DefaultCampanhaService implements CampanhaService {
	
	
	@Autowired
	private CampanhaRepository campanhaRepository;

	@Override
	public Campanha save(Campanha entity) {
		return campanhaRepository.save(entity);
	}

	@Override
	public Campanha getById(Serializable id) {
		return campanhaRepository.findOne((Long) id);
	}

	@Override
	public List<Campanha> getAll() {
		return campanhaRepository.findAll();
	}

	@Override
	public void delete(Serializable id) {
		campanhaRepository.delete((Long) id);
	}



}
