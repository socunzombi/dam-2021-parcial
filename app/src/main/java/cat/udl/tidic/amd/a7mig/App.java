package cat.udl.tidic.amd.a7mig;
import android.app.Application;
import android.util.Log;

import cat.udl.tidic.amd.a7mig.preferences.PreferenceProvider;

public class App extends Application {

    String TAG = "App";

    @Override
    public void onCreate() {

        super.onCreate();
        PreferenceProvider.init(this);
        Log.d (TAG, "PreferencesProvider iniciat");

        if (PreferenceProvider.providePreferences().getInt("banca", -1) == -1) {

            Log.d (TAG, "L'usuari ha d'iniciar la banca, inicialitzant a 30000...");

            PreferenceProvider.providePreferences().edit().putInt("banca", 30000).apply();

            Log.d (TAG, "Banca Inicialitzada.");

        } else {
            Log.d (TAG, "L'usuari ja té la banca inicialitzada");
        }

    }
}
