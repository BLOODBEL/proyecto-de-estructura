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
public class Taller {
    
    private double dinero = 15000;

    private PlaySound playSound = new PlaySound();
    
    public Taller() {
}

    public void takeDamage(double damage) {
        playSound.playSound("src/Sounds/PierdeDinero.wav");
        dinero = dinero - damage;
    }

    public boolean isDestroyed() {
        
        if (dinero <= 0) {
            return true;
        }
        return false;
    }
    
    public double getLife(){
        return dinero;
    }
}
