package ru.isu.graphs.visualization;
import ru.isu.graphs.Main;
import ru.isu.graphs.object.Graph;
import ru.isu.graphs.object.Player;
import ru.isu.graphs.object.Vertex;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraphFrame extends JFrame {

    public GraphPanel panel;
    ArrayList<Vertex> vertexList;

    // функция получения круга, на который кликнули
    public Vertex GetClickedVertex(int MouseX, int MouseY)
    {
        Vertex vertex  = null;
        for (int i = 0; i < vertexList.size(); i++)
        {
            if (Math.pow(vertexList.get(i).x - MouseX, 2) + Math.pow(vertexList.get(i).y - MouseY,2) <  Math.pow(panel.radius, 2)) {
                vertex = vertexList.get(i);
                break;
            }
        }
        return vertex;
    }

    // получить вершину из списка по id
    public Vertex GetVertexByID(int id)
    {
        Vertex ver = null;
        for (int i = 0; i < vertexList.size(); i++)
        {
            if (vertexList.get(i).id == id)
            {
                ver = vertexList.get(i);
                break;
            }
        }
        return  ver;
    }

    // обновить указанную вершину
    public void UpdateVertex(Vertex newVertex)
    {
        for (int i = 0; i < vertexList.size(); i++)
        {
            if (vertexList.get(i).id == newVertex.id)
            {
                vertexList.set(i, newVertex);
            }
        }
    }
    public GraphFrame(String name) throws HeadlessException {
        super(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);//СЂР°Р·РјРµСЂ
        setVisible(true);
        setBackground(Color.white);
    }

    public void SetVertexList(ArrayList<Vertex> vertexes)
    {
        this.vertexList = vertexes;
    }

    public  void drawPanel()
    {
        panel = new GraphPanel(vertexList);
        panel.setOpaque(true);
        panel.addMouseListener(new MouseEvent());
        getContentPane().removeAll();  // перерисовка содержимого фрэйма
        setContentPane(panel);
        invalidate();
        validate();
        repaint();

    }
}
