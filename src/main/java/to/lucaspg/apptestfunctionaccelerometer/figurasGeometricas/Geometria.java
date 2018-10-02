package to.lucaspg.apptestfunctionaccelerometer.figurasGeometricas;

import javax.microedition.khronos.opengles.GL10;

public abstract class Geometria {

    //CORES

    private float red;
    private float green;
    private float blue;
    private float alfa;

    //TRANSLAÇÃO == POSIÇÃO

    private float posX;
    private float posY;
    private float posZ;

    //SCALA == DIMENSÕES

    private float scaleX;
    private float scaleY;
    private float scaleZ;

    //ROTAÇÃO == GRAU INCLINAÇÃO

    private float rotationAngle;
    private float rotationX;
    private float rotationY;
    private float rotationZ;

    private int tamanho;
    private GL10 openGL = null;

    public int getIdFigura() {
        return idFigura;
    }

    public void setIdFigura(int idFigura) {
        this.idFigura = idFigura;
    }

    private int idFigura = 0;

    //CONSTRUTOR

    public Geometria() {

        this.setRed(0);
        this.setBlue(0);
        this.setGreen(0);
        this.setAlfa(1);

        this.setPosX(0);
        this.setPosY(0);
        this.setPosZ(0);


        this.setScaleX(1);
        this.setScaleY(1);
        this.setScaleZ(1);

        this.setRotationAngle(0);
        this.setRotationX(0);
        this.setRotationY(0);
        this.setRotationZ(1);
    }

    //GETS E SETS

    public void setCor(float red, float green, float blue, float alfa) {
        this.setRed(red);
        this.setGreen(green);
        this.setBlue(blue);
        this.setAlfa(alfa);
    }

    public void setTranslate(float x, float y) {
        this.setPosX(x);
        this.setPosY(y);
    }

    public void setScale(float x, float y) {
        this.setScaleX(x);
        this.setScaleY(y);
    }

    public void setRotation(float angle) {

        this.setRotationAngle(angle);
    }

    public float getRed() {
        return red;
    }

    public void setRed(float red) {
        this.red = red;
    }

    public float getGreen() {
        return green;
    }

    public void setGreen(float green) {
        this.green = green;
    }

    public float getBlue() {
        return blue;
    }

    public void setBlue(float blue) {
        this.blue = blue;
    }

    public float getAlfa() {
        return alfa;
    }

    public void setAlfa(float alfa) {
        this.alfa = alfa;
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public float getPosZ() {
        return posZ;
    }

    public void setPosZ(float posZ) {
        this.posZ = posZ;
    }

    public float getScaleX() {
        return scaleX;
    }

    public void setScaleX(float scaleX) {
        this.scaleX = scaleX;
    }

    public float getScaleY() {
        return scaleY;
    }

    public void setScaleY(float scaleY) {
        this.scaleY = scaleY;
    }

    public float getScaleZ() {
        return scaleZ;
    }

    public void setScaleZ(float scaleZ) {
        this.scaleZ = scaleZ;
    }

    public float getRotationAngle() {
        return rotationAngle;
    }

    public void setRotationAngle(float rotationAngle) {
        this.rotationAngle = rotationAngle;
    }

    public float getRotationX() {
        return rotationX;
    }

    public void setRotationX(float rotationX) {
        this.rotationX = rotationX;
    }

    public float getRotationY() {
        return rotationY;
    }

    public void setRotationY(float rotationY) {
        this.rotationY = rotationY;
    }

    public float getRotationZ() {
        return rotationZ;
    }

    public void setRotationZ(float rotationZ) {
        this.rotationZ = rotationZ;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public GL10 getOpenGL() {
        return openGL;
    }

    public void setOpenGL(GL10 openGL) {
        this.openGL = openGL;
    }
}