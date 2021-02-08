package id.indrasudirman.belajarbahasainggris.futurecontinuous;

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


public class FutureContinuousFragment3 extends Fragment {

    private View view;
    private AppCompatTextView verbalFutureContinuous;
    private AppCompatTextView verbalPositifFutureContinuous;
    private AppCompatTextView verbalNegatifFutureContinuous;
    private AppCompatTextView verbalQuestionFutureContinuous;
    private AppCompatTextView nominalFutureContinuous;
    private AppCompatTextView nominalPositifFutureContinuous;
    private AppCompatTextView nominalNegatifFutureContinuous;
    private AppCompatTextView nominalQuestionFutureContinuous;


    public FutureContinuousFragment3() {
        // Required empty public constructor

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_future_continuous3, container, false);
        initView();
        mSpannableString();

        return view;
    }

    private void initView() {
        verbalFutureContinuous = view.findViewById(R.id.verbalFutureContinuous);
        verbalPositifFutureContinuous = view.findViewById(R.id.verbalPositifFutureContinuous);
        verbalNegatifFutureContinuous = view.findViewById(R.id.verbalNegatifFutureContinuous);
        verbalQuestionFutureContinuous = view.findViewById(R.id.verbalQuestionFutureContinuous);
        nominalFutureContinuous = view.findViewById(R.id.nominalFutureContinuous);
        nominalPositifFutureContinuous = view.findViewById(R.id.nominalPositifFutureContinuous);
        nominalNegatifFutureContinuous = view.findViewById(R.id.nominalNegatifFutureContinuous);
        nominalQuestionFutureContinuous = view.findViewById(R.id.nominalQuestionFutureContinuous);
    }

    private void mSpannableString() {
        SpannableString[] spannableString = new SpannableString[]{
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_future_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_positif_future_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_negatif_future_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_question_future_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_future_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_positif_future_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_negatif_future_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_question_future_continuous)))};

        ClickableSpan clickableSpanVerbalFutureContinuous = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kalimat Verbal merupakan kalimat yang memiliki predikat yang berupa kata kerja (Verb).\n" +
                        "Contoh :\n" +
                        "\n" +
                        "My parent will be travelling.\n" +
                        "My parent will not be travelling.\n" +
                        "Will my parent be travelling?\n" +
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

        ClickableSpan clickableSpanVerbalPositifFutureContinuous = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kata 'will be travelling' adalah bentuk dari Future Continuous Tense, terdiri dari rumus will + be + verb 1 + ing. Travelling dari kata kerja Travel artinya Berpergian.")
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

        ClickableSpan clickableSpanVerbalNegatifFutureContinuous = new ClickableSpan() {
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

        ClickableSpan clickableSpanNominalFutureContinuous = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kalimat nominal merupakan kalimat yang predikatnya berupa kata benda, kata sifat, kata bilangan, kata ganti, atau kata keterangan.\n" +
                        "Contoh :\n" +
                        "\n" +
                        "Lubna will be a student next year. (student, kata benda).\n" +
                        "Lubna will not be a student next year.\n" +
                        "Will Lubna be a student next year?")
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

        // verbalFutureContinuous
        spannableString[0].setSpan(clickableSpanVerbalFutureContinuous,9,23,0);
        // make text bold
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 9, 23, 0);
        verbalFutureContinuous.setMovementMethod(LinkMovementMethod.getInstance());
        verbalFutureContinuous.setText(spannableString[0]);

        // verbalPositifFutureContinuous
        spannableString[1].setSpan(clickableSpanVerbalPositifFutureContinuous,102,118,0);
        // make text bold
        spannableString[1].setSpan(new StyleSpan(Typeface.BOLD), 102,118, 0);
        verbalPositifFutureContinuous.setMovementMethod(LinkMovementMethod.getInstance());
        verbalPositifFutureContinuous.setText(spannableString[1]);

        // verbalNegatifFutureContinuous
        spannableString[2].setSpan(clickableSpanVerbalNegatifFutureContinuous,108,111,0);
        // make text bold
        spannableString[2].setSpan(new StyleSpan(Typeface.BOLD), 108,111, 0);
        verbalNegatifFutureContinuous.setMovementMethod(LinkMovementMethod.getInstance());
        verbalNegatifFutureContinuous.setText(spannableString[2]);

        // nominalFutureContinuous
        spannableString[4].setSpan(clickableSpanNominalFutureContinuous,9,24,0);
        // make text bold
        spannableString[4].setSpan(new StyleSpan(Typeface.BOLD), 9,24, 0);
        nominalFutureContinuous.setMovementMethod(LinkMovementMethod.getInstance());
        nominalFutureContinuous.setText(spannableString[4]);

        // nominalPositifFutureContinuous 3 Complement
        spannableString[5].setSpan(clickableSpan3Complement,45,60,0);
        // make text bold
        spannableString[5].setSpan(new StyleSpan(Typeface.BOLD), 45,60, 0);
        nominalPositifFutureContinuous.setMovementMethod(LinkMovementMethod.getInstance());
        nominalPositifFutureContinuous.setText(spannableString[5]);
    }
}