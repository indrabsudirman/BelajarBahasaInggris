package id.indrasudirman.belajarbahasainggris.simplepastfuture;

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

import com.github.chrisbanes.photoview.PhotoView;
import com.uncopt.android.widget.text.justify.JustifiedTextView;

import id.indrasudirman.belajarbahasainggris.R;


public class SimplePastFutureFragment1 extends Fragment {

    private View view;
    private PhotoView simplePastFutureImage;
    private JustifiedTextView simplePastFutureExplain;
    private JustifiedTextView simplePastFutureExample1;
    private JustifiedTextView simplePastFutureExample2;


    public SimplePastFutureFragment1() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_simple_past_future1, container, false);


        initView();
        mSpannableString();


        return view;
    }

    private void initView() {
        simplePastFutureImage = view.findViewById(R.id.simplePastFutureImage);
        simplePastFutureImage.setImageResource(R.drawable.simple_past_future_tense_master);
        simplePastFutureExplain = view.findViewById(R.id.simplePastFutureExplain);
        simplePastFutureExample1 = view.findViewById(R.id.simplePastFutureExample1);
        simplePastFutureExample2 = view.findViewById(R.id.simplePastFutureExample2);

    }

    private void mSpannableString() {
        SpannableString[] spannableString = new SpannableString[]{
                new SpannableString((getActivity().getResources().getString(R.string.simple_past_future_explain))),
                new SpannableString((getActivity().getResources().getString(R.string.second_bullet_simple_past_future))),
                new SpannableString((getActivity().getResources().getString(R.string.third_bullet_simple_past_future)))};


        ClickableSpan clickableSpanSimplePastFutureExplain = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Simple Past Future Tense adalah salah satu dari 16 Tense (waktu) yang ada dalam Grammar Bahasa Inggris.")
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

        ClickableSpan simplePastFutureExampleOne1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("'Lubna promised to me', ini adalah contoh dari Simple Past Tense, bukan Simple Past Future Tense.")
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

        ClickableSpan simplePastFutureExampleOne2 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kata 'Would give', ini adalah bentuk dari Simple Past Future Tense.")
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

        ClickableSpan simplePastFutureExampleTwo1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kata 'Would give', ini adalah bentuk dari Simple Past Future Tense.")
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

        // simplePastFutureExplain
        spannableString[0].setSpan(clickableSpanSimplePastFutureExplain,0,24,0);
        // make text bold
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 0, 24, 0);
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 108, 150, 0);
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 515, 572, 0);
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 632, 651, 0);

        simplePastFutureExplain.setMovementMethod(LinkMovementMethod.getInstance());
        simplePastFutureExplain.setText(spannableString[0]);

        // simplePastFutureExampleOne1
        spannableString[1].setSpan(simplePastFutureExampleOne1,2,22,0);
        // make text bold
        spannableString[1].setSpan(new StyleSpan(Typeface.BOLD), 2, 22, 0);

        simplePastFutureExample1.setMovementMethod(LinkMovementMethod.getInstance());
        simplePastFutureExample1.setText(spannableString[1]);

        // simplePastFutureExampleOne2
        spannableString[1].setSpan(simplePastFutureExampleOne2,28,38,0);
        // make text bold
        spannableString[1].setSpan(new StyleSpan(Typeface.BOLD), 28, 38, 0);

        simplePastFutureExample1.setMovementMethod(LinkMovementMethod.getInstance());
        simplePastFutureExample1.setText(spannableString[1]);

        // simplePastFutureExampleTwo1
        spannableString[2].setSpan(simplePastFutureExampleTwo1,23,33,0);
        // make text bold
        spannableString[2].setSpan(new StyleSpan(Typeface.BOLD), 23, 33, 0);

        simplePastFutureExample2.setMovementMethod(LinkMovementMethod.getInstance());
        simplePastFutureExample2.setText(spannableString[2]);

    }

}