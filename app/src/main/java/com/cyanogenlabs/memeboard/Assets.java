package com.cyanogenlabs.memeboard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.SoundPool;

public class Assets {
    public static SoundPool sp,sp1;
    public static Bitmap peepo,fluffy,cryotorque_logo,cyanogen_logo, button,title,creditsBlue,creditsBlack;
    public static int dalla, dallay, khinzeer,john,andaywalaburger,wakeelhoon,stylewyle,sorrykaro,liveLocation,pankha;

    protected static void loadBitmapsAndSounds(Context context, Resources res){
        peepo = BitmapFactory.decodeResource(res,R.drawable.peepohype);
        fluffy = BitmapFactory.decodeResource(res,R.drawable.fluffy);
        cryotorque_logo = BitmapFactory.decodeResource(res,R.drawable.cryotorque_logo);
        cyanogen_logo = BitmapFactory.decodeResource(res,R.drawable.cyanogen_logo);
        button = BitmapFactory.decodeResource(res,R.drawable.button);
        title = BitmapFactory.decodeResource(res, R.drawable.title);
        creditsBlue = BitmapFactory.decodeResource(res,R.drawable.credits_blue);
        creditsBlack = BitmapFactory.decodeResource(res,R.drawable.credits_black);

        sp = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        sp1 = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        dalla = sp.load(context ,R.raw.dalla,1);
        dallay = sp.load(context,R.raw.dallay,2);
        khinzeer = sp.load(context,R.raw.khinzeer,3);
        john = sp.load(context,R.raw.john,4);
        andaywalaburger = sp.load(context,R.raw.andaywalaburger,5);
        pankha = sp1.load(context,R.raw.pankha,1);
        stylewyle = sp1.load(context,R.raw.stylewyle,2);
        wakeelhoon = sp1.load(context,R.raw.wakeelhoon,3);
        sorrykaro = sp1.load(context,R.raw.sorrykaro,4);
        liveLocation = sp1.load(context,R.raw.livelocation,5);

    }
}
