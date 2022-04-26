package br.com.uniara.avaliacao_1.avaliacao_1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uniara.avaliacao_1.avaliacao_1.model.Empregado;
import br.com.uniara.avaliacao_1.avaliacao_1.repository.EmpregadoRepository;

@Service
public class EmpregadoServiceImpl implements EmpregadoService {
	
	@Autowired
	private EmpregadoRepository empregadoRepository;
	
	@Override
	public List<Empregado> getEmpregados() {
		return empregadoRepository.findAll();
	}

	@Override
	public void salvarEmpregado(Empregado empregado) {
		this.empregadoRepository.save(empregado);		
	}

	@Override
	public Empregado getEmpregadoById(long id) {
		Optional<Empregado> opcao = empregadoRepository.findById(id);
		Empregado empregado = null;
		if(opcao.isPresent()) {
			empregado = opcao.get();
		} else {
			throw new RuntimeException("O ID" + id + "do Empregado não foi localizado!!!");
		}
		return empregado;
	}

	@Override
	public void apagarEmpregadoById(long id) {
		this.empregadoRepository.deleteById(id);
	}
}
