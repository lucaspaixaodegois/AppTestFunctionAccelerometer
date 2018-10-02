package to.lucaspg.apptestfunctionaccelerometer.figurasGeometricas;


import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;


public class Paralelogramo extends Geometria {
    private float[] vet_coords = null;
    private FloatBuffer buffer = null;

    public Paralelogramo(GL10 openGL, int tamanho) {

        super();
        this.setTamanho(tamanho);
        this.setIdFigura(3);

        openGL.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        this.setOpenGL(openGL);

    }

    public void desenha() {

        int tamanho = this.getTamanho();
        float lin = 1;
        float[] vetCoords1 = {
                -tamanho/2, -tamanho/2,
                0, -tamanho/2,
                0, tamanho/2,
                tamanho/2, tamanho/2
        };

        //Cria o vetor de coordenadas
        FloatBuffer buffer1 = GeraBuffer.generateBuffer(vetCoords1);

        //refistra as coordenadas na maquina OPENGL
        getOpenGL().glVertexPointer(2, GL10.GL_FLOAT, 0, buffer1);
        getOpenGL().glLoadIdentity();

        getOpenGL().glTranslatef(getPosX(), getPosY(), getPosZ());
        getOpenGL().glRotatef(getRotationAngle(), getRotationX(), getRotationY(), getRotationZ());//rotaciona angulo graus em cima de z
        getOpenGL().glScalef(getScaleX(), getScaleY(), getScaleZ());

        getOpenGL().glColor4f(getRed(), getGreen(), getBlue(), getAlfa());
        getOpenGL().glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);


    }
}
