package com.example.tabla;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class TablaBitmap extends ImageView implements OnTouchListener {
	public Context myContext;
	private Canvas myCanvas;
	public Thread t;
	public float x = 0, y = 0;// 854x480
	public float rx;
	public float ry;
	private Handler myHandler;
	private final int FRAME_RATE = 30;
	private int touched = 0;
	private int[] soundId;
	public SoundPool mySoundPool;

	AudioManager audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
	float actualVolume = (float) audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
	float maxVolume = (float) audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
	float volume = actualVolume / maxVolume;

boolean loaded=false;


	public TablaBitmap(Context context, AttributeSet attrs) {
		super(context, attrs);
		myContext = context;
		myHandler = new Handler();
		mySoundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
		soundId=new int[12];
		loadSounds();
		// TODO Auto-generated constructor stub
	}

	public Bitmap resizeImage( Bitmap image){
		Bitmap resized ;
		float imageHeight, imageWidth;
		imageHeight=image.getHeight()*ry;
		imageWidth=image.getWidth()*rx;
		resized=Bitmap.createScaledBitmap(image,(int) imageWidth, (int)imageHeight, true);
		return resized;
	}


	public void loadSounds(){
		soundId[0]=mySoundPool.load(getContext(), R.raw.leftinner, 1);
		soundId[1]=mySoundPool.load(getContext(), R.raw.leftmiddle, 1);
		soundId[2]=mySoundPool.load(getContext(), R.raw.leftouter,1);
		soundId[3]=mySoundPool.load(getContext(), R.raw.rightinner,1);
		soundId[4]=mySoundPool.load(getContext(), R.raw.rightmiddle,1);
		soundId[5]=mySoundPool.load(getContext(), R.raw.rightouter,1);
		soundId[6]=mySoundPool.load(getContext(), R.raw.chalangai,1);
		soundId[7]=mySoundPool.load(getContext(), R.raw.chime,1);
		soundId[8]=mySoundPool.load(getContext(), R.raw.tamourine,1);
		soundId[9]=mySoundPool.load(getContext(), R.raw.shaker,1);
		soundId[10]=mySoundPool.load(getContext(), R.raw.cow,1);
		soundId[11]=mySoundPool.load(getContext(), R.raw.gong,1);
	}

	private Runnable r = new Runnable() {
		
		public void run() {
			invalidate();
		}
	};
	@Override
	protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld) {
		super.onSizeChanged(xNew, yNew, xOld, yOld);
		rx = (float) xNew / 854;
		ry = (float) yNew / 480;
	}

	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		// TODO Auto-generated method stub
		myHandler.post(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				TablaBitmap.this.setVisibility(View.VISIBLE);
			}
		});
		x = event.getX();
		y = event.getY();
		touched = 1;
		return false;
	}

	protected void onDraw(Canvas c) {
		TablaBitmap.this.myCanvas = c;
		if (touched == 1) {
		//left center
		if((x>277*rx&&y>210*ry&&x<363*rx&&y<267*ry)||(x>288*rx&&x<349*rx&&y>200*ry&&y<208*ry)||(x>289*rx&&x<359*rx&&y>270*ry&&y<280*ry)||(x>267*rx&&x<273*rx&&y>226*ry&&y<251*ry)||(x>365*rx&&x<370*rx&&y>217*ry&&y<261*ry)){
			x=323*rx;
			y=241*ry;
			this.setVisibility(View.VISIBLE);
		 	final Bitmap currentBitmap;
			currentBitmap=BitmapFactory.decodeResource(getResources(), R.drawable.ltabla_center1);
			Bitmap scaledBitmap=resizeImage(currentBitmap);
			myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth() / 2,
				y - scaledBitmap.getHeight() / 2, null);
			mySoundPool.play(soundId[0], volume, volume, 1, 0, 1f);
        //AudioManager audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
		}
		
	//left middle
		else if((x>392*rx&&x<416*rx&&y<259*ry&&y>221*ry)||(x>402*rx&&x<409*rx&&y>209*ry&&y<269*ry)||(x>388*rx&&x<399*rx&&y>182*ry&&y<285*ry)||(x>377*rx&&x<387*rx&&y>212*ry&&y<266*ry)||(x>369*rx&&x<387*rx&&y>168*ry&&y<210*ry)||(x>367*rx&&x<389*rx&&y>269*ry&&y<296*ry)||(x>180*rx&&x<211*rx&&y>208*ry&&y<234*ry)||(x>185*rx&&x<193*rx&&y>193*ry&&y<250*ry)||(x>196*rx&&x<205*rx&&y>172*ry&&y<273*ry)||(x>207*rx&&x<216*rx&&y>160*ry&&y<284*ry)||(x>260*rx&&x<323*rx&&y>135*ry&&y<142*ry)||(x>233*rx&&x<341*rx&&y>142*ry&&y<149*ry)||(x>254*rx&&x<341*rx&&y>315*ry&&y<321*ry)||(x>247*rx&&x<361*rx&&y>308*ry&&y<314*ry)||(x>229*rx&&x<375*rx&&y>298*ry&&y<304*ry)||(x>221*rx&&x<365*rx&&y>152*ry&&y<295*ry)||(x>343*rx&&x<362*rx&&y>141*ry&&y<151*ry)||(x>368*rx&&x<385*rx&&y>155*ry&&y<167*ry)||(x>402*rx&&x<410*rx&&y>189*ry&&y<207*ry)){
			x=298*rx;
			y=230*ry;
			this.setVisibility(View.VISIBLE);
			final Bitmap currentBitmap;
			currentBitmap=BitmapFactory.decodeResource(getResources(), R.drawable.ltabla_middle1);
			Bitmap scaledBitmap = resizeImage(currentBitmap);
			myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth() / 2,
					y - scaledBitmap.getHeight() / 2, null);
			mySoundPool.play(soundId[1], volume, volume, 1, 0, 1f);
//            AudioManager audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
		}
	
		//left outer
		else if((x>238*rx&&x<333*rx&&y>=97*ry&&y<110*ry)||(x>204*rx&&x<351*rx&&y>110*ry&&y<=129*ry)||(x>178*rx&&x<232*rx&&y>129*ry&&y<145*ry)||(x>165*rx&&x<211*rx&&y>=145*ry&&y<157*ry)||(x>150*rx&&x<199*rx&&y>=157*ry&&y<182*ry)&&(x>143*rx&&x<179*rx&&y>=182*ry&&y<265*ry)||(x>147*rx&&x<199*rx&&y>=265*ry&&y<281*ry)||(x>154*rx&&x<209*rx&&y>=281*ry&&y<298*ry)||(x>168*rx&&x<226*rx&&y>=298*ry&&y<312*ry)||(x>186*rx&&x<412*rx&&y>=312*ry&&y<329*ry)||(x>211*rx&&x<390*rx&&y>=329*ry&&y<334*ry)||(x>238*rx&&x<360*rx&&y>=334*ry&y<361*ry)||(x>382*rx&&x<427*rx&&y>297*ry&&y<314*ry)||(x>398*rx&&x<441*rx&&y>285*ry&&y<295*ry)||(x>413*rx&&x<446*rx&&y>262*ry&&y<282*ry)||(x>418*rx&&x<451*rx&&y>203*ry&&y<257*ry)||(x>413*rx&&x<446*rx&&y>181*ry&&y<201*ry)||(x>402*rx&&x<441*rx&&y>166*ry&&y<183*ry)||(x>389*rx&&x<423*rx&&y>152*ry&&y<166*ry)||(x>368*rx&&x<409*rx&&y>139*ry&&y<151*ry)||(x>346*rx&&x<394*rx&&y>130*ry&&y<138*ry)||(x>352*rx&&x<377*rx&&y>116*ry&&y<129*ry)||(x>144*rx&&x<179*rx&&y>185*ry&&y<266*ry)||x>151*rx&&x<194*rx&&y>162*ry&&y<184*ry||(x>361*rx&&x<380*rx&&y>343*ry&&y<354*ry)||(x>403*rx&&x<445*rx&&y>278*ry&&y<288*ry)){
			x=295*rx;
			y=233*ry;
			this.setVisibility(View.VISIBLE);
			final Bitmap currentBitmap;
			currentBitmap=BitmapFactory.decodeResource(getResources(), R.drawable.ltabla_outer1);
			Bitmap scaledBitmap = resizeImage(currentBitmap);
			myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth() / 2,
					y - scaledBitmap.getHeight() / 2, null);
			mySoundPool.play(soundId[2], volume, volume, 1, 0, 1f);
            //AudioManager audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
		}
		
		
		
		//right inner
		else if((x>575*rx&&x<607*rx&&y>=211*ry&&y<217*ry)||(x>562*rx&&x<573*rx&&y>=214*ry&&y<217*ry)||(x>609*rx&&x<629*rx&&y>=213*ry&&y<217*ry)||(x>553*rx&&x<631*rx&&y>=220*ry&&y<227*ry)||(x>548*rx&&x<634*rx&&y>=229*ry&&y<268*ry)||(x>636*rx&&x<640*rx&&y>=233*ry&&y<266*ry)||(x>541*rx&&x<546*rx&&y>=233*ry&&y<266*ry)||(x>553*rx&&x<561*rx&&y>=270*ry&&y<278*ry)||(x>563*rx&&x<570*rx&&y>=271*ry&&y<284*ry)||(x>=572*rx&&x<582*rx&&y>=270*ry&&y<287*ry)||(x>583*rx&&x<599*rx&&y>=270*ry&&y<289*ry)||(x>601*rx&&x<632*rx&&y>=270*ry&&y<273*ry)||(x>601*rx&&x<628*rx&&y>=275*ry&&y<278*ry)||(x>601*rx&&x<618*rx&&y>=281*ry&&y<283*ry)||(x>601*rx&&x<611*rx&&y>=285*ry&&y<287*ry)){
			x=591*rx;	
			y=249*ry;
			this.setVisibility(View.VISIBLE);
			final Bitmap currentBitmap;
			currentBitmap=BitmapFactory.decodeResource(getResources(), R.drawable.rtabla_center1);
			Bitmap scaledBitmap=resizeImage(currentBitmap);
			myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth() / 2,
					y - scaledBitmap.getHeight() / 2, null);
			mySoundPool.play(soundId[3], volume, volume, 1, 0, 1f);
