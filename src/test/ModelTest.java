package test;

import main.model.Model;
import main.multigraph.Multigraph;
import main.multigraph.Rail;
import main.multigraph.Station;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

	private Model model;

	@org.junit.jupiter.api.BeforeEach
	void setUp() {
		model = new Model();
	}

	@org.junit.jupiter.api.AfterEach
	void tearDown() {
		model = null;
	}

	//check if model has been created
	@org.junit.jupiter.api.Test
	void testCreate() {
		assertNotNull(model);
	}

	@org.junit.jupiter.api.Test
	void findRoute() {


	}

	@org.junit.jupiter.api.Test
	void getStations() {
	}
}