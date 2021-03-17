package main.model;

import main.multigraph.Multigraph;
import main.multigraph.Rail;
import main.multigraph.Station;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Implementation of the Model of the system.
 */
public class Model implements IModel {
    private final Multigraph graph;

    public Model() {
        this.graph = new Multigraph();
        try {
            generateGraphFromFile();
        } catch (IOException | BadFileException e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Station> findRoute(int src, int dest) {
        return graph.findRoute(src, dest);
    }

    @Override
    public List<Station> getStations() {
        return graph.getStations();
    }

    /**
     * Populates the Graph based on the contents of the 'metro.txt' file.
     *
     * @throws IOException
     * @throws BadFileException
     */
    private void generateGraphFromFile() throws IOException, BadFileException {
        InputStream in = getClass().getResourceAsStream("/metro.txt");
        BufferedReader fileInput = new BufferedReader(new InputStreamReader(in));
        String line = fileInput.readLine();
        StringTokenizer st;
        String stationID;
        String stationName;
        String lineName;
        String outboundID, inboundID;

        List<Rail> rails = new ArrayList<>();
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

            /* This is for specifying which 'St. Paul Street' station is which. */
            if (Integer.parseInt(stationID) == 38) {
                stationName += " B";
            } else if (Integer.parseInt(stationID) == 61) {
                stationName += " C";
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
                    throw new BadFileException("poorly formatted adjacent stations");
                }
                inboundID = st.nextToken();

                Rail rail1 = new Rail(Integer.parseInt(stationID), Integer.parseInt(outboundID), lineName);
                Rail rail2 = new Rail(Integer.parseInt(stationID), Integer.parseInt(inboundID), lineName);

                rails.add(rail1);
                rails.add(rail2);
            }
            line = fileInput.readLine();
        }

        for (Rail r : rails) {
            graph.addEdge(r);
        }
    }
}
