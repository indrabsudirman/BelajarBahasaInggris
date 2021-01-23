package id.indrasudirman.belajarbahasainggris.pastcontinuous;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.uncopt.android.widget.text.justify.JustifiedTextView;

import id.indrasudirman.belajarbahasainggris.R;


public class PastContinuousFragment1 extends Fragment {

    private View view;
    private JustifiedTextView pastContinuousExplain;
    private JustifiedTextView pastContinuousExample1;
    private JustifiedTextView pastContinuousExample2;


    public PastContinuousFragment1() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_past_continuous1, container, false);

        initView();
        mSpannableString();

        return view;
    }

    private void initView() {

        pastContinuousExplain = view.findViewById(R.id.pastContinuousExplain);
        pastContinuousExample1 = view.findViewById(R.id.pastContinuousExample1);
        pastContinuousExample2 = view.findViewById(R.id.pastContinuousExample2);
    }

    private void mSpannableString() {
        SpannableString[] spannableString = new SpannableString[]{
                new SpannableString((getActivity().getResources().getString(R.string.past_continuous_tense_explain))),
                new SpannableString((getActivity().getResources().getString(R.string.second_bullet_past_continuous_tense))),
                new SpannableString((getActivity().getResources().getString(R.string.third_bullet_past_continuous_tense)))};

        ClickableSpan clickableSpanPastContinuousExplain = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Past Continuous Tense adalah salah satu dari 16 Tense (waktu) yang ada dalam Grammar Bahasa Inggris.")
                        .setCancelable(false)
                        .setIcon(R.mipmap.ic_info_green)
                        .setPositiveButton("Sudah paham", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(getActivity(), "Saya sudah paham", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alertDialog = alertDialogSimplePast.create();
                alertDialog.show();
            }
        };

        ClickableSpan clickableSpanPastContinuousExample1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kata 'was studying' adalah contoh dari bentuk Past Continuous Tense.")
                        .setCancelable(false)
                        .setIcon(R.mipmap.ic_info_green)
                        .setPositiveButton("Sudah paham", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(getActivity(), "Saya sudah paham", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alertDialog = alertDialogSimplePast.create();
                alertDialog.show();
            }
        };

        ClickableSpan clickableSpanPastContinuousExample2 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kata 'was raining' adalah contoh dari bentuk Past Continuous Tense.")
                        .setCancelable(false)
                        .setIcon(R.mipmap.ic_info_green)
                        .setPositiveButton("Sudah paham", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(getActivity(), "Saya sudah paham", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alertDialog = alertDialogSimplePast.create();
                alertDialog.show();
            }
        };

        // simpleFutureExplain
        spannableString[0].setSpan(clickableSpanPastContinuousExplain,0,21,0);
        // make text bold
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 0, 21, 0);
        // sedang terjadi pada waktu tertentu di masa lalu.
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 75, 123, 0);
        //Penjelasannya
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 239, 254, 0);
        spannableString[0].setSpan(new UnderlineSpan(), 239, 254, 0);
        //Kejadian yang sedang dilakukan tapi di masa lalu.
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 411, 462, 0);
        pastContinuousExplain.setMovementMethod(LinkMovementMethod.getInstance());
        pastContinuousExplain.setText(spannableString[0]);

        // was studying
        spannableString[1].setSpan(clickableSpanPastContinuousExample1,8,20,0);
        // make text bold
        spannableString[1].setSpan(new StyleSpan(Typeface.BOLD), 8, 20, 0);
        pastContinuousExample1.setMovementMethod(LinkMovementMethod.getInstance());
        pastContinuousExample1.setText(spannableString[1]);

        // was raining
        spannableString[2].setSpan(clickableSpanPastContinuousExample2,5,16,0);
        // make text bold
        spannableString[2].setSpan(new StyleSpan(Typeface.BOLD), 5, 16, 0);
        pastContinuousExample2.setMovementMethod(LinkMovementMethod.getInstance());
        pastContinuousExample2.setText(spannableString[2]);
    }
}