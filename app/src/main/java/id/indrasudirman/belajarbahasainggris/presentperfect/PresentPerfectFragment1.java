package id.indrasudirman.belajarbahasainggris.presentperfect;

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


public class PresentPerfectFragment1 extends Fragment {

    private View view;
    private JustifiedTextView explainTheTense;
    private JustifiedTextView exampleTheTense1;
    private JustifiedTextView exampleTheTense2;


    public PresentPerfectFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_present_perfect1, container, false);

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
                new SpannableString((getActivity().getResources().getString(R.string.present_perfect_explain))),
                new SpannableString((getActivity().getResources().getString(R.string.second_bullet_present_perfect_tense))),
                new SpannableString((getActivity().getResources().getString(R.string.third_bullet_present_perfect_tense)))};

        ClickableSpan clickableSpanExplainTheTense = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Present Perfect Tense adalah salah satu dari 16 Tense (waktu) yang ada dalam Grammar Bahasa Inggris.")
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
                alertDialogSimplePast.setMessage("Kata 'has learned' adalah bentuk dari Present Perfect Tense, terdiri dari rumus have + verb 3. learned dari kata kerja learn artinya belajar.")
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
                alertDialogSimplePast.setMessage("Kata 'have seen' adalah bentuk dari Present Perfect Tense, terdiri dari rumus have + verb 3. seen dari kata kerja see artinya melihat.")
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
        spannableString[0].setSpan(clickableSpanExplainTheTense,0,21,0);
        // make text bold
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 0, 21, 0);
        // dimulai pada masa lalu tapi masih ...
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 75, 134, 0);
        // Present Perfect
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 166, 181, 0);
        // has learned
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 344, 355, 0);
        // have seen
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 676, 685, 0);
        //Penjelasannya
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 417, 432, 0);
        spannableString[0].setSpan(new UnderlineSpan(), 417, 432, 0);

        explainTheTense.setMovementMethod(LinkMovementMethod.getInstance());
        explainTheTense.setText(spannableString[0]);

        // exampleTheTense1
        spannableString[1].setSpan(clickableSpanExampleTheTense1,14,25,0);
        // make text bold
        spannableString[1].setSpan(new StyleSpan(Typeface.BOLD), 14,25, 0);
        exampleTheTense1.setMovementMethod(LinkMovementMethod.getInstance());
        exampleTheTense1.setText(spannableString[1]);

        // exampleTheTense2
        spannableString[2].setSpan(clickableSpanExampleTheTense2,12,21,0);
        // make text bold
        spannableString[2].setSpan(new StyleSpan(Typeface.BOLD), 12,21, 0);
        exampleTheTense2.setMovementMethod(LinkMovementMethod.getInstance());
        exampleTheTense2.setText(spannableString[2]);
    }
}