package com.example.cltcontrol.guayataxi;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class NuevoChofer {

    @Test
    public void choferJoven() {
        assertTrue(MainActivity.validarDatosTaxista("Luis", "QWERTY", "Nissan", 25));
    }

    @Test
    public void choferTerceraEdad() {
        assertTrue(MainActivity.validarDatosTaxista("Luis", "QWERTY", "Nissan", 65));
    }

    @Test
    public void choferMenorDeEdad() {
        assertEquals(MainActivity.validarDatosTaxista("Luis", "QWERTY", "Nissan", 24), false);
    }

    @Test
    public void choferDemasiadoMayor() {
        assertEquals(MainActivity.validarDatosTaxista("Luis", "QWERTY", "Nissan", 66), false);
    }


}
