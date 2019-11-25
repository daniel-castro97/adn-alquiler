package com.ceiba.alquiler.integracion;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.alquiler.AlquilerApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AlquilerApplication.class)
@AutoConfigureMockMvc
@Transactional
public class MotoControllerTest {

}
