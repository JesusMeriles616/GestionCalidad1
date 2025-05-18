package com.gestionCalidad;

import com.gestionCalidad.demo.TresEnRaya;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assumptions.*;
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

    //--------------Test requrimientos 1-------------------

    @Test
    void lanzarExcepcionSiPiezaFueraDelEjeX() {
        TresEnRaya juego = new TresEnRaya();
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            juego.colocarPieza(3, 1); // X fuera del rango (0-2)
        });
        assertEquals("Posición fuera del tablero", ex.getMessage());
    }

    @Test
    void lanzarExcepcionSiPiezaFueraDelEjeY() {
        TresEnRaya juego = new TresEnRaya();
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            juego.colocarPieza(1, -1); // Y fuera del rango (0-2)
        });
        assertEquals("Posición fuera del tablero", ex.getMessage());
    }

    @Test
    void lanzarExcepcionSiPiezaEnLugarOcupado() {
        TresEnRaya juego = new TresEnRaya();
        juego.colocarPieza(0, 0); // Primer movimiento válido
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            juego.colocarPieza(0, 0); // Lugar ya ocupado
        });
        assertEquals("La casilla ya está ocupada", ex.getMessage());
    }

    //--------------Test requrimientos 2-------------------

    @Test
    void primeroEnJugarEsX() {
        TresEnRaya juego = new TresEnRaya();

        char esperado = 'X';
        char jugadorActual = juego.getJugadorActual();
        
        assumeTrue("No es el primer turno, se salta esta prueba", juego.getTurno() == 1);
        assertEquals(esperado, jugadorActual);
    }

    @Test
    void opuestoAlAnterior() {
        TresEnRaya juego = new TresEnRaya();
        int turno = juego.getTurno();
        char jugadorActual = juego.getJugadorActual();

        for (turno = 1; turno <= 9; turno++){
            jugadorActual = juego.getJugadorActual();
            if (turno % 2 == 1) {
                assertEquals('X', jugadorActual);
            } else {
                assertEquals('+', jugadorActual);
            }
            juego.cambiarJugador();
        }    
    }


    //----------------------------------------------------------------------------/

}
