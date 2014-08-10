                              package com.takaharabooks.sample;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import java.util.*;

public class MainActivity extends Activity
{
    static public final int KIND_NUM = 7;
    int m_nBackKind = 0;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		SetBackground(0);
		
		ImageView csView = (ImageView) this.findViewById(R.id.backImageView);
		csView.setOnClickListener(new OnClickListener()
		{
                @Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					m_nBackKind++;
					m_nBackKind%=KIND_NUM;
					SetBackground(m_nBackKind);
				}
		});
    }
	
	@Override
	public boolean onCreateOptionMenu(Menu menu)
	{
		boolean ret = true;//super.onCreateOptionsMenu(menu);
		menu.add(0,Menu.FIRST+1,0,"BLOG").setIcon(android.R.drawable.ic_dialog_info);
        return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId())
		{
		case Menu.FIRST+1:
		    IntentBlog();
			break;
		}
		
		return true;
	}
	
	public void SetBackground(int nKind)
	{
		Bitmap csBmp = Bitmap.createBitmap(320,320,Bitmap.Config.ARGB_8888);
		Canvas csBmpCanvas = new Canvas(csBmp);
		ImageView csView = (ImageView) this.findViewById(R.id.backImageView);
		switch(nKind)
		{
		case 0:
			DrawBackground001(csBmpCanvas);
		    break;
		case 1:
			DrawBackground002(csBmpCanvas);
		    break;
		case 2:
			DrawBackground003(csBmpCanvas);
			break;
		case 3:
			DrawBackground004(csBmpCanvas);
			break;
		case 4:
			DrawBackground005(csBmpCanvas);
			break;
		case 5:
			DrawBackground006(csBmpCanvas);
			break;
		case 6:
			DrawBackground007(csBmpCanvas);
			break;				
		}
		csView.setImageBitmap(csBmp);
		
		String[] strArrayStr = getResources().getStringArray(R.array.ary_samples);
		TextView csTView = (TextView) findViewById(R.id.titleTV);
		csTView.setText(strArrayStr[nKind]);
	}
	
	public void DrawBackground001(Canvas csCanvas)
	{
		Paint csPaint = new Paint();
		RectF sOval = new RectF();
		for(int x=0; x<=320; x+=10)
		{
			for(int y=0; y<=320; y+=10)
			{
				csPaint.setAntiAlias(true);
				csPaint.setARGB(255,x*255/320,y*255/320,(int)Math.log(x*y));
				sOval.set(x, y, x+10, y+10);
				csCanvas.drawOval(sOval, csPaint);
			}
		}
	}
	
	public void DrawBackground002(Canvas csCanvas)
	{
		Paint csPaint = new Paint();
		RectF sRect = new RectF();
		for(int x=0; x<=320; x+=20)
		{
			for(int y=0; y<=320; y+=20)
			{
				sRect.set(x, y, x+10, y+10);
				csCanvas.drawRect(sRect, csPaint);
				sRect.set(x+10,y+10,x+20,y+20);
				csCanvas.drawRect(sRect, csPaint);
			}
		}
	}
	
	public void DrawBackground003(Canvas csCanvas)
	{
		Random rand = new Random();
		
		Paint csPaint = new Paint();
		RectF sOval = new RectF();
		for(int x=0; x<=320; x+=10)
		{
			for(int y=0; y<=320; y+=10)
			{
				int nX = rand.nextInt(320);
				int nY = rand.nextInt(320);
				int nSize = rand.nextInt(20)+1;
				csPaint.setAntiAlias(true);
				csPaint.setColor(Color.argb(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
				sOval.set(nX, nY, nX+nSize, nY+nSize);
				csCanvas.drawOval(sOval, csPaint);
			}
		}
	}
	
	public void DrawBackground004(Canvas csCanvas)
	{
		Random rand = new Random();

		Paint csPaint = new Paint();
		RectF sOval = new RectF();
		for(int x=0; x<=320; x+=10)
		{
			for(int y=0; y<=320; y+=10)
			{
				int nX = rand.nextInt(320);
				int nY = rand.nextInt(320);
				int nSize = rand.nextInt(20)+1;
				csPaint.setAntiAlias(true);
				csPaint.setColor(Color.argb(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
				sOval.set(nX, nY, nX+nSize, nY+nSize);
				csCanvas.drawRect(sOval, csPaint);
			}
		}
	}

	public void DrawBackground005(Canvas csCanvas)
	{
		Random rand = new Random();

		Paint csPaint = new Paint();
		RectF sRect = new RectF();
		for(int x=0; x<=320; x+=40)
		{
			for(int y=0; y<=320; y+=40)
			{
				csPaint.setColor(Color.argb(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
				sRect.set(x, y, x+40, y+40);
				csCanvas.drawRect(sRect, csPaint);
				int nTColor = -1 * csPaint.getColor() + Color.argb(255,0,0,0);
				csPaint.setColor(nTColor);
				csPaint.setAntiAlias(true);
				csPaint.setTextSize(24);
				String str = String.valueOf((char)((int)'A' + rand.nextInt(26)));
                str += String.valueOf((char)((int)'a' + rand.nextInt(26)));
				csCanvas.drawText(str, sRect.left+4, sRect.bottom-4, csPaint);
			}
		}
	}

	public void DrawBackground006(Canvas csCanvas)
	{
		Random rand = new Random();

		Paint csPaint = new Paint();
		RectF sRect = new RectF();
		for(int x=0; x<=320; x+=40)
		{
			for(int y=0; y<=320; y+=40)
			{
				csPaint.setColor(Color.argb(255,rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
				sRect.set(x, y, x+40, y+40);
				csCanvas.drawRect(sRect, csPaint);
				int nTColor = -1 * csPaint.getColor() + Color.argb(255,0,0,0);
				csPaint.setColor(nTColor);
				csPaint.setAntiAlias(true);
				csPaint.setTextSize(24);
				String str = String.valueOf((char)((int)'A' + rand.nextInt(26)));
                str += String.valueOf((char)((int)'a' + rand.nextInt(26)));
				csCanvas.drawText(str, sRect.left+4, sRect.bottom-4, csPaint);
			}
		}
	}
	
	public void DrawBackground007(Canvas csCanvas)
	{
		Random rand = new Random();

		Paint csPaint = new Paint();
		RectF sRect = new RectF();
		for(int x=0; x<=320; x+=40)
		{
			for(int y=0; y<=320; y+=40)
			{
				if((x+y)%80==0){
					csPaint.setColor(Color.WHITE);
				}else{
				    csPaint.setColor(Color.argb(255,rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
				}
				sRect.set(x, y, x+40, y+40);
				csCanvas.drawRect(sRect, csPaint);
			}
		}
	}
	
	public void IntentBlog(){
		Uri uri = Uri.parse("http://k0j1-android.blogspot.com/2013/10/blog-post_19.html");
		Intent i = new Intent(Intent.ACTION_VIEW, uri);
		startActivity(i);
	}
}
