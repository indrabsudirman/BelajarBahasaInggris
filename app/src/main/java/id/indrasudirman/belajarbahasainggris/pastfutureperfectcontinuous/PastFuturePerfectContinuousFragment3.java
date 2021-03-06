package id.indrasudirman.belajarbahasainggris.pastfutureperfectcontinuous;

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


public class PastFuturePerfectContinuousFragment3 extends Fragment {

    private View view;
    private AppCompatTextView verbal;
    private AppCompatTextView verbalPositive;
    private AppCompatTextView verbalNegative;
    private AppCompatTextView verbalQuestion;
    private AppCompatTextView nominal;
    private AppCompatTextView nominalPositive;
    private AppCompatTextView nominalNegative;
    private AppCompatTextView nominalQuestion;


    public PastFuturePerfectContinuousFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_past_future_perfect_continuous3, container, false);


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
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_past_future_perfect_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_positive_past_future_perfect_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_negative_past_future_perfect_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_question_past_future_perfect_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_past_future_perfect_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_positive_past_future_perfect_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_negative_past_future_perfect_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_question_past_future_perfect_continuous)))};

        ClickableSpan clickableSpanVerbal = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kalimat Verbal merupakan kalimat yang memiliki predikat yang berupa kata kerja (Verb).\n" +
                        "Contoh :\n" +
                        "\n" +
                        "He should have been paying the bill.\n" +
                        "He should not have been paying the bill.\n" +
                        "Should he have been paying the bill?\n" +
                        "Paying (pay) adalah kata kerja (verb 1 + ing) dari pay.")
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
                alertDialogSimplePast.setMessage("Kata 'should have been paying' adalah bentuk dari Past Future Perfect Continuous Tense, terdiri dari rumus would/should + have + been + verb 1 + ing. paying dari kata pay artinya membayar.")
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
                alertDialogSimplePast.setMessage("V1 atau Verb 1 artinya adalah kata kerja kesatu.")
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
                        "My sister would have been being a student. (student, kata benda).\n" +
                        "My sister would not have been being a student.\n" +
                        "Would my sister have been being a student?")
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

        // verbal
        spannableString[0].setSpan(clickableSpanVerbal,9,23,0);
        // make text bold
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 9, 23, 0);
        verbal.setMovementMethod(LinkMovementMethod.getInstance());
        verbal.setText(spannableString[0]);

        // verbalPositive
        spannableString[1].setSpan(clickableSpanVerbalPositive,101,124,0);
        // make text bold
        spannableString[1].setSpan(new StyleSpan(Typeface.BOLD), 101,124, 0);
        verbalPositive.setMovementMethod(LinkMovementMethod.getInstance());
        verbalPositive.setText(spannableString[1]);

        // verbalNegative
        spannableString[2].setSpan(clickableSpanVerbalNegative,114,117,0);
        // make text bold
        spannableString[2].setSpan(new StyleSpan(Typeface.BOLD), 114,117, 0);
        verbalNegative.setMovementMethod(LinkMovementMethod.getInstance());
        verbalNegative.setText(spannableString[2]);

        // verbalQuestion
        spannableString[3].setSpan(clickableSpanVerbalQuestion,59,70,0);
        // make text bold
        spannableString[3].setSpan(new StyleSpan(Typeface.BOLD), 59,70, 0);
        verbalQuestion.setMovementMethod(LinkMovementMethod.getInstance());
        verbalQuestion.setText(spannableString[3]);

        // nominal
        spannableString[4].setSpan(clickableSpanNominal,9,24,0);
        // make text bold
        spannableString[4].setSpan(new StyleSpan(Typeface.BOLD), 9,24, 0);
        nominal.setMovementMethod(LinkMovementMethod.getInstance());
        nominal.setText(spannableString[4]);

        //nominalPositive, 3 Complement
        spannableString[5].setSpan(clickableSpan3Complement,66,79,0);
        // make text bold
        spannableString[5].setSpan(new StyleSpan(Typeface.BOLD), 66,79, 0);
        nominalPositive.setMovementMethod(LinkMovementMethod.getInstance());
        nominalPositive.setText(spannableString[5]);
    }
}