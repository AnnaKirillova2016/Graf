package ru.isu.graphs.visualization;

import ru.isu.graphs.object.Player;
import ru.isu.graphs.object.Vertex;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraphPanel extends JPanel {

    int radius = 20; // радиус круга
    ArrayList<Vertex> vertexList;  // список вершин
   // ArrayList<Vertex> neighboursList;
    public GraphPanel(ArrayList<Vertex> vertexes) {

        vertexList = vertexes;
    }

    public void paint(Graphics g) {

        // сначала рисуем линии, чтоб не было наложения
        for (int i = 0; i < vertexList.size(); i++) {
            g.setColor(Color.ORANGE);
            Vertex v = vertexList.get(i);
            for (int j = 0; j < v.neighboursLenght(); j++) {
                Vertex n = vertexList.get(v.getneighbour(j));
                g.drawLine(v.x + radius / 2, v.y + radius / 2, n.x + radius / 2, n.y + radius / 2);
            }
        }
        // потом круги
        for (int i = 0; i < vertexList.size(); i++) {
            g.setColor(Color.ORANGE);
            Vertex v = vertexList.get(i);
            if (v.owner != null) {
                g.setColor(v.owner.color);
            }
            g.fillOval(v.x, v.y, radius, radius);//Р·Р°Р»РёРІРєР° С„РёРіСѓСЂС‹
        }

    }

}
