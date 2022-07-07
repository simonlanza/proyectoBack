package com.dh.clinica;

import com.dh.clinica.model.Domicilio;
import com.dh.clinica.model.Paciente;
import com.dh.clinica.service.DomicilioService;
import com.dh.clinica.service.PacienteService;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnit4.class)
@SpringBootTest
public class PacienteServiceTest {
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private DomicilioService domicilioService;

    @BeforeClass
    public static void cargarDataSet() {
        Domicilio domicilio = new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires");
        Paciente paciente = new Paciente("Santiago", "Paz", "88888888", new Date(), domicilio);
        Domicilio domicilio1 = new Domicilio("Av Avellaneda", "333", "CABA", "Buenos Aires");
        Paciente paciente1 = new Paciente("Micaela", "Perez", "99999999", new Date(), domicilio);
    }

    @Test
    public void agregarYBuscarPacienteTest() {
        Domicilio domicilio = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
        Paciente paciente = new Paciente("Isabela", "Acosta", "12341234", new Date(2022-06-06), domicilio);
        pacienteService.save(paciente);

        Assert.assertNotNull(pacienteService.getById(paciente.getId()));
    }

    @Test
    public void eliminarPacienteTest() {
        pacienteService.delete(3);
        Assert.assertTrue(pacienteService.getById(3) == null);

    }

    @Test
    public void traerTodos() {
        List<Paciente> pacientes = pacienteService.searchAll();
        Assert.assertTrue(!pacientes.isEmpty());
        Assert.assertTrue(pacientes.size() > 0);
        System.out.println(pacientes);
    }


}
