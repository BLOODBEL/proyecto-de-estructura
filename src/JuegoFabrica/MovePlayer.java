/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoFabrica;

/**
 *
 * @author danie
 */
    
public class MovePlayer extends Thread {

    private ListaDobleEnlazada<Road> leftPath;
    private ListaDobleEnlazada<Road> rightPath;
    private Taller cpu;
    private Inicio screen;
    private Bot logicCpu;
    private MoveCpu moveCpu;        

    MovePlayer(ListaDobleEnlazada<Road> leftRoad, ListaDobleEnlazada<Road> rightRoad, Taller cpu, Inicio aThis, Bot logicCpu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

    @Override
    public void run() {
        if (!cpu.isDestroyed()) {
            move(leftPath);
        }

        if (!cpu.isDestroyed()) {
            move(rightPath);
        }

        
    }

    public void move(ListaDobleEnlazada<Road> path) {

        for (int i = 4; i >= 0; i--) {

            if (path.get(i).getCharacter() != null && path.get(i).getCharacter().getIsPlayerCharacter()) {

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }

                if (path.isEnd(i)) {

                    path.get(i).setCharacter(null);
                    path.get(i).eraseCharacter();

                    screen.lessCharactersOnBoard();


                    if (cpu.isDestroyed()) {
                        screen.stopTimer();
                        screen.gameFinish("Ganador: Jugador");
                        return;
                    }

                } else if (path.get(i + 1).getCharacter() != null) {


                    if (path.get(i + 1).getCharacter() == null) {

                        if (path == this.leftPath) {
                            logicCpu.lessLeft();
                        } else {
                            logicCpu.lessRight();
                        }

                    }

                    if (path.get(i).getCharacter() != null) {

                        path.get(i + 1).setCharacter(path.get(i).getCharacter());
                        path.get(i + 1).paintCharacter();

                        path.get(i).setCharacter(null);
                        path.get(i).eraseCharacter();

                    } else {
                        screen.lessCharactersOnBoard();
                    }

                } else {

                    path.get(i + 1).setCharacter(path.get(i).getCharacter());
                    path.get(i + 1).paintCharacter();

                    path.get(i).setCharacter(null);
                    path.get(i).eraseCharacter();

                }
            }
        }
    }

    public MovePlayer(ListaDobleEnlazada<Road> leftPath, ListaDobleEnlazada<Road> rightPath, Taller cpu, Inicio screen,  Bot logicCpu, MoveCpu moveCpu) {
        this.leftPath = leftPath;
        this.rightPath = rightPath;
        this.cpu = cpu;
        this.screen = screen;

    }
}
