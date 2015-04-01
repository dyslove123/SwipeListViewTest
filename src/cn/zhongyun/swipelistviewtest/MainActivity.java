package cn.zhongyun.swipelistviewtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fortysevendeg.swipelistview.BaseSwipeListViewListener;
import com.fortysevendeg.swipelistview.SwipeListView;
import android.os.Bundle;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {
	private SwipeListView mSwipeListView ;
	private SwipeAdapter mAdapter ;
	public static int deviceWidth ;
	private List<RowMessage> testData ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mSwipeListView = (SwipeListView) findViewById(R.id.example_lv_list);
		testData = getTestData();
		
		mAdapter = new SwipeAdapter(this, R.layout.package_row, testData,mSwipeListView);
		deviceWidth = getDeviceWidth();
		mSwipeListView.setAdapter(mAdapter);
		mSwipeListView.setSwipeListViewListener( new TestBaseSwipeListViewListener());
		reload();
		
		
	}

	private List<RowMessage> getTestData() {
		RowMessage [] obj = new RowMessage[]{new RowMessage("µÚÒ»","desc1",R.drawable.ic_launcher),
				new RowMessage("µÚer","desc2",R.drawable.ic_launcher)};
		
		List<RowMessage> list = new ArrayList<RowMessage>(Arrays.asList(obj));
		return list;
		
	}

	private int getDeviceWidth() {

		return getResources().getDisplayMetrics().widthPixels;
		
	}

	private void reload() {
		mSwipeListView.setSwipeMode(SwipeListView.SWIPE_MODE_LEFT);
		mSwipeListView.setSwipeActionLeft(SwipeListView.SWIPE_ACTION_REVEAL);
//		mSwipeListView.setSwipeActionRight(settings.getSwipeActionRight());
		mSwipeListView.setOffsetLeft(deviceWidth * 1 / 3);
//		mSwipeListView.setOffsetRight(convertDpToPixel(settings.getSwipeOffsetRight()));
		mSwipeListView.setAnimationTime(0);
		mSwipeListView.setSwipeOpenOnLongPress(false);
		
    }
	
	class TestBaseSwipeListViewListener extends BaseSwipeListViewListener{

		@Override
		public void onClickFrontView(int position) {
			super.onClickFrontView(position);
			Toast.makeText(getApplicationContext(), testData.get(position).nameString, Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onDismiss(int[] reverseSortedPositions) {
			for (int position : reverseSortedPositions) {
				testData.remove(position);
			}
			mAdapter.notifyDataSetChanged();
		}
	}
}
