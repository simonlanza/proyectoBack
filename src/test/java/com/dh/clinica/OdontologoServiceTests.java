package com.dh.clinica;

import com.dh.clinica.controller.OdontologoController;
import com.dh.clinica.model.Odontologo;
import com.dh.clinica.service.OdontologoService;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnit4.class)
@SpringBootTest
public class OdontologoServiceTests {
    @Autowired
    OdontologoController odontologoController;

    @Test
    public void guardarOdontologo() {
        Odontologo o = new Odontologo("isa", "acosta", 123123);
        odontologoController.save(o);
        Assert.assertNotNull(odontologoController.getById(1).getBody());
    }

    @Test
    public void eliminarPacienteTest() {
        odontologoController.delete(1);
        Assert.assertTrue(odontologoController.getById(1) == null);

    }

    @Test
    public void traerTodos() {
        odontologoController.searchAll();
        Assert.assertNotNull(odontologoController.searchAll().getBody());
    }

}