//	        AudioManager audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
		}
		//right middle
		else if((x>544*rx&&x<641*ry&&y>210*ry&&y<288*ry)||(x>539*rx&&x<543*rx&&y>212*ry&&y<285*ry)||(x>532*rx&&x<537*rx&&y>270*ry&&y<282*ry)||(x>522*rx&&x<537*rx&&y>233*ry&&y<267*ry)||(x>529*rx&x<537*rx&&y>219*ry&&y<230*ry)||(x>550*rx&&x<559*rx&&y>290*ry&&y<297*ry) ||(x>560*rx&&x<624*rx&&y>291*ry&&y<300*ry)||(x>525*rx&&x<535*rx&&y>290*ry&&y<297*ry)||(x>643*rx&&x<650*rx&&y>214*ry&&y<280*ry)||(x>652*rx&&x<658*rx&&y>225*ry&&y<237*ry)||(x>652*rx&&x<663*rx&&y>239*ry&&y<255*ry)||(x>652*rx&&x<658*rx&&y>258*ry&&y<270*ry)||(x>564*rx&&x<621*rx&&y>199*ry&&y<207*ry)||(x>550*rx&&x<562*rx&&y>200*ry&&y<208*ry)||(x>624*rx&&x<634*rx&&y>201*ry&&y<207*ry)||(x>568*rx&&x<618*rx&&y>194*ry&&y<198*ry)){
			x=591*rx;
			y=249*ry;
			this.setVisibility(View.VISIBLE);
      		final Bitmap currentBitmap;
			currentBitmap=BitmapFactory.decodeResource(getResources(), R.drawable.rtabla_middle1);
			Bitmap scaledBitmap=resizeImage(currentBitmap);
			myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth() / 2,
					y - scaledBitmap.getHeight() / 2, null);
			mySoundPool.play(soundId[4], volume, volume, 1, 0, 1f);
	        //AudioManager audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
			
		}
		
		//right outer
		else if((x>508*rx&&x<682*rx&&y>211*ry&&y<292*ry)||(x>520*rx&&x<530*rx&&y>200*ry&&y<210*ry)||(x>530*rx&&x<544*rx&&y>192*ry&&y<211*ry)&&(x>544*rx&&x<646*rx&&y>184*ry&&y<210*ry)||(x>565*rx&&x<627*rx&&y>176*ry&&y<184*ry)||(x>647*rx&&x<655*rx&&y>189*ry&&y<197*ry)||(x>646*rx&&x<664*rx&&y>197*ry&&y<210*ry)||(x>665*rx&&x<673*rx&&y>202*ry&&y<211*ry)||(x>683*rx&&x<691*rx&&y>235*ry&&y<268*ry)||(x>500*rx&&x<508*rx&&y>225*ry&&y<284*ry)||(x>514*rx&&x<532*rx&&y>293*ry&&y<302*ry)||(x>524*rx&&x<533*rx&&y>303*ry&&y<311*ry)||(x>533*rx&&x<656*rx&&y>295*ry&&y<313*ry)||(x>657*rx&&x<671*rx&&y<294*ry&&y<304*ry)||(x>551*rx&&x<645*rx&&y>314*ry&&y<325*ry)){
			x=591*rx;	
			y=249*ry;
			this.setVisibility(View.VISIBLE);
			final Bitmap currentBitmap;
			currentBitmap=BitmapFactory.decodeResource(getResources(), R.drawable.rtabla_outer1);
			Bitmap scaledBitmap = resizeImage(currentBitmap);
			myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth() / 2,
					y - scaledBitmap.getHeight() / 2, null);
			mySoundPool.play(soundId[5], volume, volume, 1, 0, 1f);
	        //AudioManager audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
		
		}
		//the side stuff51,141
		if((Math.pow(x-51*rx, 2)+(Math.pow(y-141*ry,2)))<=(Math.pow(40,2))){
			x=51*rx;
			y=141*ry;
			this.setVisibility(View.VISIBLE);
			final Bitmap currentBitmap;
			currentBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hy);
			Bitmap scaledBitmap=resizeImage(currentBitmap);
			myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth() / 2,
					y - scaledBitmap.getHeight() / 2, null);
			mySoundPool.play(soundId[6], volume, volume, 1, 0, 1f);
