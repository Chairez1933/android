/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2020    HORA: 10-11 HRS
:*
:*          Clase que crea la pantalla acerca de
:*
:*  Archivo     : AcercaDeActivity.java
:*  Autor       : Sergio Alejandro Cháirez García     17130772
:*  Fecha       : 18/DIC/2020
:*  Compilador  : Android Studio
:*  Descripci�n : Muestra el acerca de.
:*
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*  18/DIC/2020 Sergio Ch.       Documentar código y aplicar reglas de calidad.
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c17130772.u4juegoasteroidesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AcercaDeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acercade);
    }
}