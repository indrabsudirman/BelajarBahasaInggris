package id.indrasudirman.belajarbahasainggris.pastperfectcontinuous;

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


public class PastPerfectContinuousFragment3 extends Fragment {

    private View view;
    private AppCompatTextView verbal;
    private AppCompatTextView verbalPositive;
    private AppCompatTextView verbalNegative;
    private AppCompatTextView verbalQuestion;
    private AppCompatTextView nominal;
    private AppCompatTextView nominalPositive;
    private AppCompatTextView nominalNegative;
    private AppCompatTextView nominalQuestion;


    public PastPerfectContinuousFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_past_perfect_continuous3, container, false);

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
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_past_perfect_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_positive_past_perfect_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_negative_past_perfect_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_question_past_perfect_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_past_perfect_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_positive_past_perfect_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_negative_past_perfect_continuous))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_question_past_perfect_continuous)))};

        ClickableSpan clickableSpanVerbal = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kalimat Verbal merupakan kalimat yang memiliki predikat yang berupa kata kerja (Verb).\n" +
                        "Contoh :\n" +
                        "\n" +
                        "I had been studying at school.\n" +
                        "I had not been studying at school.\n" +
                        "Had I been studying at school?\n" +
                        "studying (study) adalah kata kerja (verb 1 + ing) dari study")
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
                alertDialogSimplePast.setMessage("Kata 'should have studied' adalah bentuk dari Past Future Perfect Tense, terdiri dari rumus would/should + have + verb 3 (past participle). studied dari kata kerja study artinya belajar.")
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
                        "My brother would have been a policeman. (policeman, kata benda/noun).\n" +
                        "My brother would not have been a policeman.\n" +
                        "Would my brother have been a policeman?")
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
        spannableString[1].setSpan(clickableSpanVerbalPositive,87,104,0);
        // make text bold
        spannableString[1].setSpan(new StyleSpan(Typeface.BOLD), 87,104, 0);
        verbalPositive.setMovementMethod(LinkMovementMethod.getInstance());
        verbalPositive.setText(spannableString[1]);

        // verbalNegative
        spannableString[2].setSpan(clickableSpanVerbalNegative,100,103,0);
        // make text bold
        spannableString[2].setSpan(new StyleSpan(Typeface.BOLD), 100,103, 0);
        verbalNegative.setMovementMethod(LinkMovementMethod.getInstance());
        verbalNegative.setText(spannableString[2]);

        // verbalQuestion
        spannableString[3].setSpan(clickableSpanVerbalQuestion,51,63,0);
        // make text bold
        spannableString[3].setSpan(new StyleSpan(Typeface.BOLD), 51,63, 0);
        verbalQuestion.setMovementMethod(LinkMovementMethod.getInstance());
        verbalQuestion.setText(spannableString[3]);

        // nominal
        spannableString[4].setSpan(clickableSpanNominal,9,24,0);
        // make text bold
        spannableString[4].setSpan(new StyleSpan(Typeface.BOLD), 9,24, 0);
        nominal.setMovementMethod(LinkMovementMethod.getInstance());
        nominal.setText(spannableString[4]);

        //nominalPositive, 3 Complement
        spannableString[5].setSpan(clickableSpan3Complement,58,71,0);
        // make text bold
        spannableString[5].setSpan(new StyleSpan(Typeface.BOLD), 58,71, 0);
        nominalPositive.setMovementMethod(LinkMovementMethod.getInstance());
        nominalPositive.setText(spannableString[5]);
    }
}