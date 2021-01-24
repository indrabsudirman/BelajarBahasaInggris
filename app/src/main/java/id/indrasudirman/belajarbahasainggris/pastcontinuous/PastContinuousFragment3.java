package id.indrasudirman.belajarbahasainggris.pastcontinuous;

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


public class PastContinuousFragment3 extends Fragment {

    private View view;
    private AppCompatTextView verbalPastContinuous;
    private AppCompatTextView verbalPositifPastContinuous;
    private AppCompatTextView verbalNegatifPastContinuous;
    private AppCompatTextView verbalQuestionPastContinuous;
    private AppCompatTextView nominalPastContinuous;
    private AppCompatTextView nominalPositifPastContinuous;
    private AppCompatTextView nominalNegatifPastContinuous;
    private AppCompatTextView nominalQuestionPastContinuous;


    public PastContinuousFragment3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_past_continuous3, container, false);

        initView();
        mSpannableString();

        return view;
    }

    private void initView() {
        verbalPastContinuous = view.findViewById(R.id.verbalPastContinuous);
        verbalPositifPastContinuous = view.findViewById(R.id.verbalPositifPastContinuous);
        verbalNegatifPastContinuous = view.findViewById(R.id.verbalNegatifPastContinuous);
        verbalQuestionPastContinuous = view.findViewById(R.id.verbalQuestionPastContinuous);
        nominalPastContinuous = view.findViewById(R.id.nominalPastContinuous);
        nominalPositifPastContinuous = view.findViewById(R.id.nominalPositifPastContinuous);
        nominalNegatifPastContinuous = view.findViewById(R.id.nominalNegatifPastContinuous);
        nominalQuestionPastContinuous = view.findViewById(R.id.nominalQuestionPastContinuous);
    }

    private void mSpannableString() {
        SpannableString[] spannableString = new SpannableString[]{
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_past_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_past_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_positif_past_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_negatif_past_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_question_past_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_positif_past_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_negatif_past_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_question_past_continuous)))};

        ClickableSpan clickableSpanVerbalPastContinuous = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kalimat Verbal merupakan kalimat yang memiliki predikat yang berupa kata kerja (Verb).\n" +
                        "Contoh :\n" +
                        "\n" +
                        "I was eating.\n" +
                        "I was not eating.\n" +
                        "Was I eating?\n" +
                        "eating (eat) adalah kata kerja (verb)")
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

        ClickableSpan clickableSpanNominalPastContinuous = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kalimat nominal merupakan kalimat yang predikatnya berupa kata benda, kata sifat, kata bilangan, kata ganti, atau kata keterangan.\n" +
                        "Contoh :\n" +
                        "\n" +
                        "I was happy. (happy, kata sifat)\n" +
                        "I was not be happy.\n" +
                        "Was I happy?")
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

        ClickableSpan clickableSpanVerbalPositifPastContinuous = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kata 'was eating' adalah contoh penggunaan Past Continuous Tense.")
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

        ClickableSpan clickableSpanVerbalNegatifPastContinuous = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kata 'was not' bisa disingkat menjadi wasn't.")
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

        ClickableSpan clickableSpanNominalPositifPastContinuous = new ClickableSpan() {
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

        ClickableSpan clickableSpanNominalNegatifPastContinuous = new ClickableSpan() {
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

        // verbalPastContinuous
        spannableString[0].setSpan(clickableSpanVerbalPastContinuous,9,23,0);
        // make text bold
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 9, 23, 0);
        verbalPastContinuous.setMovementMethod(LinkMovementMethod.getInstance());
        verbalPastContinuous.setText(spannableString[0]);

        // NominalPastContinuous
        spannableString[1].setSpan(clickableSpanNominalPastContinuous,9,24,0);
        // make text bold
        spannableString[1].setSpan(new StyleSpan(Typeface.BOLD), 9, 24, 0);
        nominalPastContinuous.setMovementMethod(LinkMovementMethod.getInstance());
        nominalPastContinuous.setText(spannableString[1]);

        // verbalPositifPastContinuous
        spannableString[2].setSpan(clickableSpanVerbalPositifPastContinuous,82,92,0);
        // make text bold
        spannableString[2].setSpan(new StyleSpan(Typeface.BOLD), 82,92, 0);
        verbalPositifPastContinuous.setMovementMethod(LinkMovementMethod.getInstance());
        verbalPositifPastContinuous.setText(spannableString[2]);

        //verbalNegatifPastContinuous
        spannableString[3].setSpan(clickableSpanVerbalNegatifPastContinuous,88,95,0);
        // make text bold
        spannableString[3].setSpan(new StyleSpan(Typeface.BOLD), 88,95, 0);
        verbalNegatifPastContinuous.setMovementMethod(LinkMovementMethod.getInstance());
        verbalNegatifPastContinuous.setText(spannableString[3]);

        //nominalPositifPastContinuous
        spannableString[5].setSpan(clickableSpanNominalPositifPastContinuous,40,53,0);
        // make text bold
        spannableString[5].setSpan(new StyleSpan(Typeface.BOLD), 40,53, 0);
        nominalPositifPastContinuous.setMovementMethod(LinkMovementMethod.getInstance());
        nominalPositifPastContinuous.setText(spannableString[5]);

        //nominalNegatifPastContinuous
        spannableString[6].setSpan(clickableSpanNominalNegatifPastContinuous,77,80,0);
        // make text bold
        spannableString[6].setSpan(new StyleSpan(Typeface.BOLD), 77,80, 0);
        nominalNegatifPastContinuous.setMovementMethod(LinkMovementMethod.getInstance());
        nominalNegatifPastContinuous.setText(spannableString[6]);
    }
}