package cat.udl.tidic.amd.a7mig.models;

import androidx.annotation.IntegerRes;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;


public class Jugador {

        private final MutableLiveData <String> nombre;
        private final MutableLiveData <Integer> apuesta;
        private final MutableLiveData <Double> puntuacion;

    public Jugador(String nombre, Integer apuesta) {

        this.nombre = new MutableLiveData<>();
        this.apuesta = new MutableLiveData<>();
        this.puntuacion = new MutableLiveData<>();

        this.nombre.setValue(nombre);
        this.apuesta.setValue(apuesta);
        this.puntuacion.setValue(0.0);
    }

    public MutableLiveData <Double> getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion (double puntuacion) {
        this.puntuacion.setValue(puntuacion);
    }

    public MutableLiveData <String> getNombre() {
        return nombre;
    }

    public MutableLiveData <Integer> getApuesta() {
        return apuesta;
    }

    @NonNull
    @Override
    public String toString(){
        if (this.puntuacion.getValue() == 7.5){
            return this.nombre + " ha guanyat " + this.getApuesta().getValue()*2 + " euros amb una puntuació de " + this.getPuntuacion().getValue();
        } else if (this.puntuacion.getValue() < 7.5){
            return this.nombre + " ha perdut " + this.getApuesta().getValue()*0.1 + " euros amb una puntuació de " + this.getPuntuacion().getValue();
        } else {
            return this.nombre + " ha perdut " + this.getApuesta().getValue() + " euros amb una puntuació de " + this.getPuntuacion().getValue();
        }
    }

}
