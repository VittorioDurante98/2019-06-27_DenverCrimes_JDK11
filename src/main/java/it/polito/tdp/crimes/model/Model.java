package it.polito.tdp.crimes.model;

import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.crimes.db.EventsDAO;

public class Model {
	
	private EventsDAO dao;
	private Graph<String, DefaultWeightedEdge> grafo;
	
	public Model() {
		this.dao = new EventsDAO();
	}
	
	public void creaGrafo(int anno, String categoria) {
		this.grafo = new SimpleWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		Graphs.addAllVertices(grafo, dao.listaVertici(anno, categoria));
		
	}
	
	public List<String> getReati(){
		return dao.listaReati();
	}

	public List<Integer> getAnni(){
		return dao.listAnni();
	}
}