//	        AudioManager audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
		}
		if((Math.pow(x-52*rx, 2)+(Math.pow(y-264*ry,2)))<=(Math.pow(40,2))){
			x=52*rx;
			y=264*ry;
			this.setVisibility(View.VISIBLE);
			final Bitmap currentBitmap;
			currentBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hy);
			Bitmap scaledBitmap = resizeImage(currentBitmap);
			myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth() / 2,
					y - scaledBitmap.getHeight() / 2, null);
			mySoundPool.play(soundId[7], volume, volume, 1, 0, 1f);
	        //AudioManager audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
		}	
		if((Math.pow(x-52*rx, 2)+(Math.pow(y-386*ry,2)))<=(Math.pow(40,2))){
			x=52*rx;
			y=386*ry;
			this.setVisibility(View.VISIBLE);
			final Bitmap currentBitmap;
			currentBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hy);
			Bitmap scaledBitmap = resizeImage(currentBitmap);
			myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth() / 2,
					y - scaledBitmap.getHeight() / 2, null);
			mySoundPool.play(soundId[8], volume, volume, 1, 0, 1f);
	        //AudioManager audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
		}
		if((Math.pow(x-803*rx, 2)+(Math.pow(y-141*ry,2)))<=(Math.pow(40,2))){
			x=803*rx;
			y=141*ry;
			this.setVisibility(View.VISIBLE);
			final Bitmap currentBitmap;
			currentBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hy);
			Bitmap scaledBitmap=resizeImage(currentBitmap);
			myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth() / 2,
					y - scaledBitmap.getHeight() / 2, null);
			mySoundPool.play(soundId[9], volume, volume, 1, 0, 1f);
	        //AudioManager audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
		}
		if((Math.pow(x-803*rx, 2)+(Math.pow(y-264*ry,2)))<=(Math.pow(40,2))){
			x=803*rx;
			y=264*ry;
			this.setVisibility(View.VISIBLE);
			final Bitmap currentBitmap;
			currentBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hy);
			Bitmap scaledBitmap=resizeImage(currentBitmap);
			myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth() / 2,
					y - scaledBitmap.getHeight() / 2, null);
			mySoundPool.play(soundId[10], volume, volume, 1, 0, 1f);
	        //AudioManager audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
		}
		if((Math.pow(x-803*rx, 2)+(Math.pow(y-386*ry,2)))<=(Math.pow(40,2))){
			x=803*rx;
			y=386*ry;
			this.setVisibility(View.VISIBLE);
			final Bitmap currentBitmap;
			currentBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hy);
			Bitmap scaledBitmap = resizeImage(currentBitmap);
			myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth() / 2,
					y - scaledBitmap.getHeight() / 2, null);
			mySoundPool.play(soundId[11], volume, volume, 1, 0, 1f);
	        //AudioManager audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
		}		
		myHandler.postDelayed(new Runnable() {


			public void run() {
				// TODO Auto-generated method stub
				TablaBitmap.this.setVisibility(View.INVISIBLE);
			}
		}, 150);
		touched = 0;
	}
	this.setOnTouchListener(this);
	myHandler.postDelayed(r, FRAME_RATE);
	
	
	}
}
