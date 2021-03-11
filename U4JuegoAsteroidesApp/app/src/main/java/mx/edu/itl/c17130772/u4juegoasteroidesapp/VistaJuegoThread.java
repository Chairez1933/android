/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2020    HORA: 10-11 HRS
:*
:*                          Clase que instancia un Thread
:*
:*  Archivo     : VistaJuegoThreadctivity.java
:*  Autor       : Sergio Alejandro Cháirez García     17130772
:*  Fecha       : 18/DIC/2020
:*  Compilador  : Android Studio
:*  Descripci�n : Se instancia el thread en donde estará corriendo el juego y se manejan las
:*                 excepciones.
:*
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*  18/DIC/2020 Sergio Ch.       Documentar código y aplicar reglas de calidad.
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c17130772.u4juegoasteroidesapp;

import android.util.Log;

public class VistaJuegoThread extends Thread {

    private VistaJuegoView vistaJuegoView;
    private int periodoSleep;

    public VistaJuegoThread ( VistaJuegoView vistaJuegoView, int periodoSleep ) {
        super ();
        this.vistaJuegoView = vistaJuegoView;
        this.periodoSleep = periodoSleep;
    }

    @Override
    public void run () {
        boolean corriendo = vistaJuegoView.isCorriendo ();
        while ( corriendo ) {
            corriendo = vistaJuegoView.isCorriendo ();
            vistaJuegoView.actualizarFisica ();
            try {
                Thread.sleep ( periodoSleep );
            } catch ( InterruptedException ex ) {
                Log.e ( "Asteroides", ex.toString () );
            }
        }
    }
}
