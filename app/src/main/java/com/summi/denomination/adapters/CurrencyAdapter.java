package com.summi.denomination.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.summi.denomination.Constants;
import com.summi.denomination.R;

public class CurrencyAdapter extends BaseAdapter {
    private Context mContext;

    public CurrencyAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return Constants.CURRENCY_CODE_SIZE;
    }

    @Override
    public Object getItem(int position) {
        return Constants.CURRENCY_CODES[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.currency_item, null);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.currency_text);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(Constants.CURRENCY_NAMES[position] + "("
                + Constants.CURRENCY_CODES[position] + ")");

        return convertView;
    }

    private static class ViewHolder {
        TextView textView;
    }
}
