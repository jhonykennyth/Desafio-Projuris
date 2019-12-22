package br.com.projuris.desafio.service.impl;

import br.com.projuris.desafio.model.CustoCargo;
import br.com.projuris.desafio.model.CustoDepartamento;
import br.com.projuris.desafio.model.Funcionario;
import br.com.projuris.desafio.service.Calculo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Map.Entry;

@Service
public class MyCalculo implements Calculo {

    @Override
    public List<CustoCargo> custoPorCargo(List<Funcionario> funcionarios) {
        List<CustoCargo> custoCargoList = new ArrayList<>();
        Map<String, BigDecimal> result = new HashMap<>();
        for (Funcionario funcionario : funcionarios) {
            if (result.containsKey(funcionario.getCargo())) {
                BigDecimal salario = funcionario.getSalario().add(result.get(funcionario.getCargo()));
                result.put(funcionario.getCargo(), salario);
            } else {
                result.put(funcionario.getCargo(), funcionario.getSalario());
            }
        }
        for (Entry entry : result.entrySet()) {
            custoCargoList.add(new CustoCargo(entry.getKey().toString(),
                    ((BigDecimal) entry.getValue()).setScale(2, RoundingMode.HALF_EVEN)));
        }
        return custoCargoList;
    }

    @Override
    public List<CustoDepartamento> custoPorDepartamento(List<Funcionario> funcionarios) {
        List<CustoDepartamento> custoDepartamentoList = new ArrayList<>();
        Map<String, BigDecimal> result = new HashMap<>();
        for (Funcionario funcionario : funcionarios){
            if( result.containsKey(funcionario.getDepartamento())){
                BigDecimal salario = funcionario.getSalario().add(result.get(funcionario.getDepartamento()));
                result.put(funcionario.getDepartamento(),salario);
            }else {
                result.put(funcionario.getDepartamento(),funcionario.getSalario());
            }
        }
        for (Entry entry : result.entrySet()) {
            custoDepartamentoList.add(new CustoDepartamento(entry.getKey().toString(),
                    ((BigDecimal) entry.getValue()).setScale(2, RoundingMode.HALF_EVEN)));
        }
         return custoDepartamentoList;
    }
}
