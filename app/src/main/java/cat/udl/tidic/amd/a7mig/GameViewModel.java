package cat.udl.tidic.amd.a7mig;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GameViewModel extends ViewModel {

    private final String TAG = "GameVM";

    public MutableLiveData <String> jugador = new MutableLiveData<>();
    public MutableLiveData <Integer> aposta = new MutableLiveData<>();

    public GameViewModel () {}


}
