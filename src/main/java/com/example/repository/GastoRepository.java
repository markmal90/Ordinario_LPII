package com.example.repository;

import com.example.model.Gasto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class GastoRepository {
    private List<Gasto> gastos = new ArrayList<>();
	private ObjectMapper objectMapper = new ObjectMapper();
	private File file = new File("src/main/resources/data.json");

		public GastoRepository() {
			try {
				Gasto[] gastosArray = ObjetMapper.readValue(file, Gasto);
					for (Gasto gasto: gastosArray){
					gastos.add(gasto);
					}


			}catch (IOException e){
				e.printStackTrace();
			}
		}
		}
