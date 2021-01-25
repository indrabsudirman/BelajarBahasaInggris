package id.indrasudirman.belajarbahasainggris.presentcontinuous;

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

public class PresentContinuousFragment1 extends Fragment {

    private View view;
    private JustifiedTextView presentContinuousExplain;
    private JustifiedTextView presentContinuousExample1;
    private JustifiedTextView presentContinuousExample2;


    public PresentContinuousFragment1() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_present_continuous1, container, false);

        initView();
        mSpannableString();

        return view;
    }

    private void initView() {

        presentContinuousExplain = view.findViewById(R.id.presentContinuousExplain);
        presentContinuousExample1 = view.findViewById(R.id.presentContinuousExample1);
        presentContinuousExample2 = view.findViewById(R.id.presentContinuousExample2);
    }

    private void mSpannableString() {
        SpannableString[] spannableString = new SpannableString[]{
                new SpannableString((getActivity().getResources().getString(R.string.present_continuous_tense_explain))),
                new SpannableString((getActivity().getResources().getString(R.string.second_bullet_present_continuous_tense))),
                new SpannableString((getActivity().getResources().getString(R.string.third_bullet_present_continuous_tense)))};

        ClickableSpan clickableSpanPresentContinuousExplain = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Present Continuous Tense adalah salah satu dari 16 Tense (waktu) yang ada dalam Grammar Bahasa Inggris.")
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

        ClickableSpan clickableSpanPresentContinuousExample1Is = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kata 'is' adalah to be dari Lubna. Salah satu rumus Present Continuous Tense.")
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

        ClickableSpan clickableSpanPresentContinuousExample1Studying = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kata 'studying' adalah verb 1 (study) + ing. Salah satu rumus Present Continuous Tense. Study artinya belajar.")
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

        ClickableSpan clickableSpanPresentContinuousExample1am = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kata 'am' adalah to be dari I. Salah satu rumus Present Continuous Tense.")
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

        ClickableSpan clickableSpanPresentContinuousExample1Eating = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Kata 'eating' adalah verb 1 (eat) + ing. Salah satu rumus Present Continuous Tense. Eat artinya makan.")
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

        // simpleFutureExplain
        spannableString[0].setSpan(clickableSpanPresentContinuousExplain,0,24,0);
        // make text bold
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 0, 24, 0);
        // sedang terjadi pada saat ini.
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 78, 106, 0);
        //Penjelasannya
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 185, 200, 0);
        spannableString[0].setSpan(new UnderlineSpan(), 185, 200, 0);
        //Jadi jelas, Present Continuous Tense...
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 271, 357, 0);
        presentContinuousExplain.setMovementMethod(LinkMovementMethod.getInstance());
        presentContinuousExplain.setText(spannableString[0]);

        // presentContinuousExample1Is
        spannableString[1].setSpan(clickableSpanPresentContinuousExample1Is,8,10,0);
        // make text bold
        spannableString[1].setSpan(new StyleSpan(Typeface.BOLD), 8, 10, 0);
        presentContinuousExample1.setMovementMethod(LinkMovementMethod.getInstance());
        presentContinuousExample1.setText(spannableString[1]);

        // presentContinuousExample1Studying
        spannableString[1].setSpan(clickableSpanPresentContinuousExample1Studying,11,19,0);
        // make text bold
        spannableString[1].setSpan(new StyleSpan(Typeface.BOLD), 11, 19, 0);
        presentContinuousExample1.setMovementMethod(LinkMovementMethod.getInstance());
        presentContinuousExample1.setText(spannableString[1]);

        // presentContinuousExample2am
        spannableString[2].setSpan(clickableSpanPresentContinuousExample1am,4,6,0);
        // make text bold
        spannableString[2].setSpan(new StyleSpan(Typeface.BOLD), 4, 6, 0);
        presentContinuousExample2.setMovementMethod(LinkMovementMethod.getInstance());
        presentContinuousExample2.setText(spannableString[2]);

        // presentContinuousExample2eating
        spannableString[2].setSpan(clickableSpanPresentContinuousExample1Eating,7,13,0);
        // make text bold
        spannableString[2].setSpan(new StyleSpan(Typeface.BOLD), 7, 13, 0);
        presentContinuousExample2.setMovementMethod(LinkMovementMethod.getInstance());
        presentContinuousExample2.setText(spannableString[2]);
    }
}