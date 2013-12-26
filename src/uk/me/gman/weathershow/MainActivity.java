package uk.me.gman.weathershow;

import java.io.File;
import uk.me.gman.weathershow.R;

import android.os.Bundle;
import android.os.Handler;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

@SuppressLint("SdCardPath")
public class MainActivity extends Activity {
	

	private ImageView one = null;
	private ImageView two = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        one = (ImageView)findViewById(R.id.oneImgView);
        two = (ImageView)findViewById(R.id.twoImgView);
 
        one.setOnClickListener(new View.OnClickListener(){

        public void onClick(View view) {

        	  File imgFile = new  File("/sdcard/My Files/sync/train.png");
        	  if(imgFile.exists()){

        	      Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

        	      ImageView myImage = (ImageView) findViewById(R.id.twoImgView);
        	      myImage.setImageBitmap(myBitmap);

        	  }
              two.setVisibility(View.VISIBLE);

              view.setVisibility(View.GONE);
          }});

        two.setOnClickListener(new View.OnClickListener(){

        public void onClick(View view) {
	        File imgFile = new  File("/sdcard/My Files/sync/weather.png");
	        if(imgFile.exists()){

        	      Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

        	      ImageView myImage = (ImageView) findViewById(R.id.oneImgView);
        	      myImage.setImageBitmap(myBitmap);

	        }
        	  
	        one.setVisibility(View.VISIBLE);

            view.setVisibility(View.GONE);
        }});
      
      
        //Handler to update the displayed png every 5 mins
	    final Handler handler = new Handler();
	    
        Runnable runnable = new Runnable() {
	    	public void run() {
		    	File imgFile = new  File("/sdcard/My Files/sync/weather.png");
				if(imgFile.exists()){
				
				    Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
				
				    ImageView myImage = (ImageView) findViewById(R.id.oneImgView);
				    myImage.setImageBitmap(myBitmap);
				
				}
				  
				File imgFile2 = new  File("/sdcard/My Files/sync/train.png");
				if(imgFile2.exists()){
					Bitmap myBitmap = BitmapFactory.decodeFile(imgFile2.getAbsolutePath());
				
				    ImageView myImage = (ImageView) findViewById(R.id.twoImgView);
				    myImage.setImageBitmap(myBitmap);
				
				}
				  
				one.setVisibility(View.VISIBLE);
				two.setVisibility(View.GONE);
				  
				handler.postDelayed(this, 300000);  //5min update interval...
		        }
	        };
	        
	        handler.postDelayed(runnable, 3000); //for initial delay..
	}
}
