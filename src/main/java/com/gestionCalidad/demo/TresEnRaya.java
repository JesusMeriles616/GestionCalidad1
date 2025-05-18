package com.gestionCalidad.demo;

//package com.gestionCalidad.demo;

import java.util.Scanner;

public class TresEnRaya {
    private final char[][] tablero = new char[3][3];
    private char jugadorActual = 'X';
    private int turno = 1;

    public TresEnRaya() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tablero[i][j] = ' ';
    }

    public void mostrarTablero() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
    }

    public void colocarPieza(int fila, int columna) {
        if (fila < 0 || fila > 2 || columna < 0 || columna > 2) {
            throw new IndexOutOfBoundsException("Posición fuera del tablero");
        }
        if (tablero[fila][columna] != ' ') {
            throw new IllegalArgumentException("La casilla ya está ocupada");
        }
        tablero[fila][columna] = jugadorActual;
    }

    public void cambiarJugador() { //cambiar jugador
        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
        turno++;
    }

    public char getJugadorActual() {
        return jugadorActual;
    }

    public int getTurno(){
        return turno;
    }

    public boolean hayGanador() {// hay ganador
        // Filas y columnas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual)
                return true;
            if (tablero[0][i] == jugadorActual && tablero[1][i] == jugadorActual && tablero[2][i] == jugadorActual)
                return true;
        }
        // Diagonales
        if (tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual)
            return true;
        if (tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual)
            return true;
        return false;
    }

    public boolean tableroLleno() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (tablero[i][j] == ' ') return false;
        return true;
    }

    public static void main(String[] args) {
        TresEnRaya juego = new TresEnRaya();
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a Tres en Raya (3 en raya) por consola!");
        juego.mostrarTablero();
        while (true) {
            System.out.println("Turno de: " + juego.getJugadorActual());
            System.out.print("Fila (0-2): ");
            int fila = sc.hasNextInt() ? sc.nextInt() : -1;
            System.out.print("Columna (0-2): ");
            int columna = sc.hasNextInt() ? sc.nextInt() : -1;
            sc.nextLine(); // limpiar buffer
            try {
                juego.colocarPieza(fila, columna);
            } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            juego.mostrarTablero();
            if (juego.hayGanador()) {
                System.out.println("¡Gana " + juego.getJugadorActual() + "!");
                break;
            }
            if (juego.tableroLleno()) {
                System.out.println("Empate.");
                break;
            }
            juego.cambiarJugador();
        }
        sc.close();
    }
}
