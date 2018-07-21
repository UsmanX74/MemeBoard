package com.cyanogenlabs.memeboard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import static com.cyanogenlabs.memeboard.MainActivity.sH;
import static com.cyanogenlabs.memeboard.MainActivity.sW;

public class MainView extends View {
    private boolean memeboardScreen = true, creditsScreen = false;
    private int credits = 0;
    private Paint paint, creditsPaint,titlePaint,borderPaint,creditsText,paint1;
    private RectF dallaRect,dallayRect,khinzeerRect,creditsRect,sheikhUlShaytanRect,andayaWalaBurgerRect,johncenaRect,backRect,
    wakeelHoonRect,stylewyleRect,pankhaRect,sorryKaroRect,liveLocationRect;
    public static float SCALE;

    public MainView(Context context) {
        super(context);
        SCALE = context.getResources().getDisplayMetrics().density;
        creditsText = new Paint();
        creditsText.setColor(Color.rgb(202,255,244));
        creditsText.setTextAlign(Paint.Align.CENTER);
        creditsText.setTextSize(28*SCALE);
        borderPaint = new Paint();
        borderPaint.setColor(Color.BLACK);
        borderPaint.setStrokeWidth(1.5f*SCALE);
        borderPaint.setStyle(Paint.Style.STROKE);
        paint = new Paint();
        paint.setColor(Color.rgb(202,255,244));
        paint.setTextSize(27*SCALE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint1 = new Paint();
        paint1.setColor(Color.rgb(202,255,244));
        paint1.setTextSize(17*SCALE);
        paint1.setTextAlign(Paint.Align.CENTER);
        titlePaint = new Paint();
        titlePaint.setColor(Color.WHITE);
        titlePaint.setTextAlign(Paint.Align.CENTER);
        titlePaint.setTextSize(58*SCALE);
        paint.setStyle(Paint.Style.FILL);
        creditsPaint = new Paint();
        creditsPaint.setColor(Color.GREEN);
        creditsPaint.setTextSize(36*SCALE);
        //creditsPaint.setStrokeWidth(1.5f*SCALE);
        creditsPaint.setTextAlign(Paint.Align.CENTER);
        dallaRect = new RectF();
        dallayRect = new RectF();
        khinzeerRect = new RectF();
        sheikhUlShaytanRect = new RectF();
        andayaWalaBurgerRect = new RectF();
        johncenaRect = new RectF();
        creditsRect = new RectF();
        liveLocationRect = new RectF();
        pankhaRect = new RectF();
        wakeelHoonRect = new RectF();
        sorryKaroRect = new RectF();
        stylewyleRect = new RectF();

        dallaRect = stringRect("Dalla:",sW*0.05f,sH*0.25f,null,paint,false);
        dallayRect = stringRect("Dallay:",sW*0.05f,sH*0.36f,null,paint,false);
        khinzeerRect = stringRect("Khinzeer:",sW * 0.05f,sH*0.47f,null,paint,false);
        johncenaRect = stringRect("John Cena:",sW * 0.05f,sH*0.58f,null,paint,false);
        sheikhUlShaytanRect = stringRect("Sheikh Ul Shaytan:",sW * 0.05f,sH*0.69f,null,paint,false);
        andayaWalaBurgerRect = stringRect("Anday wala burger:",sW * 0.05f,sH*0.80f,null,paint,false);

        liveLocationRect = stringRect("Live Location:",sW * 0.5f,sH*0.25f,null,paint,false);
        pankhaRect = stringRect("Pankha Hai?:",sW * 0.5f,sH*0.36f,null,paint,false);
        stylewyleRect = stringRect("Style Wyle:",sW * 0.5f,sH*0.47f,null,paint,false);
        wakeelHoonRect = stringRect("Wakeel Hoon:",sW * 0.5f,sH*0.58f,null,paint,false);
        sorryKaroRect = stringRect("Sorry Karo:",sW * 0.5f,sH*0.69f,null,paint,false);

        creditsRect = stringRect("View Credits:",sW*0.5f,sH*0.95f,null,creditsPaint,true);
        backRect = stringRect("BACK:",sW*0.5f,sH*0.95f,null,creditsPaint,true);

    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        sW = w;
        sH = h;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (memeboardScreen && !creditsScreen){
            canvas.drawARGB(255,43,61,79);
            canvas.drawBitmap(Assets.title,sW/2 - (Assets.title.getWidth()/2),sH*0.05f,null);
            canvas.drawBitmap(Assets.button,sW*0.05f,sH*0.16f,null);
            canvas.drawBitmap(Assets.button,sW*0.53f,sH*0.16f,null);
            canvas.drawBitmap(Assets.button,sW*0.05f,sH*0.32f,null);
            canvas.drawBitmap(Assets.button,sW*0.53f,sH*0.32f,null);
            canvas.drawBitmap(Assets.button,sW*0.05f,sH*0.48f,null);
            canvas.drawBitmap(Assets.button,sW*0.53f,sH*0.48f,null);
            canvas.drawBitmap(Assets.button,sW*0.05f,sH*0.64f,null);
            canvas.drawBitmap(Assets.button,sW*0.53f,sH*0.64f,null);
            canvas.drawBitmap(Assets.button,sW*0.05f,sH*0.80f,null);
            canvas.drawBitmap(Assets.button,sW*0.53f,sH*0.80f,null);
            if(credits == 0) {
                canvas.drawBitmap(Assets.creditsBlue, sW / 2 - (Assets.creditsBlue.getWidth() / 2), sH * 0.94f, null);
            }else{
                canvas.drawBitmap(Assets.creditsBlack,sW/2 - (Assets.creditsBlack.getWidth()/2),sH*0.94f,null);
            }
            canvas.drawText("Dalla",sW*0.05f+(Assets.button.getWidth()/2),stringHeightforBitmap("Dalla",paint,Assets.button,sH*0.16f),paint);
            canvas.drawText("Dallay",sW*0.53f+(Assets.button.getWidth()/2),stringHeightforBitmap("Dallay",paint,Assets.button,sH*0.16f),paint);
            canvas.drawText("Khinzeer",sW*0.05f+(Assets.button.getWidth()/2),stringHeightforBitmap("khinzeer",paint,Assets.button,sH*0.32f),paint);
            canvas.drawText("John Cena",sW*0.53f+(Assets.button.getWidth()/2),stringHeightforBitmap("John Cena",paint,Assets.button,sH*0.32f),paint);
            canvas.drawText("Pankha hai?",sW*0.05f+(Assets.button.getWidth()/2),stringHeightforBitmap("Pankha Hai?",paint,Assets.button,sH*0.48f),paint);
            canvas.drawText("Style wyle",sW*0.53f+(Assets.button.getWidth()/2),stringHeightforBitmap("Style wyle",paint,Assets.button,sH*0.48f),paint);
            canvas.drawText("Sorry karo",sW*0.05f+(Assets.button.getWidth()/2),stringHeightforBitmap("Sorry karo",paint,Assets.button,sH*0.64f),paint);
            canvas.drawText("Wakeel hoon",sW*0.53f+(Assets.button.getWidth()/2),stringHeightforBitmap("Wakeel hoon",paint,Assets.button,sH*0.64f),paint);
            canvas.drawText("Live location",sW*0.05f+(Assets.button.getWidth()/2),stringHeightforBitmap("Live location",paint,Assets.button,sH*0.80f),paint);
            canvas.drawText("Anday wala burger",sW*0.53f+(Assets.button.getWidth()/2),stringHeightforBitmap("Anday wala burger",paint1,Assets.button,sH*0.80f),paint1);
            invalidate();

        }else if(creditsScreen && !memeboardScreen){
            canvas.drawRGB(0, 138, 111);
            canvas.drawBitmap(Assets.peepo,sW*0.04f,sH*0.21f,null);
            canvas.drawBitmap(Assets.fluffy,sW*0.7f,sH*0.18f,null);

            canvas.drawText("Developed by",sW/2,sH*0.18f,creditsText);
            canvas.drawBitmap(Assets.cyanogen_logo,sW/2 - (Assets.cyanogen_logo.getWidth()/2),sH*0.25f,null);
            canvas.drawText("and",sW/2,sH*0.54f,creditsText);
            canvas.drawBitmap(Assets.cryotorque_logo,sW/2 - (Assets.cryotorque_logo.getWidth()/2),sH*0.6f,null);

            canvas.drawText("Back",sW*0.5f,sH*0.95f,creditsPaint);
            invalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        float X = event.getX();
        float Y = event.getY();
        switch(action){
            case MotionEvent.ACTION_DOWN:
                if(bitmapToRect(Assets.creditsBlue,sW/2 - (Assets.creditsBlack.getWidth()/2),sH*0.94f).contains(X,Y)){
                    credits = 1;
                }else{
                    credits = 0;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if(bitmapToRect(Assets.creditsBlue,sW/2 - (Assets.creditsBlack.getWidth()/2),sH*0.94f).contains(X,Y)){
                    credits = 1;
                }else{
                    credits = 0;
                }
                break;
                //ok
            case MotionEvent.ACTION_UP:
                credits = 0;
                if(memeboardScreen && bitmapToRect(Assets.button,sW*0.05f,sH*0.16f).contains(X,Y)){
                    Assets.sp.play(Assets.dalla,1f,1f,1,0,1);
                }
                if(memeboardScreen && bitmapToRect(Assets.button,sW*0.53f,sH*0.16f).contains(X,Y)){
                    Assets.sp.play(Assets.dallay,1f,1f,1,0,1);
                }
                if(memeboardScreen && bitmapToRect(Assets.button,sW*0.05f,sH*0.32f).contains(X,Y)){
                    Assets.sp.play(Assets.khinzeer,1f,1f,1,0,1);
                }
                if(memeboardScreen && bitmapToRect(Assets.button,sW*0.53f,sH*0.32f).contains(X,Y)){
                    Assets.sp.play(Assets.john,1f,1f,1,0,1);
                }
                if(memeboardScreen && bitmapToRect(Assets.button,sW*0.05f,sH*0.48f).contains(X,Y)){
                    Assets.sp1.play(Assets.pankha,1f,1f,1,0,1);
                }
                if(memeboardScreen && bitmapToRect(Assets.button,sW*0.53f,sH*0.48f).contains(X,Y)){
                    Assets.sp1.play(Assets.stylewyle,1f,1f,1,0,1);
                }
                if(memeboardScreen && bitmapToRect(Assets.button,sW*0.05f,sH*0.64f).contains(X,Y)){
                    Assets.sp1.play(Assets.sorrykaro,1f,1f,1,0,1);
                }
                if(memeboardScreen && bitmapToRect(Assets.button,sW*0.53f,sH*0.64f).contains(X,Y)){
                    Assets.sp1.play(Assets.wakeelhoon,1f,1f,1,0,1);
                }
                if(memeboardScreen && bitmapToRect(Assets.button,sW*0.53f,sH*0.80f).contains(X,Y)){
                    Assets.sp.play(Assets.andaywalaburger,1f,1f,1,0,1);
                }
                if(memeboardScreen && bitmapToRect(Assets.button,sW*0.05f,sH*0.80f).contains(X,Y)){
                    Assets.sp1.play(Assets.liveLocation,1f,1f,1,0,1);
                }


                if(bitmapToRect(Assets.creditsBlue,sW/2 - (Assets.creditsBlack.getWidth()/2),sH*0.94f).contains(X,Y) && !creditsScreen && memeboardScreen){
                    creditsScreen = true;
                    memeboardScreen = false;
                }
                if(backRect.contains(X,Y) && creditsScreen && !memeboardScreen){
                    memeboardScreen = true;
                    creditsScreen = false;
                }
                break;
        }

        invalidate();
        return true;

    }
    private RectF stringRect(String string, float stringX, float stringY, TextPaint textPaint, Paint paint , boolean centerAlignment){
        Rect stringBounds = new Rect();
        if(textPaint != null && paint == null) {
            textPaint.getTextBounds(string, 0, string.length(), stringBounds);
        }else if(paint != null && textPaint == null){
            paint.getTextBounds(string,0,string.length(),stringBounds);
        }
        RectF stringRect = new RectF();
        if(centerAlignment){
            stringRect.set((stringX)-(stringBounds.width() / 2f), stringY - stringBounds.height(),(stringX-(stringBounds.width()/2f))+(stringBounds.width()),stringY );
        }else{
            stringRect.set(stringX,stringY-stringBounds.height(),stringX+stringBounds.width(),stringY);
        }
        return stringRect;
    }
    public RectF bitmapToRect(Bitmap bitmap, float bitmapStartX, float bitmapStartY){
        RectF outRect = new RectF();
        outRect.set(bitmapStartX,bitmapStartY,bitmapStartX+bitmap.getWidth(),bitmapStartY+bitmap.getHeight());
        return outRect;
    }

    private float stringHeightforBitmap(String string, Paint paint, Bitmap bmp, float bmpY){
        Rect stringBounds = new Rect();
        paint.getTextBounds(string,0,string.length(),stringBounds);
        return ((bmpY + (bmp.getHeight()/2)) + (stringBounds.height()/2));
    }
}
