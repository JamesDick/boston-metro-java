package model;

import multigraph.Multigraph;
import multigraph.Rail;
import multigraph.Station;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

public class Model implements IModel{
    private final Multigraph graph;

    public Model(){
        this.graph = new Multigraph();
    }

    @Override
    public List<Station> findRoute(int src, int dest) {
        return graph.findRoute(src, dest);
    }

    @Override
    public List<Station> getStations() {
        return graph.getStations();
    }

    @Override
    public void generateGraphFromFile() throws IOException, BadFileException {

        BufferedReader fileInput = new BufferedReader(new FileReader("metro.txt"));
        String line = fileInput.readLine();
        StringTokenizer st;
        String stationID;
        String stationName;
        String lineName;
        String outboundID, inboundID;

        while (line != null) {

            st = new StringTokenizer(line);
            if (!st.hasMoreTokens()) {
                line = fileInput.readLine();
                continue;
            }

            stationID = st.nextToken();
            if (!st.hasMoreTokens()) {
                throw new BadFileException("no station name");
            }

            stationName = st.nextToken();
            if (!st.hasMoreTokens()) {
                throw new BadFileException("station is on no lines");
            }

            Station tempStation = new Station(Integer.parseInt(stationID), stationName);
            graph.addNode(tempStation);

            while (st.hasMoreTokens()) {
                lineName = st.nextToken();
                if (!st.hasMoreTokens()) {
                    throw new BadFileException("poorly formatted line info");
                }

                outboundID = st.nextToken();
                if (!st.hasMoreTokens()) {
                    throw new BadFileException(
                            "poorly formatted adjacent stations");
                }
                inboundID = st.nextToken();

                Rail outboundTrack = new Rail(Integer.parseInt(outboundID), Integer.parseInt(stationID), lineName);
                Rail inboundTrack = new Rail(Integer.parseInt(stationID), Integer.parseInt(inboundID), lineName);

                graph.addEdge(outboundTrack);
                graph.addEdge(inboundTrack);
            }
            line = fileInput.readLine();
        }
    }
}
