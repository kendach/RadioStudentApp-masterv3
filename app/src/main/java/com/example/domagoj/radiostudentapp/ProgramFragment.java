package com.example.domagoj.radiostudentapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.domagoj.radiostudentapp.pojos.ProgramRoot;
import com.example.domagoj.radiostudentapp.pojos.ProgramRow;
import com.google.gson.Gson;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.List;

/**
 * Created by User on 2/28/2017.
 */

public class ProgramFragment extends Fragment {
    private View view;
    private ProgressDialog mProgressDialog;
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.program_fragment,container,false);

        Button refresh = view.findViewById(R.id.refreshProgram);
        // Execute Description AsyncTask
        refresh.setOnClickListener(v -> new Description().execute());

        textView = view.findViewById(R.id.listProgram);
        textView.setText(" ... program ... ");
        return view;
    }
    // Description AsyncTask
    private class Description extends AsyncTask<Void, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(view.getContext());
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected String doInBackground(Void... params) {
            String desc = null;
            try {
                // Connect to the web site
                desc = Jsoup.connect(RadioConstants.PROGRAM_URI).ignoreContentType(true).execute().body();
            /*
            Document document = Jsoup.connect(RS_PLAY_LIST_URI).get();
            // Using Elements to get the Meta data
            Elements description = document
                    .select("meta[name=description]");
            // Locate the content attribute
            desc = description.attr("content");
            */
            } catch (IOException e) {
                e.printStackTrace();
            }
            return desc;
        }

        @Override
        protected void onPostExecute(String result) {
            // Set description into TextView
            // TextView txtdesc = (TextView) findViewById(R.id.desctxt);
            Gson gson = new Gson();
            ProgramRoot sviraloRoot = gson.fromJson(result, ProgramRoot.class);

            textView.setText(joinRows(sviraloRoot.getRows()));
            mProgressDialog.dismiss();
        }

        private String joinRows(List<ProgramRow> rows)
        {
            StringBuilder stringBuilder = new StringBuilder();
            String delimiter = "";
            for (ProgramRow row : rows) {
                stringBuilder
                        .append(delimiter)
                        .append(row.getStartTime())
                        .append(" ")
                        .append(row.getPostTitle());
                delimiter = "\n";
            }
            return stringBuilder.toString();
        }
    }

}
