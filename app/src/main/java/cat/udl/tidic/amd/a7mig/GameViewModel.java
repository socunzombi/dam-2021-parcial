package cat.udl.tidic.amd.a7mig;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import cat.udl.tidic.amd.a7mig.models.Jugador;
import cat.udl.tidic.amd.a7mig.models.Partida;

public class GameViewModel extends ViewModel {

    private final String TAG = "GameVM";

    public MutableLiveData <Jugador> currentPlayer = new MutableLiveData<>();

    public MutableLiveData <String> nom () {return new MutableLiveData <String> ().setValue(currentPlayer.getValue().getNombre());}

    public GameViewModel () {}


}
