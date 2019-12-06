package br.com.luandkg.tronarko.tronarko;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;

import java.util.Date;
import java.util.Calendar;
import java.util.*;
import java.text.*;
import android.util.Log;

public class TronarkoActivity extends AppCompatActivity {

    private TextView tv_arco;

    private TextView tv_superarko;
    private TextView tv_hiperarko;
    private TextView tv_periarko;
    private TextView tv_modarko;

    private TextView tv_signo;

    private TextView tv_sizarko;

    private ImageView iv_imagem;

    private TextView s01;
    private TextView s02;
    private TextView s03;
    private TextView s04;
    private TextView s05;
    private TextView s06;
    private TextView s07;
    private TextView s08;
    private TextView s09;
    private TextView s10;

    private TextView s11;
    private TextView s12;
    private TextView s13;
    private TextView s14;
    private TextView s15;
    private TextView s16;
    private TextView s17;
    private TextView s18;
    private TextView s19;
    private TextView s20;

    private TextView s21;
    private TextView s22;
    private TextView s23;
    private TextView s24;
    private TextView s25;
    private TextView s26;
    private TextView s27;
    private TextView s28;
    private TextView s29;
    private TextView s30;

    private TextView s31;
    private TextView s32;
    private TextView s33;
    private TextView s34;
    private TextView s35;
    private TextView s36;
    private TextView s37;
    private TextView s38;
    private TextView s39;
    private TextView s40;

    private TextView s41;
    private TextView s42;
    private TextView s43;
    private TextView s44;
    private TextView s45;
    private TextView s46;
    private TextView s47;
    private TextView s48;
    private TextView s49;
    private TextView s50;

    private TextView feriado;



    final Handler myHandler = new Handler();

    int ultimo_superarko = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tronarko);

        tv_arco=(TextView) findViewById(R.id.arco);
        tv_superarko=(TextView) findViewById(R.id.superarko);
        tv_hiperarko=(TextView) findViewById(R.id.hiperako);
        tv_periarko=(TextView) findViewById(R.id.periarko);
        tv_modarko=(TextView) findViewById(R.id.modarko);
        tv_signo=(TextView) findViewById(R.id.signo);

        tv_sizarko=(TextView) findViewById(R.id.sizarko);

        iv_imagem=(ImageView) findViewById(R.id.imagem);

        s01=(TextView) findViewById(R.id.s01);
        s02=(TextView) findViewById(R.id.s02);
        s03=(TextView) findViewById(R.id.s03);
        s04=(TextView) findViewById(R.id.s04);
        s05=(TextView) findViewById(R.id.s05);
        s06=(TextView) findViewById(R.id.s06);
        s07=(TextView) findViewById(R.id.s07);
        s08=(TextView) findViewById(R.id.s08);
        s09=(TextView) findViewById(R.id.s09);
        s10=(TextView) findViewById(R.id.s10);

        s11=(TextView) findViewById(R.id.s11);
        s12=(TextView) findViewById(R.id.s12);
        s13=(TextView) findViewById(R.id.s13);
        s14=(TextView) findViewById(R.id.s14);
        s15=(TextView) findViewById(R.id.s15);
        s16=(TextView) findViewById(R.id.s16);
        s17=(TextView) findViewById(R.id.s17);
        s18=(TextView) findViewById(R.id.s18);
        s19=(TextView) findViewById(R.id.s19);
        s20=(TextView) findViewById(R.id.s20);


        s21=(TextView) findViewById(R.id.s21);
        s22=(TextView) findViewById(R.id.s22);
        s23=(TextView) findViewById(R.id.s23);
        s24=(TextView) findViewById(R.id.s24);
        s25=(TextView) findViewById(R.id.s25);
        s26=(TextView) findViewById(R.id.s26);
        s27=(TextView) findViewById(R.id.s27);
        s28=(TextView) findViewById(R.id.s28);
        s29=(TextView) findViewById(R.id.s29);
        s30=(TextView) findViewById(R.id.s30);

        s31=(TextView) findViewById(R.id.s31);
        s32=(TextView) findViewById(R.id.s32);
        s33=(TextView) findViewById(R.id.s33);
        s34=(TextView) findViewById(R.id.s34);
        s35=(TextView) findViewById(R.id.s35);
        s36=(TextView) findViewById(R.id.s36);
        s37=(TextView) findViewById(R.id.s37);
        s38=(TextView) findViewById(R.id.s38);
        s39=(TextView) findViewById(R.id.s39);
        s40=(TextView) findViewById(R.id.s40);

        s41=(TextView) findViewById(R.id.s41);
        s42=(TextView) findViewById(R.id.s42);
        s43=(TextView) findViewById(R.id.s43);
        s44=(TextView) findViewById(R.id.s44);
        s45=(TextView) findViewById(R.id.s45);
        s46=(TextView) findViewById(R.id.s46);
        s47=(TextView) findViewById(R.id.s47);
        s48=(TextView) findViewById(R.id.s48);
        s49=(TextView) findViewById(R.id.s49);
        s50=(TextView) findViewById(R.id.s50);

        feriado=(TextView) findViewById(R.id.feriado);

        Timer myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {UpdateGUI();}
        }, 0, 500);

    }


