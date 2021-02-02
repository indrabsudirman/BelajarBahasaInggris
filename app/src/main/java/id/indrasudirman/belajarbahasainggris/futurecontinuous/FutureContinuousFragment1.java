package id.indrasudirman.belajarbahasainggris.futurecontinuous;

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


public class FutureContinuousFragment1 extends Fragment {

    private View view;
    private JustifiedTextView futureContinuousExplain;
    private JustifiedTextView futureContinuousExample1;
    private JustifiedTextView futureContinuousExample2;


    public FutureContinuousFragment1() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_future_continuous1, container, false);

        initView();
        mSpannableString();

        return view;
    }

    private void initView() {
        futureContinuousExplain = view.findViewById(R.id.futureContinuousExplain);
        futureContinuousExample1 = view.findViewById(R.id.futureContinuousExample1);
        futureContinuousExample2 = view.findViewById(R.id.futureContinuousExample2);
    }

    private void mSpannableString() {
        SpannableString[] spannableString = new SpannableString[]{
                new SpannableString((getActivity().getResources().getString(R.string.future_continuous_tense_explain))),
                new SpannableString((getActivity().getResources().getString(R.string.second_bullet_future_continuous_tense))),
                new SpannableString((getActivity().getResources().getString(R.string.third_bullet_future_continuous_tense)))};

        ClickableSpan clickableSpanPresentContinuousExplain = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Future Continuous Tense adalah salah satu dari 16 Tense (waktu) yang ada dalam Grammar Bahasa Inggris.")
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

        ClickableSpan clickableSpanFutureContinuousExample1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kata 'will be studying' adalah bentuk dari Future Continuous Tense, terdiri dari rumus will + be + verb 1 + ing. Studying dari kata kerja study artinya belajar.")
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

        ClickableSpan clickableSpanFutureContinuousExample2 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kata 'will be eating' adalah bentuk dari Future Continuous Tense, terdiri dari rumus will + be + verb 1 + ing. Eating dari kata kerja eat artinya makan.")
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
        spannableString[0].setSpan(clickableSpanPresentContinuousExplain,0,23,0);
        // make text bold
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 0, 23, 0);
        // akan sedang dilakukan di masa depan.
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 77, 113, 0);
        //Penjelasannya
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 330, 345, 0);
        spannableString[0].setSpan(new UnderlineSpan(), 330, 345, 0);
        //Jadi Future Continuous Tense.
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 552, 581, 0);
        futureContinuousExplain.setMovementMethod(LinkMovementMethod.getInstance());
        futureContinuousExplain.setText(spannableString[0]);

        // futureContinuousExample1
        spannableString[1].setSpan(clickableSpanFutureContinuousExample1,8,24,0);
        // make text bold
        spannableString[1].setSpan(new StyleSpan(Typeface.BOLD), 8, 24, 0);
        futureContinuousExample1.setMovementMethod(LinkMovementMethod.getInstance());
        futureContinuousExample1.setText(spannableString[1]);

        // futureContinuousExample2
        spannableString[2].setSpan(clickableSpanFutureContinuousExample2,4,18,0);
        // make text bold
        spannableString[2].setSpan(new StyleSpan(Typeface.BOLD), 4, 18, 0);
        futureContinuousExample2.setMovementMethod(LinkMovementMethod.getInstance());
        futureContinuousExample2.setText(spannableString[2]);
    }
}