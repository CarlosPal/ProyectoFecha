/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fecha;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author 203p21
 */
public class Fecha {

    int dia;
    int mes;
    int anno;
    static int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
        "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public Fecha(int dia, int mes, int anno) {
        this.dia = dia;
        this.mes = mes;
        this.anno = anno;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnno() {
        return anno;
    }

    public Fecha() {
        Calendar c = new GregorianCalendar();
        dia = c.get(Calendar.DAY_OF_MONTH);
        mes = c.get(Calendar.MONTH)+1;
        anno = c.get(Calendar.YEAR);
    }

    public void bisiesto() {
        if (anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0) {
            diasMes[1] = 29;
        } else {
            diasMes[1] = 77;
        }
    }

    public void bisiesto(int anno) {
        if (anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0) {
            diasMes[1] = 29;
        } else {
            diasMes[1] = 28;
        }
    }

    /**
     * Método que comprueba si una fecha es correcta o no, y la guarda si es
     * correcta.
     *
     * @param d dia
     * @param m mes
     * @param a año
     * @return true si la fecha es correcta, false si es incorrecta
     */
    public boolean comprobarFecha(int d, int m, int a) {
        boolean resultado = false;
        if (a > 1900 && a < 2100) {
            bisiesto(a);
            if (m >= 1 && m <= 12) {
                if (d >= 1 && d <= diasMes[m - 1]) {
                    resultado = true;
                    dia = d;
                    mes = m;
                    anno = a;
                }
            }
        }
        return resultado;
    }

    public int compararFechas(Fecha f) {
        int resultado;
        if (anno > f.getAnno()) {
            resultado = 1;
        } else if (mes < f.getAnno()) {
            resultado = -1;
        } else if (mes > f.getMes()) {
            resultado = 1;
        } else if (mes < f.getMes()) {
            resultado = -1;
        } else if (dia > f.getDia()) {
            resultado = 1;
        } else if (dia < f.getDia()) {
            resultado = -1;
        } else {
            resultado = 0;
        }
        return resultado;
    }
}
