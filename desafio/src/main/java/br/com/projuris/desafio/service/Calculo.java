package br.com.projuris.desafio.service;

import br.com.projuris.desafio.model.CustoCargo;
import br.com.projuris.desafio.model.CustoDepartamento;
import br.com.projuris.desafio.model.Funcionario;

import java.util.List;

public interface Calculo {

    List<CustoCargo> custoPorCargo(List<Funcionario> funcionarios);

    List<CustoDepartamento> custoPorDepartamento(List<Funcionario> funcionarios);
}