private void superarko_limpar(){

    s01.setTextColor(getResources().getColor(R.color.cornor));
    s02.setTextColor(getResources().getColor(R.color.cornor));
    s03.setTextColor(getResources().getColor(R.color.cornor));
    s04.setTextColor(getResources().getColor(R.color.cornor));
    s05.setTextColor(getResources().getColor(R.color.cornor));
    s06.setTextColor(getResources().getColor(R.color.cornor));
    s07.setTextColor(getResources().getColor(R.color.cornor));
    s08.setTextColor(getResources().getColor(R.color.cornor));
    s09.setTextColor(getResources().getColor(R.color.cornor));
    s10.setTextColor(getResources().getColor(R.color.cornor));

    s11.setTextColor(getResources().getColor(R.color.cornor));
    s12.setTextColor(getResources().getColor(R.color.cornor));
    s13.setTextColor(getResources().getColor(R.color.cornor));
    s14.setTextColor(getResources().getColor(R.color.cornor));
    s15.setTextColor(getResources().getColor(R.color.cornor));
    s16.setTextColor(getResources().getColor(R.color.cornor));
    s17.setTextColor(getResources().getColor(R.color.cornor));
    s18.setTextColor(getResources().getColor(R.color.cornor));
    s19.setTextColor(getResources().getColor(R.color.cornor));
    s20.setTextColor(getResources().getColor(R.color.cornor));

    s21.setTextColor(getResources().getColor(R.color.cornor));
    s22.setTextColor(getResources().getColor(R.color.cornor));
    s23.setTextColor(getResources().getColor(R.color.cornor));
    s24.setTextColor(getResources().getColor(R.color.cornor));
    s25.setTextColor(getResources().getColor(R.color.cornor));
    s26.setTextColor(getResources().getColor(R.color.cornor));
    s27.setTextColor(getResources().getColor(R.color.cornor));
    s28.setTextColor(getResources().getColor(R.color.cornor));
    s29.setTextColor(getResources().getColor(R.color.cornor));
    s30.setTextColor(getResources().getColor(R.color.cornor));

    s31.setTextColor(getResources().getColor(R.color.cornor));
    s32.setTextColor(getResources().getColor(R.color.cornor));
    s33.setTextColor(getResources().getColor(R.color.cornor));
    s34.setTextColor(getResources().getColor(R.color.cornor));
    s35.setTextColor(getResources().getColor(R.color.cornor));
    s36.setTextColor(getResources().getColor(R.color.cornor));
    s37.setTextColor(getResources().getColor(R.color.cornor));
    s38.setTextColor(getResources().getColor(R.color.cornor));
    s39.setTextColor(getResources().getColor(R.color.cornor));
    s40.setTextColor(getResources().getColor(R.color.cornor));

    s41.setTextColor(getResources().getColor(R.color.cornor));
    s42.setTextColor(getResources().getColor(R.color.cornor));
    s43.setTextColor(getResources().getColor(R.color.cornor));
    s44.setTextColor(getResources().getColor(R.color.cornor));
    s45.setTextColor(getResources().getColor(R.color.cornor));
    s46.setTextColor(getResources().getColor(R.color.cornor));
    s47.setTextColor(getResources().getColor(R.color.cornor));
    s48.setTextColor(getResources().getColor(R.color.cornor));
    s49.setTextColor(getResources().getColor(R.color.cornor));
    s50.setTextColor(getResources().getColor(R.color.cornor));

    feriado.setText("");

}

    private void superarko_marcar(int agora){

        if (agora==1){      s01.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==2){      s02.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==3){      s03.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==4){      s04.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==5){      s05.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==6){      s06.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==7){      s07.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==8){      s08.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==9){      s09.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==10){      s10.setTextColor(getResources().getColor(R.color.corsel)); }

        if (agora==11){        s11.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==12){        s12.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==13){        s13.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==14){        s14.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==15){        s15.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==16){        s16.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==17){        s17.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==18){        s18.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==19){        s19.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==20){        s20.setTextColor(getResources().getColor(R.color.corsel)); }

        if (agora==21){        s21.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==22){        s22.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==23){        s23.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==24){        s24.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==25){        s25.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==26){        s26.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==27){        s27.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==28){        s28.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==29){        s29.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==30){        s30.setTextColor(getResources().getColor(R.color.corsel)); }

        if (agora==31){        s31.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==32){        s32.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==33){        s33.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==34){        s34.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==35){       s35.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==36){       s36.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==37){       s37.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==38){       s38.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==39){       s39.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==40){        s40.setTextColor(getResources().getColor(R.color.corsel)); }

        if (agora==41){        s41.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==42){       s42.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==43){        s43.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==44){        s44.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==45){        s45.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==46){        s46.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==47){        s47.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==48){        s48.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==49){        s49.setTextColor(getResources().getColor(R.color.corsel)); }
        if (agora==50){        s50.setTextColor(getResources().getColor(R.color.corsel)); }

        String sferiado ="";

        Tronarko T=new Tronarko();

        Eventum E = new Eventum();
       ArrayList<String> eventos =  E.eventos(T.getTozte());

       int i =0;
       int t=eventos.size();
       while(i<t){
           sferiado=eventos.get(i);
           i+=1;
       }

        feriado.setText(sferiado);
    }


    private void UpdateGUI() {
        myHandler.post(myRunnable);
    }

    final Runnable myRunnable = new Runnable() {
        public void run() {

            Tronarko T=new Tronarko();

            Tronarko.Tron TronC = T.getTronAgora();

            tv_arco.setText(T.getTronAgora().getTexto());
            tv_superarko.setText("Superarko : " + TronC.Superarko_nome());
            tv_hiperarko.setText(TronC.Hiperarko_nome());
            tv_periarko.setText("Periarko : " +T.getHazde().PeriarkoCompleto());
            tv_modarko.setText("Modarko : " +T.getHazde().ModarkoCompleto());

            tv_signo.setText("Signo : " +TronC.Signo_nome());


            tv_sizarko.setText("Hizarko : " +TronC.Hizarko_nome() + "  -  " + String.valueOf(TronC.Hizarko_Superarko() ));

            if (TronC.Periarko().toString().equals("AD")==true){
                iv_imagem.setImageResource(R.mipmap.ic_ad);
            }
            if (TronC.Periarko().toString().equals("ED")==true){
                iv_imagem.setImageResource(R.mipmap.ic_ed);
            }
            if (TronC.Periarko().toString().equals("OD")==true){
                iv_imagem.setImageResource(R.mipmap.ic_od);
            }
            if (TronC.Periarko().toString().equals("UD")==true){
                iv_imagem.setImageResource(R.mipmap.ic_ud);
            }



            int agora_superarko = T.getTozte().getSuperarko();

            if(ultimo_superarko==agora_superarko){

            }else{
                ultimo_superarko=agora_superarko;
                superarko_limpar();
                superarko_marcar(agora_superarko);

            }
        }
    };

}
