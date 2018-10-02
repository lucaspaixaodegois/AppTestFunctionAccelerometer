package to.lucaspg.apptestfunctionaccelerometer;

import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

import java.util.ArrayList;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import to.lucaspg.apptestfunctionaccelerometer.figurasGeometricas.Geometria;
import to.lucaspg.apptestfunctionaccelerometer.figurasGeometricas.Paralelogramo;
import to.lucaspg.apptestfunctionaccelerometer.figurasGeometricas.Quadrado;
import to.lucaspg.apptestfunctionaccelerometer.figurasGeometricas.Triangulo;


//classe que ira implementar a logica do desenho implementa  as duas interfaces

public class Renderizador implements GLSurfaceView.Renderer {

    private Triangulo triangulo1, triangulo2, triangulo3, triangulo4, triangulo5;
    private Quadrado quadrado1;
    private Paralelogramo paralelogramo1;

    private ArrayList<Geometria> lst_geometria = null;
    private Geometria obj_selecionado = null;
    private int acao;
    private float altura = 0, largura = 0, coordX, coordY;


    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) { //chamado quando a superficie de desenho é criada
        gl.glClearColor(1, 1, 1, 1);//configura a cor de limpeza no formato RGBA
        this.lst_geometria = new ArrayList<>();

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) { //chamado quando a superficie de desenho sofre  alguma alteração

        this.largura = width;
        this.altura = height;

        gl.glViewport(0, 0, width, height); //mapeia a cena inteira
        gl.glMatrixMode(GL10.GL_PROJECTION); //configurando a area de coordenadas do plano cartesiano
        gl.glLoadIdentity();//substitui a matriz atual pela matriz de identidade.
        gl.glOrthof(0, width, 0, height, -1, 1);//definem os limites da projeção. no  2D, define a área visível da tela em unidades OpenGL.
        gl.glMatrixMode(GL10.GL_MODELVIEW);//Especifica o destino das operações das matriz subsequentes.
        gl.glLoadIdentity();//substitui a matriz atual pela matriz de identidade.


////chifreEsquerdo
        triangulo1 = new Triangulo(gl, 150);
        triangulo1.setTranslate(650, 800);
        triangulo1.setCor(0, 0, 0, 1);
        triangulo1.setRotation(90);
        this.lst_geometria.add(triangulo1);

////cabeca
        quadrado1 = new Quadrado(gl, 120);
        quadrado1.setTranslate(775, 665);
        quadrado1.setCor(1, 0, 0, 1);
        quadrado1.setRotation(0);
        this.lst_geometria.add(quadrado1);

////chifreDireito
        triangulo2 = new Triangulo(gl, 150);
        triangulo2.setTranslate(900, 800);
        triangulo2.setCor(0, 1, 0, 1);
        triangulo2.setRotation(-180);
        this.lst_geometria.add(triangulo2);

//patasFrente
        triangulo3 = new Triangulo(gl, 250);
        triangulo3.setTranslate(610, 480);
        triangulo3.setCor(0.5f, 0, 0.5f, 1);
        triangulo3.setRotation(-90);
        this.lst_geometria.add(triangulo3);

//barriga
        triangulo4 = new Triangulo(gl, 150);
        triangulo4.setTranslate(490, 500);
        triangulo4.setCor(1, 1, 0, 0);
        triangulo4.setRotation(-45);
        this.lst_geometria.add(triangulo4);

//patasTras
        triangulo5 = new Triangulo(gl, 250);
        triangulo5.setTranslate(370, 480);
        triangulo5.setCor(0, 0, 1, 1);
        triangulo5.setRotation(-360);
        this.lst_geometria.add(triangulo5);

//rabo
        paralelogramo1 = new Paralelogramo(gl, 130);
        paralelogramo1.setTranslate(185, 540);
        paralelogramo1.setCor(1, 0, 1.5f, 1);
        paralelogramo1.setRotation(1);
        this.lst_geometria.add(paralelogramo1);


    }

    @Override
    public void onDrawFrame(GL10 gl) {//metodo chamado para desenhar na tela

        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);//aplicar a cor de  limpeza de tela a todos os bits do buffer de cor


        quadrado1.desenha();
//        triangulo1.desenha();
//        triangulo2.desenha();
//        triangulo3.desenha();
//        triangulo4.desenha();
//        triangulo4.desenha();
//        triangulo5.desenha();
//        paralelogramo1.desenha();


    }


    public void setCoordTouch(float x, float y, int acao) {

        this.coordX = x;
        this.coordY = this.altura - y + 37;
        this.acao = acao;
        arrastarFiguraComTouch();
    }

    private void arrastarFiguraComTouch() {

        float x, y, tam;

        switch (this.acao) {
            case MotionEvent.ACTION_DOWN:

                if (this.coordY <= (this.altura - 120)) {
                    for (int i = 0; i < this.lst_geometria.size(); i++) {
                        x = this.lst_geometria.get(i).getPosX();
                        y = this.lst_geometria.get(i).getPosY();
                        tam = this.lst_geometria.get(i).getTamanho() / 2 * this.lst_geometria.get(i).getScaleX();

                        if (this.lst_geometria.get(i).getIdFigura() != 3) {
                            if (coordX >= (x - tam) && coordX <= (x + tam)) {
                                if (coordY >= (y - tam) && coordY < (y + tam)) {

                                    this.obj_selecionado = this.lst_geometria.get(i);

                                }
                            }
                        } else {
                            if (coordX >= (x - tam) && coordX < (x + tam * 4)) {
                                if (coordY >= (y - tam) && coordY < (y + tam)) {
                                    this.obj_selecionado = this.lst_geometria.get(i);

                                }
                            }
                        }
                    }
                }

                break;

            case MotionEvent.ACTION_MOVE:

                if (this.obj_selecionado != null) {
                    if (this.coordY < ((this.altura - 20) - (this.obj_selecionado.getTamanho()) / 2) && this.coordY >= -this.obj_selecionado.getTamanho()) {
                        if (this.coordX >= -this.obj_selecionado.getTamanho() && this.coordX < (largura - -this.obj_selecionado.getTamanho())) {

                            this.obj_selecionado.setTranslate(coordX, coordY);

                        }
                    }
                }

                break;

            case MotionEvent.ACTION_UP:

                if (this.obj_selecionado != null) {
                    this.obj_selecionado = null;
                }

                break;

            default:

                break;
        }
    }
}

        
 /*
        @Override
        public boolean onTouch(View superficieDesenho, MotionEvent event) {

            x = event.getX();
            y = altura - event.getY();
            int rx = (int) event.getX();
            int ry = (int) event.getY();


            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    Log.i("TAG", "moving: (" + rx + ", " + ry + ")");
                    if (quadrado2.getPosX() == rx) {
                        quadrado2.setTranslate(x, y);
                        Log.i("TAG", "moving: (" + x + ", " + y + ")");
                    }

                    break;
                case MotionEvent.ACTION_UP:
                    Log.i("TAG", "touched up");
                    if (quadrado2.getPosX() == rx) {
                        quadrado2.setTranslate(x, y);
                    }
                    break;
                case MotionEvent.ACTION_MOVE:
                    Log.i("TAG", "moving: (" + rx + ", " + ry + ")");
                    if (quadrado2.getPosX() == rx) {
                        quadrado2.setTranslate(x, y);
                    }
                    break;
            }
            return true;
        }
    */