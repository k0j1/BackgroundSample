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
	static public final int KIND_NUM = 10;
    int m_nBackKind = 0;

    /** Called when the activity is first crea"ted. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
		//getWindow().requestFeature(Window.FEATURE_ACTION_MODE_OVERLAY);
		//setTheme(android.R.style.Theme_Bla"|"|"|"|"|"|"|"|"|""|""|"|"||""|"|"|"|"|"|""ck_NoTitleBar);       //タイトルバー(アクションバー)なし
		//setTheme(android.R.style.Theme.WithActionBar);        //アクションバーあり
        super.onCreate(savedInstanceState);
		//setContentViewより前にWindowにActionBar表示を設定
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		this.getActionBar();
		
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
		//boolean ret = true;//super.onCreateOptionsMenu(menu);
		//menu.add(0,Menu.FIRST+1,0,"BLOG").setIcon(android.R.drawable.ic_dialog_info);
		// メニューの要素を追加
		//menu.add("BLOG");

		// メニューの要素を追加して取得
		//MenuItem actionItem = menu.add("BLOG");

		// SHOW_AS_ACTION_IF_ROOM:余裕があれば表示
		//actionItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

		// アイコンを設定
		//actionItem.setIcon(android.R.drawable.ic_dialog_info);
		
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		
        //return super.onCreateOptionsMenu(menu);
		return true;
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
		case 7:
			DrawBackground008(csBmpCanvas);
			break;
		case 8:
			DrawBackground009(csBmpCanvas);
			break;
		case 9:
			DrawBackground010(csBmpCanvas);
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
	
	public void DrawBackground008(Canvas csCanvas)
	{
		Paint csPaint = new Paint();
		csPaint.setAntiAlias(true);
		RectF sRect = new RectF();
		for(int xy=320; xy>0; )
		{
			csPaint.setColor(Color.BLACK);
			sRect.set(160-xy/2, 160-xy/2, 160+xy/2, 160+xy/2);
			csCanvas.drawRect(sRect, csPaint);
			xy/=Math.sqrt(2);
			csCanvas.rotate(45, 160, 160);
			csPaint.setColor(Color.WHITE);
			sRect.set(160-xy/2, 160-xy/2, 160+xy/2, 160+xy/2);
			csCanvas.drawRect(sRect, csPaint);
			xy/=Math.sqrt(2);
			csCanvas.rotate(45, 160, 160);
		}
	}
	
	public void DrawBackground009(Canvas csCanvas)
	{
		Paint csPaint = new Paint();
		csPaint.setAntiAlias(true);
		RectF sRect = new RectF();
		for(int y=0; y<320; y+=80)
		{
			for(int x=0; x<320; x+=80)
			{
				int nRotate = 0;
				for(int xy=80; xy>0; )
				{
					csPaint.setColor(Color.BLACK);
					sRect.set(x+40-xy/2, y+40-xy/2, x+40+xy/2, y+40+xy/2);
					csCanvas.drawRect(sRect, csPaint);
					xy/=Math.sqrt(2);
					csCanvas.rotate(45, x+40, y+40);
					csPaint.setColor(Color.WHITE);
					sRect.set(x+40-xy/2, y+40-xy/2, x+40+xy/2, y+40+xy/2);
					csCanvas.drawRect(sRect, csPaint);
					xy/=Math.sqrt(2);
					csCanvas.rotate(45, x+40, y+40);
					nRotate += 90;
				}
				csCanvas.rotate(-nRotate, x+40, y+40);
			}
		}
	}
	
	public void DrawBackground010(Canvas csCanvas)
	{
		Random rand = new Random();

		Paint csPaint = new Paint();
		csPaint.setAntiAlias(true);
		csPaint.setColor(Color.argb(128+rand.nextInt(80),rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
		
		RectF sOval = new RectF();
		for(int x=0; x<=320; x+=20)
		{
			for(int y=0; y<=320; y+=80)
			{
				int nX = rand.nextInt(320);
				int nY = rand.nextInt(320);
				int nSize = rand.nextInt(30)+10;
				sOval.set(nX, nY, nX+nSize, nY+nSize);
				csCanvas.drawOval(sOval, csPaint);
			}
			int nX = rand.nextInt(320);
			int nY = rand.nextInt(320);
			int nSize = rand.nextInt(40);
			csCanvas.drawLine(nX, nY, nX+nSize, nY+nSize, csPaint);
			
		}
		
	}
	
	public void IntentBlog()
	{
		Uri uri = Uri.parse("http://k0j1-android.blogspot.com/2013/10/blog-post_19.html");
		Intent i = new Intent(Intent.ACTION_VIEW, uri);
		startActivity(i);
	}
}
