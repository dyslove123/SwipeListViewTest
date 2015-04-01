package cn.zhongyun.swipelistviewtest;

import java.util.List;
import com.fortysevendeg.swipelistview.SwipeListView;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SwipeAdapter extends ArrayAdapter<RowMessage> {
	private LayoutInflater mInflater ;
	private List<RowMessage> objects ;
	private SwipeListView mSwipeListView ;
	public SwipeAdapter(Context context, int textViewResourceId,List<RowMessage> objects, SwipeListView mSwipeListView) {
		super(context, textViewResourceId, objects);
		Log.d("aa", "3");
		this.objects = objects ;
		this.mSwipeListView = mSwipeListView ;
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null ;
		Log.d("aa", "1");
		if(convertView == null){
			convertView = mInflater.inflate(R.layout.package_row, parent, false);
			holder = new ViewHolder();
			holder.mFrontText = (TextView) convertView.findViewById(R.id.example_row_tv_title);
			holder.mBackEdit = (Button) convertView.findViewById(R.id.example_row_b_action_3);
			holder.mBackDelete = (Button) convertView.findViewById(R.id.example_row_b_action_2);
			holder.mImageView=(ImageView)convertView.findViewById(R.id.example_row_tv_picture);
			holder.mFrontdesc=(TextView)convertView.findViewById(R.id.example_row_tv_describe);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		Log.d("aa", "2");
		holder.mBackDelete.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mSwipeListView.closeAnimate(position);
				mSwipeListView.dismiss(position);
			}
		});
		RowMessage item = getItem(position);
		holder.mFrontText.setText(item.nameString);
		holder.mImageView.setBackgroundResource(item.PicResId);
		holder.mFrontdesc.setText(item.descibe);
		Log.d("aa", "3");
		return convertView;
	}
	class ViewHolder{
		TextView mFrontText,mFrontdesc;
		Button mBackEdit,mBackDelete ;
		ImageView mImageView;
		
	}
}
