package id.indrasudirman.belajarbahasainggris.futureperfectcontinuous;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.uncopt.android.widget.text.justify.JustifiedTextView;

import id.indrasudirman.belajarbahasainggris.R;


public class FuturePerfectContinuousFragment1 extends Fragment {

    private View view;
    private JustifiedTextView explainTheTense;
    private JustifiedTextView exampleTheTense1;
    private JustifiedTextView exampleTheTense2;


    public FuturePerfectContinuousFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_future_perfect_continuous1, container, false);

        initView();
        mSpannableString();

        return view;
    }

    private void initView() {
        explainTheTense = view.findViewById(R.id.explainTheTense);
        exampleTheTense1 = view.findViewById(R.id.exampleTheTense1);
        exampleTheTense2 = view.findViewById(R.id.exampleTheTense2);
    }

    private void mSpannableString() {
        SpannableString[] spannableString = new SpannableString[]{
                new SpannableString((getActivity().getResources().getString(R.string.future_perfect_continuous_explain))),
                new SpannableString((getActivity().getResources().getString(R.string.second_bullet_future_perfect_continuous_tense))),
                new SpannableString((getActivity().getResources().getString(R.string.third_bullet_future_perfect_continuous_tense)))};

        ClickableSpan clickableSpanExplainTheTense = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Future Perfect Continuous Tense adalah salah satu dari 16 Tense (waktu) yang ada dalam Grammar Bahasa Inggris.")
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

        ClickableSpan clickableSpanExampleTheTense1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kata 'will have been travelling' adalah bentuk dari Future Perfect Continuous Tense, terdiri dari rumus will + have + been + verb 1 + ing. Travelling dari kata kerja travel artinya perjalanan/melakukan perjalanan.")
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

        ClickableSpan clickableSpanExampleTheTense2 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kata 'will have been typing' adalah bentuk dari Future Perfect Continuous Tense, terdiri dari rumus will + have + been + verb 1 + ing. Typing dari kata kerja type artinya mengetik.")
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

        // explainTheTense
        spannableString[0].setSpan(clickableSpanExplainTheTense,0,31,0);
        // make text bold
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 0, 31, 0);
        // sedang akan berlangsung dan terus berlangsung pada masa depan ...
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 85, 196, 0);
        // will have been travelling
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 364, 389, 0);
        // Future Perfect Continuous Tense.
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 707, 739, 0);

        //will have been typing
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 821, 842, 0);

        explainTheTense.setMovementMethod(LinkMovementMethod.getInstance());
        explainTheTense.setText(spannableString[0]);

        // exampleTheTense1
        spannableString[1].setSpan(clickableSpanExampleTheTense1,8,33,0);
        // make text bold
        spannableString[1].setSpan(new StyleSpan(Typeface.BOLD), 8,33, 0);
        exampleTheTense1.setMovementMethod(LinkMovementMethod.getInstance());
        exampleTheTense1.setText(spannableString[1]);

        // exampleTheTense2
        spannableString[2].setSpan(clickableSpanExampleTheTense2,4,25,0);
        // make text bold
        spannableString[2].setSpan(new StyleSpan(Typeface.BOLD), 4,25, 0);
        exampleTheTense2.setMovementMethod(LinkMovementMethod.getInstance());
        exampleTheTense2.setText(spannableString[2]);
    }
}