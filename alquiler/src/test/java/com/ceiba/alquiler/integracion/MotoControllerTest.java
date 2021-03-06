package com.ceiba.alquiler.integracion;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.ceiba.alquiler.AlquilerApplication;
import com.ceiba.alquiler.aplicacion.comando.ComandoMoto;
import com.ceiba.alquiler.dataBuilder.ComandoMotoTestDatabuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AlquilerApplication.class)
@AutoConfigureMockMvc
@Transactional
public class MotoControllerTest {
	
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Before
	public void setup() throws Exception {
	this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	@Test
	public void crear() throws Exception{
		ComandoMoto moto =  new ComandoMotoTestDatabuilder().build();
		mockMvc.perform(post("/service/moto/crear").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(moto))).andExpect(status().isOk());
	}
	@Test
	public void listar () throws Exception{
		crear();
		mockMvc.perform(get("/service/moto/lista-motos").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(1)))
		.andExpect(jsonPath("$[0].placa", is("rhd79e")));
	}

}
