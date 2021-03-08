package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultigraphTest {
	
	@BeforeEach
	void setUp() {
	}
	
	@AfterEach
	void tearDown() {
	}
	
	/*
		addNode(N n) cases:
		general case (add legit node, should return true)
		duplicate node (add node with same id as another, should return false)
	*/
	@Test
	void addNode() {
	}
	
	/*
		addEdge(E e) cases:
		general case (add edge between two existing nodes in the graph), should return true
		illegal edge (edge between one or more nonexistent nodes) should return false
	*/
	@Test
	void addEdge() {
	}
	
	/*
		findRoute(int src, int dest) cases:
		general case (initialise a small multigraph with enough nodes and edges to form a route, then verify that the returned route is correct)
		no route (try to find a route between nodes which we know there are not edges connecting them, verify that null is returned)
		nonexistent nodes (try to find a route between nodes that do not exist in the graph, verify that null is returned)
	*/
	@Test
	void findRoute() {
	}
	
	/*
		getStations() cases:
		no nodes: call getStations on a fresh multigraph with no nodes
		general case: initialise a multigraph and add x y z nodes, verify that these nodes and no others are returned in the list
	*/
	@Test
	void getStations() {
	}
}