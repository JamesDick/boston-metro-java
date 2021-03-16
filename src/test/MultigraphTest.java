package test;

import main.multigraph.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MultigraphTest {
    private Multigraph graph;

    @BeforeEach
    void setUp() {
        graph = new Multigraph();
    }

    @AfterEach
    void tearDown() {
        graph = null;
    }

    /**
     * Tests that we are able to add a Node to the Graph.
     */
    @Test
    void addNodeGeneral() {
        assertTrue(graph.addNode(new Station(1, "One")));
    }

    /**
     * Tests that we are not able to add a duplicate Node to the Graph.
     */
    @Test
    void addNodeDuplicate() {
        graph.addNode(new Station(1, "One"));
        assertFalse(graph.addNode(new Station(1, "Duplicate")));
    }

    /**
     * Test that we are able to add Edge between two existing Nodes.
     */
    @Test
    void addEdgeGeneral() {
        graph.addNode(new Station(1, "One"));
        graph.addNode(new Station(2, "Two"));
        assertTrue(graph.addEdge(new Rail(1, 2, "Legit Line")));
    }

    /**
     * Test that we are unable to add Edge between two nonexistent Nodes.
     */
    @Test
    void addEdgeNonexistent() {
        assertFalse(graph.addEdge(new Rail(1, 2, "Legit Line")));
    }

    /**
     * Tests that we are able to populate a graph with nodes and edges and find a route between them.
     */
    @Test
    void findRouteGeneral() {
        graph.addNode(new Station(1, "One"));
        graph.addNode(new Station(2, "Two"));
        graph.addNode(new Station(3, "Three"));
        graph.addEdge(new Rail(1, 2, "Legit Line"));
        graph.addEdge(new Rail(2, 3, "Another Legit Line"));

        List<Station> route = graph.findRoute(1, 3);
        assertNotNull(route);
        assertEquals(3, route.size());
        assertEquals(1, route.get(0).getId());
        assertEquals(3, route.get(2).getId());
    }

    /**
     * Tests that we are not able to find a route between nodes if we don't add the relevant edges.
     */
    @Test
    void findRouteNotThere() {
        graph.addNode(new Station(1, "One"));
        graph.addNode(new Station(2, "Two"));
        graph.addNode(new Station(3, "Three"));
        graph.addEdge(new Rail(2, 3, "Legit Line"));

        List<Station> route = graph.findRoute(1, 3);
        assertNull(route);
    }

    /**
     * Tests that we are not able to find a route in an empty graph.
     */
    @Test
    void findRouteNoNodes() {
        List<Station> route = graph.findRoute(1, 3);
        assertNull(route);
    }

    /**
     * Tests that we can add Nodes to the Graph and these are returned by getStations.
     */
    @Test
    void getStationsGeneral() {
        assertTrue(graph.getStations().isEmpty());
        graph.addNode(new Station(1, "One"));
        graph.addNode(new Station(2, "Two"));
        graph.addNode(new Station(3, "Three"));

        List<Station> stations = graph.getStations();
        assertNotNull(stations);
        assertEquals(3, stations.size());
        assertEquals("One", stations.get(0).getName());
        assertEquals("Two", stations.get(1).getName());
        assertEquals("Three", stations.get(2).getName());
    }

    /**
     * Tests that getStations returns no stations when the graph is empty.
     */
    @Test
    void getStationsEmpty() {
        assertTrue(graph.getStations().isEmpty());
    }
}