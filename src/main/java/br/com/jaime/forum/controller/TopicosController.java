package br.com.jaime.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jaime.forum.controller.dto.TopicoDto;
import br.com.jaime.forum.modelo.Topico;
import br.com.jaime.forum.repository.TopicoRepository;

@RestController
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;
	
	@RequestMapping("/topicos")
	public List<TopicoDto> lista(String nomeCurso) {
		
		if (nomeCurso == null) {
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoDto.converter(topicos);
		} else {
			
			// @Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")
	        //List<Topico> carregarPorNomeDoCurso(@Param("nomeCurso")String nomeCurso);
			
			List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
			return TopicoDto.converter(topicos);
		}
		
	}
	
}
