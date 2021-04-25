package cat.udl.tidic.amd.a7mig;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cat.udl.tidic.amd.a7mig.databinding.ActivityMainBinding;
import cat.udl.tidic.amd.a7mig.models.Jugador;
import cat.udl.tidic.amd.a7mig.models.Partida;


public class GameActivity extends AppCompatActivity {

    private static final String GAME_BEGIN_DIALOG_TAG = "game_dialog_tag";
    private static final String GAME_END_DIALOG_TAG = "game_end_dialog_tag";

    public GameViewModel gameViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    public void initView(){

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setLifecycleOwner(this);
        gameViewModel = new GameViewModel();
        activityMainBinding.setViewModel(gameViewModel);

        gameViewModel.finalPartida.observe(this, finalpartida -> {
            if (finalpartida) {
                finalPartida();
            }
        });

        promptForPlayer();

    }

    private void promptForPlayer() {
        GameBeginDialog dialog = GameBeginDialog.newInstance(this);
        dialog.setCancelable(false);
        dialog.show(getSupportFragmentManager(), GAME_BEGIN_DIALOG_TAG);
    }

    private void finalPartida(){
        GameEndDialog dialog = GameEndDialog.newInstance(this, gameViewModel.partida.getValue().getJugadores());
        dialog.setCancelable(false);
        dialog.show(getSupportFragmentManager(), GAME_END_DIALOG_TAG);
    }

    protected void iniciPartida(List <String> noms, List <Integer> aposta) {

        List <Jugador> jugadores = new ArrayList<>();

        for (int i = 0; i < noms.size(); i++) {
            jugadores.add(new Jugador(noms.get(i), aposta.get(i)));
        }

        Partida partida = new Partida();
        partida.setJugadores(jugadores);

        gameViewModel.partida.setValue(partida);
        gameViewModel.current.setValue(0);
    }

}