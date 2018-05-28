package ru.isu.graphs;

import ru.isu.graphs.object.GameStatus;
import ru.isu.graphs.object.Graph;
import ru.isu.graphs.object.Player;
import ru.isu.graphs.object.Vertex;
import ru.isu.graphs.visualization.GraphFrame;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
   import javax.swing.*;


public class Main {


    public static  GameStatus gameStatus = new GameStatus();
    public static  Graph graph;
    public static  GraphFrame frame;

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        // создаём игроков

        Player player1 = new Player(Color.BLUE, "Player 1");
        Player player2 = new Player(Color.RED, "Player 2");
       Player player3 = new Player(Color.BLACK, "Player 3");

        gameStatus.players = new ArrayList<Player>();
        gameStatus.players.add(player1);
        gameStatus.players.add(player2);
        gameStatus.players.add(player3);
        gameStatus.curPlayer = player1;
        gameStatus.isFirstTurn = true; // индикатор первого хода

        ArrayList<Vertex> Vertexes = new ArrayList<>(); // список вершин графа
        Scanner in = new Scanner(new FileReader("src/main/resources/graphs/graph1.txt"));

        //  StringBuilder sb = new StringBuilder();
        while (in.hasNextLine()) {
            Vertexes.add( new Vertex(in.nextLine()));
        }
        in.close();

        graph = new Graph(Vertexes);

        frame = new GraphFrame("test");
        frame.SetVertexList(Vertexes);
        frame.drawPanel();


/*
        Vertexes = new ArrayList<>();
        in = new Scanner(new FileReader("src/main/resources/graphs/graph2.txt"));

        //  StringBuilder sb = new StringBuilder();
        while (in.hasNextLine()) {
            Vertexes.add( new Vertex(in.nextLine()));
        }
        in.close();

        System.out.print("2");
        Thread.sleep(2000);
        frame.SetVertexList(Vertexes);
        frame.drawPanel();
        System.out.print("3");*/
    }
}

