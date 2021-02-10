package id.indrasudirman.belajarbahasainggris.pastperfect;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import id.indrasudirman.belajarbahasainggris.R;


public class PastPerfectFragment3 extends Fragment {

    private View view;
    private AppCompatTextView verbal;
    private AppCompatTextView verbalPositive;
    private AppCompatTextView verbalNegative;
    private AppCompatTextView verbalQuestion;
    private AppCompatTextView nominal;
    private AppCompatTextView nominalPositive;
    private AppCompatTextView nominalNegative;
    private AppCompatTextView nominalQuestion;



    public PastPerfectFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_past_perfect3, container, false);
        initView();
        mSpannableString();

        return view;
    }

    private void initView() {
        verbal = view.findViewById(R.id.verbal);
        verbalPositive = view.findViewById(R.id.verbalPositive);
        verbalNegative = view.findViewById(R.id.verbalNegative);
        verbalQuestion = view.findViewById(R.id.verbalQuestion);
        nominal = view.findViewById(R.id.nominal);
        nominalPositive = view.findViewById(R.id.nominalPositive);
        nominalNegative = view.findViewById(R.id.nominalNegative);
        nominalQuestion = view.findViewById(R.id.nominalQuestion);
    }

    private void mSpannableString() {
        SpannableString[] spannableString = new SpannableString[]{
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_past_perfect))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_positif_past_perfect))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_negatif_past_perfect))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_question_past_perfect))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_past_perfect))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_positif_past_perfect))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_negatif_past_perfect))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_question_past_perfect)))};

        ClickableSpan clickableSpanVerbal = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kalimat Verbal merupakan kalimat yang memiliki predikat yang berupa kata kerja (Verb).\n" +
                        "Contoh :\n" +
                        "\n" +
                        "I had eaten breakfast.\n" +
                        "I had not eaten breakfast.\n" +
                        "Had you eaten breakfast?\n" +
                        "eaten (eat) adalah kata kerja (verb 3) dari eat")
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

        ClickableSpan clickableSpanVerbalPositive = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kata 'had eaten' adalah bentuk dari Past Perfect Tense, terdiri dari rumus had + verb 3 (past participle). Eaten dari kata kerja Eat artinya Makan.")
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

        ClickableSpan clickableSpanVerbalNegative = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Penambahan Not, adalah ciri dari kalimat negatif.")
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

        ClickableSpan clickableSpanVerbalQuestion = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("V3 atau Verb 3 atau Past Participle artinya adalah kata kerja ketiga.")
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

        ClickableSpan clickableSpanNominal = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kalimat nominal merupakan kalimat yang predikatnya berupa kata benda, kata sifat, kata bilangan, kata ganti, atau kata keterangan.\n" +
                        "Contoh :\n" +
                        "\n" +
                        "Lubna had been a student. (student, kata benda/noun).\n" +
                        "Lubna had not been a student.\n" +
                        "Had Lubna been a student?")
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

        ClickableSpan clickableSpan3Complement = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("3 Complement terdiri atas : \n - Adjective (kata sifat)\n - Noun (kata benda)\n - Adverb (kata keterangan)")
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

        // verbalPastFutureContinuous
        spannableString[0].setSpan(clickableSpanVerbal,9,23,0);
        // make text bold
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 9, 23, 0);
        verbal.setMovementMethod(LinkMovementMethod.getInstance());
        verbal.setText(spannableString[0]);

        // verbalPositive
        spannableString[1].setSpan(clickableSpanVerbalPositive,71,80,0);
        // make text bold
        spannableString[1].setSpan(new StyleSpan(Typeface.BOLD), 71, 80 , 0);
        verbalPositive.setMovementMethod(LinkMovementMethod.getInstance());
        verbalPositive.setText(spannableString[1]);

        // verbalNegative
        spannableString[2].setSpan(clickableSpanVerbalNegative,81,84,0);
        // make text bold
        spannableString[2].setSpan(new StyleSpan(Typeface.BOLD), 81,84, 0);
        verbalNegative.setMovementMethod(LinkMovementMethod.getInstance());
        verbalNegative.setText(spannableString[2]);

        // verbalQuestion
        spannableString[3].setSpan(clickableSpanVerbalQuestion,33,44,0);
        // make text bold
        spannableString[3].setSpan(new StyleSpan(Typeface.BOLD), 33,44, 0);
        verbalNegative.setMovementMethod(LinkMovementMethod.getInstance());
        verbalNegative.setText(spannableString[3]);

        // nominal
        spannableString[4].setSpan(clickableSpanNominal,9,24,0);
        // make text bold
        spannableString[4].setSpan(new StyleSpan(Typeface.BOLD), 9,24, 0);
        nominal.setMovementMethod(LinkMovementMethod.getInstance());
        nominal.setText(spannableString[4]);

        //nominalPositive, 3 Complement
        spannableString[5].setSpan(clickableSpan3Complement,42,57,0);
        // make text bold
        spannableString[5].setSpan(new StyleSpan(Typeface.BOLD), 42,57, 0);
        nominalPositive.setMovementMethod(LinkMovementMethod.getInstance());
        nominalPositive.setText(spannableString[5]);
    }
}