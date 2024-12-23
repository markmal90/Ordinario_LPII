package com.example.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.model.Gasto;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GastoRepository {
    private List<Gasto> gastos = new ArrayList<>();
	private ObjectMapper objectMapper = new ObjectMapper();
	private File file = new File("src/main/resources/data.json");

    @SuppressWarnings("CallToPrintStackTrace")
		public GastoRepository() {
			try {
				Gasto[] gastosArray = objectMapper.readValue(file, Gasto[].class);
					for (Gasto gasto: gastosArray){
					gastos.add(gasto);
					}


			}catch (IOException e){
				e.printStackTrace();
			}
		}
		
		public List<Gasto> getAll(){
			return gastos;
		}

		public Optional<Gasto> getById(int id) {
			return gastos.stream().filter(g-> g.getId()== id).findFirst();
		}

		public void add(Gasto gasto){
			gastos.add(gasto);
			saveToFile();
		}

		public void update(Gasto gasto) {
			getById(gasto.getId()).ifPresent(existingGasto ->{
				existingGasto.setDescripcion(gasto.getDescripcion());
				existingGasto.setFecha(gasto.getFecha());
				existingGasto.setMonto(gasto.getMonto());
				saveToFile();
			});
		}
		public void delete(int id){
			gastos.removeIf(g -> g.getId()== id);
		}
		public double getAverage(){
			return gastos.stream().mapToDouble(Gasto::getMonto).average().orElse(0);

		}
		public List<Gasto> getByDateRange(long fechaInicio, long fechaFin){
			return gastos.stream()
				.filter(g -> g.getFecha() >= fechaInicio && g.getFecha() <= fechaFin)
				.collect(Collectors.toList());
		}
		private void saveToFile(){
			try {
				objectMapper.writeValue(file, gastos);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}