package ru.isu.graphs.object;

import java.util.ArrayList;

// класс состояния игры
public class GameStatus {


    public static ArrayList<Player> players; // список игроков
    public static Player curPlayer;     // текущий игрок
    public static boolean isFirstTurn;  // индикатор первого хода

    // переключение на след. игрока
    public  void NextPlayer()
    {
        if (players != null && players.size() != 0)
        {
            if (players.indexOf(curPlayer) != players.size()-1)
            {
                curPlayer =players.get(players.indexOf(curPlayer)+1);
            }
            else
            {
                if (isFirstTurn)
                {
                    isFirstTurn = false;
                }
                curPlayer = players.get(0);
            }
        }
    }

    public  Player GetCurrentPlayer()
    {
        return  curPlayer;
    }
}
