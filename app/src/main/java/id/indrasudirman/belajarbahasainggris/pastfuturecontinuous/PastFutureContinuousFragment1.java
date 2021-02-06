package id.indrasudirman.belajarbahasainggris.pastfuturecontinuous;

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


public class PastFutureContinuousFragment1 extends Fragment {

    private View view;
    private JustifiedTextView pastFutureContinuousExplain;
    private JustifiedTextView pastFutureContinuousExample1;
    private JustifiedTextView pastFutureContinuousExample2;


    public PastFutureContinuousFragment1() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_past_future_continuous1, container, false);

        initView();
        mSpannableString();
        return view;
    }
    private void initView() {
        pastFutureContinuousExplain = view.findViewById(R.id.pastFutureContinuousExplain);
        pastFutureContinuousExample1 = view.findViewById(R.id.pastFutureContinuousExample1);
        pastFutureContinuousExample2 = view.findViewById(R.id.pastFutureContinuousExample2);
    }

    private void mSpannableString() {
        SpannableString[] spannableString = new SpannableString[]{
                new SpannableString((getActivity().getResources().getString(R.string.past_future_continuous_tense_explain))),
                new SpannableString((getActivity().getResources().getString(R.string.second_bullet_past_future_continuous_tense))),
                new SpannableString((getActivity().getResources().getString(R.string.third_bullet_past_future_continuous_tense)))};

        ClickableSpan clickableSpanPastFutureContinuousExplain = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Past Future Continuous Tense adalah salah satu dari 16 Tense (waktu) yang ada dalam Grammar Bahasa Inggris.")
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

        ClickableSpan clickableSpanPastFutureContinuousExample1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kata 'should be studying' adalah bentuk dari Past Future Continuous Tense, terdiri dari rumus should + be + verb 1 + ing. Studying dari kata kerja study artinya belajar.")
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

        ClickableSpan clickableSpanPastFutureContinuousExample2 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kata 'should be parking' adalah bentuk dari Past Future Continuous Tense, terdiri dari rumus should + be + verb 1 + ing. Parking dari kata kerja park artinya memarkir.")
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
        spannableString[0].setSpan(clickableSpanPastFutureContinuousExplain,0,28,0);
        // make text bold
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 0, 28, 0);
        // akan sedang dilakukan di masa depan. Tapi diwaktu lampau (sudah berlalu)
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 82, 154, 0);
        // Past,
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 188, 192, 0);
        // should be studying
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 245, 263, 0);
        //Penjelasannya
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 342, 360, 0);
        spannableString[0].setSpan(new UnderlineSpan(), 342, 360, 0);

        pastFutureContinuousExplain.setMovementMethod(LinkMovementMethod.getInstance());
        pastFutureContinuousExplain.setText(spannableString[0]);

        // pastFutureContinuousExample1
        spannableString[1].setSpan(clickableSpanPastFutureContinuousExample1,7,25,0);
        // make text bold
        spannableString[1].setSpan(new StyleSpan(Typeface.BOLD), 7, 25, 0);
        pastFutureContinuousExample1.setMovementMethod(LinkMovementMethod.getInstance());
        pastFutureContinuousExample1.setText(spannableString[1]);

        // pastFutureContinuousExample2
        spannableString[2].setSpan(clickableSpanPastFutureContinuousExample2,16,33,0);
        // make text bold
        spannableString[2].setSpan(new StyleSpan(Typeface.BOLD), 16, 33, 0);
        pastFutureContinuousExample2.setMovementMethod(LinkMovementMethod.getInstance());
        pastFutureContinuousExample2.setText(spannableString[2]);
    }
}