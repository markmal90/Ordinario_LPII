package com.example.repository;

import com.example.model.Gasto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.collectors;


public class GastoRepository {
    private List<Gasto> gastos = new ArrayList<>();
	private ObjetMapper objectMapper = new ObjectMapper();
	private File file = new File("sec/main/resources/data.json");

		public GastoRepository {
			try {
				Gasto[] gastosArray = ObjetMapper.readValue(file, Gasto)
    
}