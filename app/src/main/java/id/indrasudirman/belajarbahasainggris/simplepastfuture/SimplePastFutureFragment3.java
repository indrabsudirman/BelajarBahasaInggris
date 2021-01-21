package id.indrasudirman.belajarbahasainggris.simplepastfuture;

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

public class SimplePastFutureFragment3 extends Fragment {

    private View view;
    private AppCompatTextView verbalSimplePastFuture;
    private AppCompatTextView verbalPositifSimplePastPresent;
    private AppCompatTextView verbalNegatifSimplePastPresent;
    private AppCompatTextView verbalQuestionSimplePastPresent;
    private AppCompatTextView nominalSimplePastFuture;
    private AppCompatTextView nominalPositifSimplePastFuture;
    private AppCompatTextView nominalNegatifSimplePastFuture;
    private AppCompatTextView nominalQuestionSimplePastFuture;


    public SimplePastFutureFragment3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_simple_past_future3, container, false);

        initView();
        mSpannableString();

        return view;
    }

    private void initView() {
        verbalSimplePastFuture = view.findViewById(R.id.verbalSimplePastFuture);
        verbalPositifSimplePastPresent = view.findViewById(R.id.verbalPositifSimplePastPresent);
        verbalNegatifSimplePastPresent = view.findViewById(R.id.verbalNegatifSimplePastPresent);
        verbalQuestionSimplePastPresent = view.findViewById(R.id.verbalQuestionSimplePastPresent);
        nominalSimplePastFuture = view.findViewById(R.id.nominalSimplePastFuture);
        nominalPositifSimplePastFuture = view.findViewById(R.id.nominalPositifSimplePastFuture);
        nominalNegatifSimplePastFuture = view.findViewById(R.id.nominalNegatifSimplePastFuture);
        nominalQuestionSimplePastFuture = view.findViewById(R.id.nominalQuestionSimplePastFuture);
    }

    private void mSpannableString() {
        SpannableString[] spannableString = new SpannableString[]{
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_simple_past_future))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_simple_past_future))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_positif_simple_past_future))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_negatif_simple_past_future))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_verbal_question_simple_past_future))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_positif_simple_past_future))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_negatif_simple_past_future))),
                new SpannableString((getActivity().getResources().getString(R.string.bentuk_kalimat_nominal_question_simple_past_future)))};


        ClickableSpan clickableSpanVerbalSimplePastFuture = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kalimat Verbal merupakan kalimat yang memiliki predikat yang berupa kata kerja (Verb).\n" +
                        "Contoh :\n" +
                        "\n" +
                        "I would go.\n" +
                        "I would not go.\n" +
                        "Would I go?\n" +
                        "go adalah kata kerja (verb)")
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

        ClickableSpan clickableSpanVerbalPositifSimplePastPresent = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Would/Should ciri dari Simple Past Future Tense.")
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

        // VerbalSimplePastFuture
        spannableString[0].setSpan(clickableSpanVerbalSimplePastFuture, 9, 23, 0);
        // make text bold
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 9, 23, 0);
        verbalSimplePastFuture.setMovementMethod(LinkMovementMethod.getInstance());
        verbalSimplePastFuture.setText(spannableString[0]);

        // verbalPositifSimplePastPresent
        spannableString[2].setSpan(clickableSpanVerbalPositifSimplePastPresent, 26, 38, 0);
        // make text bold
        spannableString[2].setSpan(new StyleSpan(Typeface.BOLD), 26, 38, 0);
        verbalPositifSimplePastPresent.setMovementMethod(LinkMovementMethod.getInstance());
        verbalPositifSimplePastPresent.setText(spannableString[2]);

    }
}