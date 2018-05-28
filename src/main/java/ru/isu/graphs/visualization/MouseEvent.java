package ru.isu.graphs.visualization;

import ru.isu.graphs.Main;
import ru.isu.graphs.object.Vertex;

import java.awt.event.MouseListener;

public class MouseEvent implements MouseListener {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        //System.out.print(e.getX() + " " + e.getY());
        // координаты места куда кликнули
        int x = e.getX();
        int y = e.getY();
        // получаем круг, на который кликнули
        Vertex vertex = Main.frame.GetClickedVertex(x, y);
        // если пустой - то на круг не кликнули
        if (vertex != null) {
            // проверяем может ли текущий игрок занять этот круг
            if (Main.gameStatus.isFirstTurn || vertex.CanOccupate(Main.gameStatus.GetCurrentPlayer())) {
                vertex.owner = Main.gameStatus.GetCurrentPlayer(); // прописываем нового владельца круга
                Main.frame.UpdateVertex(vertex); // обновляем массик вершин
                Main.frame.drawPanel();     // перерисовываем
                Main.gameStatus.NextPlayer();  // переключаем на след. игрока
            }
        }
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {

    }
}
