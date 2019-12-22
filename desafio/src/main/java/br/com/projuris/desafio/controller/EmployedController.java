package br.com.projuris.desafio.controller;

import br.com.projuris.desafio.model.CustoCargo;
import br.com.projuris.desafio.model.CustoDepartamento;
import br.com.projuris.desafio.model.Funcionario;
import br.com.projuris.desafio.service.Calculo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("employed")
public class EmployedController {

    private Calculo calculo;

    public EmployedController(Calculo calculo) {
        this.calculo = calculo;
    }

    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public List<CustoDepartamento> getByDepartment() {
        return calculo.custoPorDepartamento(getEmployed());
    }

    @RequestMapping(value = "/office", method = RequestMethod.GET)
    public List<CustoCargo> getByOffice() {
        return calculo.custoPorCargo(getEmployed());
    }

    private List<Funcionario> getEmployed () {
        List<Funcionario> listaFuncionario = new ArrayList<>();
        listaFuncionario.add(new Funcionario("Assistente", "Administrativo", new BigDecimal(1000.60)));
        listaFuncionario.add(new Funcionario("Gerente", "Administrativo", new BigDecimal(7000.70)));
        listaFuncionario.add(new Funcionario("Diretor", "Administrativo", new BigDecimal(10000.45)));
        listaFuncionario.add(new Funcionario("Assistente", "Financeiro", new BigDecimal(1300.90)));
        listaFuncionario.add(new Funcionario("Gerente", "Financeiro", new BigDecimal(7500.25)));
        listaFuncionario.add(new Funcionario("Estagiário", "Financeiro", new BigDecimal(1100.40)));
        listaFuncionario.add(new Funcionario("Estagiário", "Jurídico", new BigDecimal(700.40)));
        listaFuncionario.add(new Funcionario("Assistente", "Jurídico", new BigDecimal(1800.90)));
        listaFuncionario.add(new Funcionario("Gerente", "Jurídico", new BigDecimal(9500.50)));
        listaFuncionario.add(new Funcionario("Diretor", "Jurídico", new BigDecimal(13000.45)));
        return listaFuncionario;
    }
}
