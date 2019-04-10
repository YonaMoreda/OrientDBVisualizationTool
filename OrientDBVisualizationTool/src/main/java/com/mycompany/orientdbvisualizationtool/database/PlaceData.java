package com.mycompany.orientdbvisualizationtool.database;

import com.mycompany.orientdbvisualizationtool.model.managers.PlaceManager;
import com.mycompany.orientdbvisualizationtool.model.places.Place;
import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;

/**
 *
 * @author Niels
 */
public class PlaceData extends Database {

    private PlaceManager placeManager;

    /**
     * constructor
     *
     * @param graph The graph we want to load the data from
     */
    public PlaceData(OrientGraph graph) {
        super(graph);
        placeManager = PlaceManager.getInstance();
    }

    @Override
    public void refresh(String id) {
        placeManager.emptyPlaces();
        Vertex v = getVertexById("V_location.id", id);
        addPlaceToModel(v);
        //For development purposes only
        //placeManager.printData();
    }

    /**
     * Adds a place and all its children to the model
     *
     * @param place The place we want to add
     */
    private void addPlaceToModel(Vertex place) {
        addPlaceToModel(place, null);
    }

    /**
     * Adds a place and all its children to the model and connects all the
     * children to their respective parents
     *
     * @param place The place we want to add
     * @param parent The parent we want to link the place to
     */
    private void addPlaceToModel(Vertex place, Place parent) {
        String id = (String) place.getProperty("id");
        String name = (String) place.getProperty("name");
        String category = getCategory(place);
        Place newPlace = placeManager.addPlace(id, name, category, parent);

        //perform a sort of depth first search on the graph until we have added all the children
        Iterable<Vertex> vertices;
        vertices = place.getVertices(Direction.IN, "part-of");
        for (Vertex v : vertices) {
            addPlaceToModel(v, newPlace);
        }
    }

}