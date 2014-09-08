package se.mah.kd330a.assignment3.adapters;

import se.mah.kd330a.assignment3.CelestialBody;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * For use with Gridview
 * 
 * @author ksango
 * 
 */
public class MyGridAdapter extends ArrayAdapter<CelestialBody> {

	private LayoutInflater mLayoutInflater;

	public MyGridAdapter(Context context, int resource, CelestialBody[] objects) {
		super(context, resource, objects);

		mLayoutInflater = LayoutInflater.from(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;

		if (convertView == null) {
			// ???
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.image.setImageResource(getItem(position).getImage());
		holder.name.setText(getItem(position).getName());

		return convertView;
	}

	private class ViewHolder {
		TextView name;
		ImageView image;
	}
}
