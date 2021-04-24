package cat.udl.tidic.amd.a7mig;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import cat.udl.tidic.amd.a7mig.models.Jugador;
import cat.udl.tidic.amd.a7mig.models.Partida;

public class GameViewModel extends ViewModel {

    private final String TAG = "GameVM";

    public MutableLiveData <Partida> partida = new MutableLiveData<>();
    public MutableLiveData <Integer> current = new MutableLiveData<>();

    public GameViewModel () {}

    public void seguir () {
        partida.getValue().cogerCarta();
    }

    public void plantarse () {
        // TODO : al plantar-se
    }


}
