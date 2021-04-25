package cat.udl.tidic.amd.a7mig;

import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import cat.udl.tidic.amd.a7mig.models.Carta;
import cat.udl.tidic.amd.a7mig.models.Jugador;
import cat.udl.tidic.amd.a7mig.models.Partida;

public class GameViewModel extends ViewModel {

    private final String TAG = "GameVM";

    public MutableLiveData <Partida> partida      = new MutableLiveData<>();
    public MutableLiveData <Integer> current      = new MutableLiveData<>();
    public MutableLiveData <Boolean> finalPartida = new MutableLiveData<>();
    public MutableLiveData <Integer> carta        = new MutableLiveData<>();

    public GameViewModel () {
    }

    public void seguir () {
        Carta carta = partida.getValue().cogerCarta();

        double suma = carta.getValue() + partida.getValue().getJugadores().get(current.getValue()).getPuntuacion().getValue();
        partida.getValue().getJugadores().get(current.getValue()).setPuntuacion(suma);
        this.carta.setValue(carta.getResource());

        if (suma > 7.5) {
            plantarse();
        }
    }

    public void plantarse () {
        if (partida.getValue().getJugadores().size() - 1 == current.getValue()) {
            finalPartida.setValue(true);
        } else {
            current.setValue(current.getValue()+1);
        }
    }


}
