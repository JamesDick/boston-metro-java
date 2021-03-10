package test;

import main.model.Model;
import main.multigraph.Station;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

	private Model model;

	@BeforeEach
	void setUp() {
		model = new Model();
	}

	@AfterEach
	void tearDown() {
		model = null;
	}
	
	/**
	 * Tests that the Model was successfully instantiated.
	 */
	@Test
	void testCreate() {
		assertNotNull(model);
	}
	
	/**
	 * Tests that we can find a route between stations on the same line.
	 *
	 * In this case, the given stations are on the Orange line.
	 */
	@Test
	void findRouteSameLine() {
		List<Station> route = model.findRoute(1, 20);
		assertNotNull(route);
		assertEquals(6, route.size());
		assertEquals("OakGrove", route.get(0).getName());
		assertEquals("NorthStation", route.get(5).getName());
	}
	
	/**
	 * Tests that we can find a route between stations on different lines.
	 *
	 * In this case, the given stations are on the Blue and Red lines.
	 */
	@Test
	void findRouteDifferentLine() {
		List<Station> route = model.findRoute(9, 60);
		assertNotNull(route);
		assertEquals(10, route.size());
		assertEquals("SuffolkDowns", route.get(0).getName());
		assertEquals("Broadway", route.get(9).getName());
	}
	
	/**
	 * Tests that we have correctly loaded all the Boston Metro stations
	 * from the file into our Multigraph.
	 */
	@Test
	void getStations() {
		List<Station> stations = model.getStations();
		assertNotNull(stations);
		assertEquals(124, stations.size());
		assertEquals(stations.get(0).getName(), "OakGrove");
		assertEquals(stations.get(52).getName(), "Prudential");
		assertEquals(stations.get(123).getName(), "Braintree");
	}
}