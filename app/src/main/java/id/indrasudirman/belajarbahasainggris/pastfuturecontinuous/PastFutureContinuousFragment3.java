package id.indrasudirman.belajarbahasainggris.pastfuturecontinuous;

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


public class PastFutureContinuousFragment3 extends Fragment {

    private View view;
    private AppCompatTextView verbalPastFutureContinuous;
    private AppCompatTextView verbalPositifPastFutureContinuous;
    private AppCompatTextView verbalNegatifPastFutureContinuous;
    private AppCompatTextView verbalQuestionPastFutureContinuous;
    private AppCompatTextView nominalPastFutureContinuous;
    private AppCompatTextView nominalPositifPastFutureContinuous;
    private AppCompatTextView nominalNegatifPastFutureContinuous;
    private AppCompatTextView nominalQuestionPastFutureContinuous;


    public PastFutureContinuousFragment3() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_past_future_continuous3, container, false);
        initView();
        mSpannableString();


        return view;
    }
    private void initView() {
        verbalPastFutureContinuous = view.findViewById(R.id.verbalPastFutureContinuous);
        verbalPositifPastFutureContinuous = view.findViewById(R.id.verbalPositifPastFutureContinuous);
        verbalNegatifPastFutureContinuous = view.findViewById(R.id.verbalNegatifPastFutureContinuous);
        verbalQuestionPastFutureContinuous = view.findViewById(R.id.verbalQuestionPastFutureContinuous);
        nominalPastFutureContinuous = view.findViewById(R.id.nominalPastFutureContinuous);
        nominalPositifPastFutureContinuous = view.findViewById(R.id.nominalPositifPastFutureContinuous);
        nominalNegatifPastFutureContinuous = view.findViewById(R.id.nominalNegatifPastFutureContinuous);
        nominalQuestionPastFutureContinuous = view.findViewById(R.id.nominalQuestionPastFutureContinuous);
    }

    private void mSpannableString() {
        SpannableString[] spannableString = new SpannableString[]{
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_past_future_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_positif_past_future_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_negatif_past_future_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_question_past_future_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_past_future_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_positif_past_future_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_negatif_past_future_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_question_past_future_continuous)))};

        ClickableSpan clickableSpanVerbalPastFutureContinuous = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kalimat Verbal merupakan kalimat yang memiliki predikat yang berupa kata kerja (Verb).\n" +
                        "Contoh :\n" +
                        "\n" +
                        "My parent would be travelling.\n" +
                        "My parent would not be travelling.\n" +
                        "Would my parent be travelling?\n" +
                        "travelling (travel) adalah kata kerja (verb)")
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

        ClickableSpan clickableSpanVerbalPositifPastFutureContinuous = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kata 'would be travelling' adalah bentuk dari Past Future Continuous Tense, terdiri dari rumus would + be + verb 1 + ing. Travelling dari kata kerja Travel artinya Berpergian.")
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

        ClickableSpan clickableSpanVerbalNegatifPastFutureContinuous = new ClickableSpan() {
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

        ClickableSpan clickableSpanNominalPastFutureContinuous = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kalimat nominal merupakan kalimat yang predikatnya berupa kata benda, kata sifat, kata bilangan, kata ganti, atau kata keterangan.\n" +
                        "Contoh :\n" +
                        "\n" +
                        "Lubna would be a student last year. (student, kata benda).\n" +
                        "Lubna would not be a student last year.\n" +
                        "Would Lubna be a student last year?")
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
        spannableString[0].setSpan(clickableSpanVerbalPastFutureContinuous,9,23,0);
        // make text bold
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 9, 23, 0);
        verbalPastFutureContinuous.setMovementMethod(LinkMovementMethod.getInstance());
        verbalPastFutureContinuous.setText(spannableString[0]);

        // verbalPositifPastFutureContinuous
        spannableString[1].setSpan(clickableSpanVerbalPositifPastFutureContinuous,99,118,0);
        // make text bold
        spannableString[1].setSpan(new StyleSpan(Typeface.BOLD), 99,118, 0);
        verbalPositifPastFutureContinuous.setMovementMethod(LinkMovementMethod.getInstance());
        verbalPositifPastFutureContinuous.setText(spannableString[1]);

        // verbalNegatifPastFutureContinuous
        spannableString[2].setSpan(clickableSpanVerbalNegatifPastFutureContinuous,111,114,0);
        // make text bold
        spannableString[2].setSpan(new StyleSpan(Typeface.BOLD), 111,114, 0);
        verbalNegatifPastFutureContinuous.setMovementMethod(LinkMovementMethod.getInstance());
        verbalNegatifPastFutureContinuous.setText(spannableString[2]);

        // nominalPastFutureContinuous
        spannableString[4].setSpan(clickableSpanNominalPastFutureContinuous,9,24,0);
        // make text bold
        spannableString[4].setSpan(new StyleSpan(Typeface.BOLD), 9,24, 0);
        nominalPastFutureContinuous.setMovementMethod(LinkMovementMethod.getInstance());
        nominalPastFutureContinuous.setText(spannableString[4]);

        // nominalPositifFutureContinuous 3 Complement
        spannableString[5].setSpan(clickableSpan3Complement,46,61,0);
        // make text bold
        spannableString[5].setSpan(new StyleSpan(Typeface.BOLD), 46,61, 0);
        nominalPositifPastFutureContinuous.setMovementMethod(LinkMovementMethod.getInstance());
        nominalPositifPastFutureContinuous.setText(spannableString[5]);
    }
}