package to.lucaspg.apptestfunctionaccelerometer.figurasGeometricas;


import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class GeraBuffer {
    public static FloatBuffer generateBuffer(float[] vetor)//aloca memoria em bytes
    {
        ByteBuffer prBuffer = ByteBuffer.allocateDirect(vetor.length * 4);

        prBuffer.order(ByteOrder.nativeOrder());//Ordena os endereços de memoria conforme a arquitetura do
        //processador

        FloatBuffer prFloat = prBuffer.asFloatBuffer();//Gera o encapsulador, limpa, insere o vetor
        prFloat.clear();//limpa possiveis lixos
        prFloat.put(vetor);//encapsula
        prFloat.flip();//limpa e retira eventuais sobras de memorias

        return prFloat;


    }
}
