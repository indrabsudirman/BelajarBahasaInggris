package id.indrasudirman.belajarbahasainggris.presentcontinuous;

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


public class PresentContinuousFragment3 extends Fragment {

    private View view;
    private AppCompatTextView verbalPresentContinuous;
    private AppCompatTextView verbalPositifPresentContinuous;
    private AppCompatTextView verbalNegatifPresentContinuous;
    private AppCompatTextView verbalQuestionPresentContinuous;
    private AppCompatTextView nominalPresentContinuous;
    private AppCompatTextView nominalPositifPresentContinuous;
    private AppCompatTextView nominalNegatifPresentContinuous;
    private AppCompatTextView nominalQuestionPresentContinuous;


    public PresentContinuousFragment3() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_present_continuous3, container, false);

        initView();
        mSpannableString();

        return view;
    }

    private void initView() {
        verbalPresentContinuous = view.findViewById(R.id.verbalPresentContinuous);
        verbalPositifPresentContinuous = view.findViewById(R.id.verbalPositifPresentContinuous);
        verbalNegatifPresentContinuous = view.findViewById(R.id.verbalNegatifPresentContinuous);
        verbalQuestionPresentContinuous = view.findViewById(R.id.verbalQuestionPresentContinuous);
        nominalPresentContinuous = view.findViewById(R.id.nominalPresentContinuous);
        nominalPositifPresentContinuous = view.findViewById(R.id.nominalPositifPresentContinuous);
        nominalNegatifPresentContinuous = view.findViewById(R.id.nominalNegatifPresentContinuous);
        nominalQuestionPresentContinuous = view.findViewById(R.id.nominalQuestionPresentContinuous);
    }

    private void mSpannableString() {
        SpannableString[] spannableString = new SpannableString[]{
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_present_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_present_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_positif_present_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_negatif_present_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_question_present_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_positif_present_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_negatif_present_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_question_present_continuous)))};

        ClickableSpan clickableSpanVerbalPastContinuous = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kalimat Verbal merupakan kalimat yang memiliki predikat yang berupa kata kerja (Verb).\n" +
                        "Contoh :\n" +
                        "\n" +
                        "I am learning.\n" +
                        "I am not learning.\n" +
                        "Am I learning?\n" +
                        "learning (learn) adalah kata kerja (verb)")
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

        ClickableSpan clickableSpanNominalPresentContinuous = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kalimat nominal merupakan kalimat yang predikatnya berupa kata benda, kata sifat, kata bilangan, kata ganti, atau kata keterangan.\n" +
                        "Contoh :\n" +
                        "\n" +
                        "Lubna is a good student. (good, kata sifat).\n" +
                        "Lubna is not a good student.\n" +
                        "Is Lubna a good student?")
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

        ClickableSpan clickableSpanVerbalPositifPresentContinuous = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("kata 'am learning', am adalah to be dari I. learning adalah Verb 1 + ing, rumus yang harus digunakan untuk bentuk Continuous Tense.")
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

        ClickableSpan clickableSpanVerbalNegatifPresentContinuous = new ClickableSpan() {
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

        ClickableSpan clickableSpanNominalPositifPresentContinuous = new ClickableSpan() {
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

        ClickableSpan clickableSpanVerbalQuestionPresentContinuous = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kata 'now' adalah bentuk time signal dari Present Continuous Tense")
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

        ClickableSpan clickableSpanVerbalQuestionPresentContinuousGood = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kata 'good' adalah kata sifat yang termasuk dalam 3 Complement. Artinya baik.")
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

        // verbalPresentContinuous
        spannableString[0].setSpan(clickableSpanVerbalPastContinuous,9,23,0);
        // make text bold
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 9, 23, 0);
        verbalPresentContinuous.setMovementMethod(LinkMovementMethod.getInstance());
        verbalPresentContinuous.setText(spannableString[0]);

        // NominalPresentContinuous
        spannableString[1].setSpan(clickableSpanNominalPresentContinuous,9,24,0);
        // make text bold
        spannableString[1].setSpan(new StyleSpan(Typeface.BOLD), 9, 24, 0);
        nominalPresentContinuous.setMovementMethod(LinkMovementMethod.getInstance());
        nominalPresentContinuous.setText(spannableString[1]);

        // VerbalPositifPresentContinuous
        spannableString[2].setSpan(clickableSpanVerbalPositifPresentContinuous,85,96,0);
        // make text bold
        spannableString[2].setSpan(new StyleSpan(Typeface.BOLD), 85, 96, 0);
        verbalPositifPresentContinuous.setMovementMethod(LinkMovementMethod.getInstance());
        verbalPositifPresentContinuous.setText(spannableString[2]);

        //verbalNegatifPresentContinuous
        spannableString[3].setSpan(clickableSpanVerbalNegatifPresentContinuous,94,97,0);
        // make text bold
        spannableString[3].setSpan(new StyleSpan(Typeface.BOLD), 94, 97, 0);
        verbalNegatifPresentContinuous.setMovementMethod(LinkMovementMethod.getInstance());
        verbalNegatifPresentContinuous.setText(spannableString[3]);

        //verbalQuestionPresentContinuous
        spannableString[4].setSpan(clickableSpanVerbalQuestionPresentContinuous,115,118,0);
        // make text bold
        spannableString[4].setSpan(new StyleSpan(Typeface.BOLD), 115,118, 0);
        verbalQuestionPresentContinuous.setMovementMethod(LinkMovementMethod.getInstance());
        verbalQuestionPresentContinuous.setText(spannableString[4]);

        //nominalPositifPresentContinuous
        spannableString[5].setSpan(clickableSpanNominalPositifPresentContinuous,40,56,0);
        // make text bold
        spannableString[5].setSpan(new StyleSpan(Typeface.BOLD), 40,56, 0);
        nominalPositifPresentContinuous.setMovementMethod(LinkMovementMethod.getInstance());
        nominalPositifPresentContinuous.setText(spannableString[5]);

        //nominalPositifPresentContinuousGood
        spannableString[5].setSpan(clickableSpanVerbalQuestionPresentContinuousGood,80,84,0);
        // make text bold
        spannableString[5].setSpan(new StyleSpan(Typeface.BOLD), 80,84, 0);
        nominalPositifPresentContinuous.setMovementMethod(LinkMovementMethod.getInstance());
        nominalPositifPresentContinuous.setText(spannableString[5]);

    }
}