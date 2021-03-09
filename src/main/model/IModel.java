package main.model;

import main.multigraph.Station;

import java.util.List;

public interface IModel {
    List<Station> findRoute(int src, int dest);
    List<Station> getStations();
}
