package id.indrasudirman.belajarbahasainggris.presentperfectcontinuous;

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


public class PresentPerfectContinuousFragment1 extends Fragment {

    private View view;
    private JustifiedTextView explainTheTense;
    private JustifiedTextView exampleTheTense1;
    private JustifiedTextView exampleTheTense2;

    public PresentPerfectContinuousFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_present_perfect_continuous1, container, false);


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
                new SpannableString((getActivity().getResources().getString(R.string.present_perfect_continuous_explain))),
                new SpannableString((getActivity().getResources().getString(R.string.second_bullet_present_perfect_continuous_tense))),
                new SpannableString((getActivity().getResources().getString(R.string.third_bullet_present_perfect_continuous_tense)))};

        ClickableSpan clickableSpanExplainTheTense = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Present Perfect Continuous Tense adalah salah satu dari 16 Tense (waktu) yang ada dalam Grammar Bahasa Inggris.")
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
                alertDialogSimplePast.setMessage("Kata 'has been learning' adalah bentuk dari Present Perfect Continuous Tense, terdiri dari rumus have/has + been + verb 1 + ing. Learning dari kata kerja learn artinya belajar.")
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
                alertDialogSimplePast.setMessage("Kata 'have been living' adalah bentuk dari Present Perfect Continuous Tense, terdiri dari rumus have/has + been + verb 1 + ing. Living dari kata kerja live artinya tinggal/hidup.")
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
        spannableString[0].setSpan(clickableSpanExplainTheTense,0,32,0);
        // make text bold
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 0, 32, 0);
        // dimulai pada masa lalu (lampau) ...
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 86, 171, 0);
        // has been learning
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 370, 388, 0);
        // Present Perfect Continuous Tense.
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 747, 780, 0);

        //have been living
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 800, 818, 0);

        explainTheTense.setMovementMethod(LinkMovementMethod.getInstance());
        explainTheTense.setText(spannableString[0]);

        // exampleTheTense1
        spannableString[1].setSpan(clickableSpanExampleTheTense1,8,25,0);
        // make text bold
        spannableString[1].setSpan(new StyleSpan(Typeface.BOLD), 8,25, 0);
        exampleTheTense1.setMovementMethod(LinkMovementMethod.getInstance());
        exampleTheTense1.setText(spannableString[1]);

        // exampleTheTense2
        spannableString[2].setSpan(clickableSpanExampleTheTense2,4,20,0);
        // make text bold
        spannableString[2].setSpan(new StyleSpan(Typeface.BOLD), 4,20, 0);
        exampleTheTense2.setMovementMethod(LinkMovementMethod.getInstance());
        exampleTheTense2.setText(spannableString[2]);
    }
}