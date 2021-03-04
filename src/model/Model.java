package model;

import multigraph.Station;
import java.util.List;

public class Model implements IModel{

    @Override
    public List<Station> findRoute(int src, int dest) {
        return null;
    }

    @Override
    public List<Station> getStations() {
        return null;
    }

    @Override
    public Multigraph generateGraphFromFile() throws IOException, BadFileException {

        String line = fileInput.readLine();
        StringTokenizer st;
        String stationID;
        String stationName;
        String lineName;
        String outboundID, inboundID;
        Multigraph graph = new Multigraph();




        while (line != null) {

            // STUDENT :
            //
            // in this loop, you must collect the information necessary to
            // construct your graph, and you must construct your graph as well.
            // how and where you do this will depend on the design of your
            // graph.
            //

            // StringTokenizer is a java.util Class that can break a string into
            // tokens
            // based on a specified delimiter. The default delimiter is
            // " \t\n\r\f" which
            // corresponds to the space character, the tab character, the
            // newline character,
            // the carriage-return character and the form-feed character.
            st = new StringTokenizer(line);

            // We want to handle empty lines effectively, we just ignore them!
            if (!st.hasMoreTokens()) {
                line = fileInput.readLine();
                continue;
            }

            // from the grammar, we know that the Station ID is the first token
            // on the line
            stationID = st.nextToken();

            if (!st.hasMoreTokens()) {
                throw new BadFileException("no station name");
            }

            // from the grammar, we know that the Station Name is the second
            // token on the line.
            stationName = st.nextToken();

            if (!st.hasMoreTokens()) {
                throw new BadFileException("station is on no lines");
            }

            Station tempStation = new Station(Integer.parseInt(stationID), stationName, lineName);
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



        return graph;

    }
}
