package br.com.uniara.avaliacao_1.avaliacao_1.service;

import java.util.List;

import br.com.uniara.avaliacao_1.avaliacao_1.model.Empregado;

public interface EmpregadoService {
	List<Empregado> getEmpregados();
	void salvarEmpregado(Empregado empregado);
	Empregado getEmpregadoById(long id);
	void apagarEmpregadoById(long id);
}
