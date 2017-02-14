package layout.support;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by XZman on 10/02/2017.
 */

public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private int[] imageIds;

    public ImageAdapter(int[] ids, Context context) {
        setImageIds(ids);
        mContext = context;
    }

    public void setImageIds(int[] ids) {
        imageIds = ids;
    }

    @Override
    public int getCount() {
        return imageIds.length;
    }

    @Override
    public Object getItem(int position) {
        return imageIds[position];
    }

    @Override
    public long getItemId(int position) {
        return imageIds[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView)convertView;
        }
        imageView.setImageResource(imageIds[position]);
        return imageView;
    }
}
