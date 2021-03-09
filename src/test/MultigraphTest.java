package test;

import main.multigraph.Graph;
import main.multigraph.Multigraph;
import main.multigraph.Rail;
import main.multigraph.Station;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultigraphTest {
	private Multigraph graph;
	private Station statOne;
	private Station statOne_rep;
	private Station statTwo;
	private Station statThree;
	private Station statFour;
	private Station statFive;
	private Rail railOne;
	private Rail railTwo;
	private Rail railThree;
	private Rail railFour;
	private Rail railFive;
	private Rail railSix;


	@BeforeEach
	void setUp() {
		graph = new Multigraph();
		statOne = new Station(1,"One");
		statOne_rep = new Station(1,"One");
		statTwo = new Station(2, "Two");
		statThree = new Station(3, "Three");
		statFour = new Station(4, "Four");
		statFive = new Station(5, "Five");
		railOne = new Rail(1,2,"Good");
		railTwo = new Rail(1,3,"Bad");
		railThree = new Rail(3,2,"Bad");
		railFour = new Rail(3,3,"Bad");
		railFive = new Rail(2,3,"Good");
		railSix = new Rail(4,5, "Bad");

	}
	
	@AfterEach
	void tearDown() {
		graph = null;
		statOne = null;
		statOne_rep = null;
		statTwo = null;
		statThree = null;
		statFour = null;
		statFive = null;
		railOne = null;
		railTwo = null;
		railThree = null;
		railFour = null;
		railFive = null;
		railSix = null;
		assertNull(graph);
		assertNull(statOne);
		assertNull(statOne_rep);
		assertNull(statTwo);
		assertNull(statThree);
		assertNull(statFour);
		assertNull(statFive);
		assertNull(railOne);
		assertNull(railTwo);
		assertNull(railThree);
		assertNull(railFour);
		assertNull(railFive);
		assertNull(railSix);
	}
	
	/*
		addNode(N n) cases:
		general case (add legit node, should return true)
		duplicate node (add node with same id as another, should return false)
	*/
	@Test
	void addNode() {
		assertTrue(graph.addNode(statOne));
		assertFalse(graph.addNode(statOne_rep));
	}
	
	/*
		addEdge(E e) cases:
		general case (add edge between two existing nodes in the graph), should return true
		illegal edge (edge between one or more nonexistent nodes) should return false
	*/
	@Test
	void addEdge() {
		graph.addNode(statOne);
		graph.addNode(statTwo);
		assertTrue(graph.addEdge(railOne));
		assertFalse(graph.addEdge(railTwo));
		assertFalse(graph.addEdge(railThree));
		assertFalse(graph.addEdge(railFour));
	}
	
	/*
		findRoute(int src, int dest) cases:
		general case (initialise a small multigraph with enough nodes and edges to form a route, then verify that the returned route is correct)
		no route (try to find a route between nodes which we know there are not edges connecting them, verify that null is returned)
		nonexistent nodes (try to find a route between nodes that do not exist in the graph, verify that null is returned)
	*/
	@Test
	void findRoute() {
		assertNull(graph.findRoute(1,2)); //Nonexistent
		graph.addNode(statOne);
		assertNull(graph.findRoute(1,2)); //Nonexistent (second station)
		graph.addNode(statTwo);
		graph.addEdge(railOne);
		graph.addNode(statThree);
		graph.addEdge(railFive);
		assertNotNull(graph.findRoute(1,3)); //FIXME: assert equal to route
		graph.addNode(statFour);
		graph.addNode(statFive);
		graph.addEdge(railSix);
		assertNull(graph.findRoute(1,5)); //No route


	}
	
	/*
		getStations() cases:
		no nodes: call getStations on a fresh multigraph with no nodes
		general case: initialise a multigraph and add x y z nodes, verify that these nodes and no others are returned in the list
	*/
	@Test
	void getStations() {
		assertTrue(graph.getStations().isEmpty()); //No nodes

		//FIXME: Not working
		graph.addNode(statOne);
		graph.addNode(statTwo);
		assertFalse(graph.getStations().isEmpty()); //General FIXME: compare to the actual expected stations

	}
}