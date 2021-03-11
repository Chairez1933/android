/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2020    HORA: 10-11 HRS
:*
:*                          Clase principal del juego
:*
:*  Archivo     : JuegoActivity.java
:*  Autor       : Sergio Alejandro Cháirez García     17130772
:*  Fecha       : 18/DIC/2020
:*  Compilador  : Android Studio
:*  Descripci�n : Aquí se utiliza la clase para la reproducción de audio tanto de fondo como
:*                 del disparo de las naves.
:*
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*  18/DIC/2020 Sergio Ch.       Documentar código y aplicar reglas de calidad.
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c17130772.u4juegoasteroidesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class JuegoActivity extends AppCompatActivity {

    private VistaJuegoView vistaJuegoView;
    private MediaPlayer mpAudioFondo;
    private MediaPlayer mpAudioDisparo;
    private MediaPlayer mpAudioHit;
    private MediaPlayer mpAudioImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego_layout);

        this.setVolumeControlStream ( AudioManager.STREAM_MUSIC );

        vistaJuegoView = findViewById ( R.id.vistaJuegoView );

        mpAudioFondo = MediaPlayer.create ( this, R.raw.audio_fondo );
        mpAudioFondo.setLooping ( true );

        mpAudioDisparo = MediaPlayer.create ( this, R.raw.audio_disparo );
        vistaJuegoView.setAudioDisparo ( mpAudioDisparo );

        mpAudioHit = MediaPlayer.create ( this, R.raw.audio_hit );
        vistaJuegoView.setAudioHit ( mpAudioHit );

        mpAudioImp = MediaPlayer.create ( this, R.raw.audio_imp );
        vistaJuegoView.setAudioImp ( mpAudioImp );
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
        if ( mpAudioFondo != null )
            mpAudioFondo.stop ();

        vistaJuegoView.setCorriendo ( false );
        VistaJuegoThread hilo = vistaJuegoView.getVistaJuegoThread ();
        try {
            hilo.join ();
        } catch ( InterruptedException ex ) {
            Log.e ( "Asteroides", ex.toString () );
        }
        super.onDestroy ();
    }
}