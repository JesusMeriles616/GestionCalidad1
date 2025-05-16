package com.gestionCalidad;

import com.gestionCalidad.demo.TresEnRaya;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TresEnRayaTest {


    //--------------Test requrimientos 3-------------------

    //Test para comprobar que el tablero se inicializa correctamente

    @Test
    void noHayGanadorSiNoSeCumpleCondicionVictoria() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarPieza(0, 0); // X
        juego.cambiarJugador();
        juego.colocarPieza(0, 1); // O
        juego.cambiarJugador();
        juego.colocarPieza(1, 1); // X
        assertFalse(juego.hayGanador());
    }

    @Test
    void ganaJugadorConLineaHorizontal() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarPieza(1, 0); // X
        juego.colocarPieza(1, 1); // X
        juego.colocarPieza(1, 2); // X
        // No cambiamos de jugador para simular que X ocupa toda la fila
        assertTrue(juego.hayGanador());
    }

    @Test
    void ganaJugadorConLineaVertical() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarPieza(0, 2); // X
        juego.colocarPieza(1, 2); // X
        juego.colocarPieza(2, 2); // X
        assertTrue(juego.hayGanador());
    }

    @Test
    void ganaJugadorConLineaDiagonalPrincipal() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarPieza(0, 0); // X
        juego.colocarPieza(1, 1); // X
        juego.colocarPieza(2, 2); // X
        assertTrue(juego.hayGanador());
    }

    @Test
    void ganaJugadorConLineaDiagonalSecundaria() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarPieza(0, 2); // X
        juego.colocarPieza(1, 1); // X
        juego.colocarPieza(2, 0); // X
        assertTrue(juego.hayGanador());
    }

}
