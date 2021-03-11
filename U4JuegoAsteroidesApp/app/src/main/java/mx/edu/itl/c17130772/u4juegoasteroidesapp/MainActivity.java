/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2020    HORA: 10-11 HRS
:*
:*          Clase que crea la pantalla de presentacion
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Sergio Alejandro Cháirez García     17130772
:*  Fecha       : 18/DIC/2020
:*  Compilador  : Android Studio
:*  Descripci�n : Podemos elegir entre entrar al juego o ver el acerca de con musica de fondo
:*
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*  18/DIC/2020 Sergio Ch.       Documentar código y aplicar reglas de calidad.
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c17130772.u4juegoasteroidesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mpAudioFondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_layout);

        mpAudioFondo = MediaPlayer.create ( this, R.raw.audio_fondo );
        mpAudioFondo.setLooping ( true );
    }

    @Override
    protected void onResume () {
        super.onResume ();
        if ( mpAudioFondo != null )
            mpAudioFondo.start ();
    }

    @Override
    protected void onPause () {
        super.onPause ();
        if ( mpAudioFondo != null )
            mpAudioFondo.pause ();
    }

    @Override
    protected void onDestroy () {
        super.onDestroy ();
        if ( mpAudioFondo != null )
            mpAudioFondo.stop ();
    }

    public void btnAcercaDeClick ( View v ) {
        Intent intent = new Intent( this, AcercaDeActivity.class );
        startActivity ( intent );
    }

    public void btnJugarClick ( View v ) {
        Intent intent = new Intent( this, JuegoActivity.class );
        startActivity ( intent );
    }
}