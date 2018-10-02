package to.lucaspg.apptestfunctionaccelerometer;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;


public class TelaPrincipalAccelerometer extends AppCompatActivity implements SensorEventListener {

    Sensor accelerometer;//declara sensor
    SensorManager sensorManager; //declara o gerenciador

    private GLSurfaceView superficieDesenho = null;//Declara uma referenci para a superfice de desenho.
    private Renderizador render = null; //inicia um objeto render do tipo renderizador
    long startTime;
    long lastUpdate;
    boolean color;
    static final int MAX_DURATION = 100;


    protected void onCreate(Bundle savedInstanceState) {//metodo chamado quando o app é inicializado.


        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);//instanciados o sensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);//instanciados o acelerômetro
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);//e o acelerômetro foi registrado com um clock normal.


        super.onCreate(savedInstanceState);//2- Instancia um objeto da superficie de desenho.

        this.superficieDesenho = new GLSurfaceView(this); //publica a superficie de desenho na tela.
        this.render = new Renderizador();//publica,instancia render.
        this.superficieDesenho.setRenderer(this.render);//Configura o objeto que será desenhado na superficie desenho.
        // this.superficieDesenho.setOnTouchListener(this.render); //espera como parametro uma classe q implementa o onthouchlistener
        setContentView(this.superficieDesenho);//publica  a superficie desenho.

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();
        int action = event.getAction();

        if (event.getAction() == MotionEvent.ACTION_UP) {

            startTime = System.currentTimeMillis();

        } else if (event.getAction() == MotionEvent.ACTION_DOWN) {

            if (System.currentTimeMillis() - startTime <= MAX_DURATION) {
                action = 4;
            } else if (System.currentTimeMillis() - startTime <= MAX_DURATION + 100) {
                action = 3;
            }

        }

        this.render.setCoordTouch(x, y, action);

        return super.onTouchEvent(event);

    }


    @Override
    public void onSensorChanged(SensorEvent event) {//é onde será programada toda a “reação” do aplicativo ao acelerômetro — uma vez que o mesmo é invocado pela plataforma Android todas as vezes que o acelerômetro sofre alguma modificação

        Sensor accelerometer;
        SensorManager sensorManager;

        float sensorX = event.values[0];
        float sensorY = event.values[1];
        float sensorZ = event.values[2];

        float accelationSquareRoot = (sensorX * sensorX + sensorY * sensorY + sensorZ *sensorZ)
                / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        long actualTime = event.timestamp;
        if (accelationSquareRoot >= 2) //
        {

            if (actualTime - lastUpdate < 200) {
                return;
            }
            lastUpdate = actualTime;
            Toast.makeText(this, "Device was shuffed", Toast.LENGTH_SHORT)
                    .show();

            if (color) {
                superficieDesenho.setBackgroundColor(Color.GREEN);
            } else {
                superficieDesenho.setBackgroundColor(Color.RED);
            }
            color = !color;
        }
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {//apesar de necessário para que a aplicação compile, não sera necessário para o desenvolvimento desse tutorial e será deixado de lado.

    }
}