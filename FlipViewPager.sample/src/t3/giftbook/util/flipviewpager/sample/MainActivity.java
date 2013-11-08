package t3.giftbook.util.flipviewpager.sample;

import t3.giftbook.util.FlipViewPager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private FlipViewPager pager;
	


	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.pager = (FlipViewPager)findViewById(R.id.flipviewpager);
        this.pager.setAdapter(new PagerAdapter() {
        	private final LayoutInflater inflater;
        	{
    	        this.inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        	}
        	
			@Override public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}
			
			@Override public int getCount() {
				return 10;
			}
			
			@Override public Object instantiateItem(ViewGroup container, int position) {
				final FrameLayout v = (FrameLayout) inflater.inflate(R.layout.activity_main_pager_item, null);
				
				final TextView  text  = (TextView )v.findViewById(R.id.text);
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < 100; i++) {
					sb.append("this page position is " + position + ". ");
				}
				text.setText(sb.toString());
				
				final ImageView image = (ImageView)v.findViewById(R.id.image);
				
				container.addView(v);
				return v;
			}
			
			@Override public void destroyItem(ViewGroup container, int position, Object object) {
				//TODO 
			}
		});
    }


}
