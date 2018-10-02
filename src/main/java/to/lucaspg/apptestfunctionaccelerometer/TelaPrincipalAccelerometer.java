package to.lucaspg.apptestfunctionaccelerometer;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

public class TelaPrincipalAccelerometer extends AppCompatActivity {
    private GLSurfaceView superficieDesenho = null;//Declara uma referenci para a superfice de desenho.
    private Renderizador render = null; //inicia um objeto render do tipo renderizador
    long startTime;
    static final int MAX_DURATION = 100;
    protected void onCreate(Bundle savedInstanceState) {//metodo chamado quando o app é inicializado.

        super.onCreate(savedInstanceState);//2- Instancia um objeto da superficie de desenho.

        this.superficieDesenho = new GLSurfaceView(this); //publica a superficie de desenho na tela.
        this.render = new Renderizador();//publica,instancia render.
        this.superficieDesenho.setRenderer(this.render);//Configura o objeto que será desenhado na superficie desenho.
        // this.superficieDesenho.setOnTouchListener(this.render); //espera como parametro uma classe q implementa o onthouchlistener
        setContentView(this.superficieDesenho);//publica  a superficie desenho.

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX ();
        float y = event.getY ();
        int action = event.getAction ();

        if (event.getAction() == MotionEvent.ACTION_UP) {

            startTime = System.currentTimeMillis();

        } else if (event.getAction() == MotionEvent.ACTION_DOWN) {

            if(System.currentTimeMillis() - startTime <= MAX_DURATION)
            {
                action = 4;
            } else
            if(System.currentTimeMillis() - startTime <= MAX_DURATION+100)
            {
                action = 3;
            }

        }

        this.render.setCoordTouch ( x, y, action );

        return super.onTouchEvent ( event );

    }


}