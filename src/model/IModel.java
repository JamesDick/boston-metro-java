package model;

import multigraph.Station;

import java.io.IOException;
import java.util.List;

public interface IModel {
    List<Station> findRoute(int src, int dest);
    List<Station> getStations();
    void generateGraphFromFile() throws IOException, BadFileException;
}
