package br.com.luandkg.tronarko.tronarko;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.RemoteViews;

import br.com.luandkg.tronarko.tronarko.Tronarko.Tozte;

public class RelogioDigitalService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Tronarko T = new Tronarko();

        Tozte TozteC = T.getTozte();

        RemoteViews viewBranco = new RemoteViews(getPackageName(), R.layout.relogio_digital_branco);

        viewBranco.setTextViewText(R.id.tx_periarko, T.getHazde().PeriarkoCompleto());
        viewBranco.setTextViewText(R.id.tx_capital, TozteC.Superarko_capital());



        ComponentName theWidget = new ComponentName(this, RelogioDigital.class);
        AppWidgetManager manager = AppWidgetManager.getInstance(this);
        manager.updateAppWidget(theWidget, viewBranco);

        return super.onStartCommand(intent, flags, startId);
    }


}