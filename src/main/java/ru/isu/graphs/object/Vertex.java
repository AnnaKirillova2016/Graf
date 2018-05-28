package ru.isu.graphs.object;

import ru.isu.graphs.Main;

import java.util.Arrays;

public class Vertex {
    public int id;
    public int x;
    public int y;
    public int status;
    public Player owner; // владелец вершины, null - ничья
    private int[] neighbours;

public int neighboursLenght(){
        return neighbours.length;
    }

    public int getneighbour(int n){
        return neighbours[n];
    }

    public Vertex(String vert) {
        vert = vert.substring(1);
        String[] v = vert.split(",");
        this.id = Integer.parseInt(v[0]);
        this.x = Integer.parseInt(v[1]);
        this.y = Integer.parseInt(v[2]);
        this.status = Integer.parseInt(v[3]);
        v[4] = v[4].substring(v[4].indexOf("[") + 1, v[4].lastIndexOf("]"));
       this.neighbours = Arrays.stream(v[4].split(" ")).mapToInt(Integer::parseInt).toArray();
       this.owner = null;
    }

    public Vertex(int id, int x, int y, int status, int[] neighbours) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.status = status;
        this.neighbours = neighbours;
    }

    // может ли указанный игрок занять эту вершину
    public boolean CanOccupate(Player player)
    {
        boolean allowed = false;
        if (this.owner == null)
        {
            // если среди соседей есть точка, принадлежащая этому игроку, то может
            if (this.neighbours != null && this.neighbours.length != 0)
            {
                for (int i = 0 ; i < this.neighbours.length; i++)
                {
                    Vertex vertex = Main.frame.GetVertexByID(this.neighbours[i]);
                    if (vertex.owner != null && vertex.owner.equals(player))
                    {
                        allowed = true;
                        break;
                    }

                }
            }
        }
        return  allowed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getx() {
        return x;
    }

    public void setx(int x) {
        this.x = x;
    }

    public double gety() {
        return y;
    }

    public void sety(int y) {
        this.y = y;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int[] getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(int[] neighbours) {
        this.neighbours = neighbours;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", status=" + status +
               ", neighbours=" + Arrays.toString(neighbours) +
                '}';
    }
}
//1)рисовался от статуса
//2)номера внршин где находится первый игрок где второй и ход(должна храниться инф и рисование должно учитывать)
//3)функции обработки мыши в момет нажатия если нажатие на круг меняет статус