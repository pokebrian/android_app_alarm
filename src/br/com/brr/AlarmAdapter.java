package br.com.brr;

import java.util.List;

import br.com.brr.model.Alarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


//http://www.androidbrasilprojetos.org/android/adapter-personalizado-custom-adapter/
public class AlarmAdapter extends BaseAdapter {

	private List<Alarm> alarms;
	private LayoutInflater mInflater;
	private ViewHolder holder;
	
	static class ViewHolder{
		private TextView tvName;
	}
	
	public AlarmAdapter(Context context, List<Alarm> alarms) {
		mInflater = LayoutInflater.from(context);
		this.alarms = alarms;
	}
	
	public int getCount() {
		return alarms.size();
	}

	public Object getItem(int position) {
		return alarms.get(position);
	}

	public long getItemId(int position) {
		return alarms.get(position).getId();
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.alarm_adapter_item, null);
			holder = new ViewHolder();
			holder.tvName = (TextView) convertView.findViewById(R.id.txtName);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		Alarm a = alarms.get(position);
		
		holder.tvName.setText(a.getName());
		return convertView;
	}

}
