package id.indrasudirman.belajarbahasainggris.fragment;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.uncopt.android.widget.text.justify.JustifiedTextView;

import androidx.viewpager2.widget.ViewPager2;
import id.indrasudirman.belajarbahasainggris.R;

public class SimplePastFragment1 extends Fragment {

    private View view;
    private JustifiedTextView justifiedTextViewSimplePastExplain, justifiedTextViewSimplePastFirstBullet, justifiedTextViewSimplePastSecondBullet, justifiedTextViewSimplePastThirdBullet;
    private AppCompatButton buttonNext;
    private ViewPager2 viewPager2;




    public SimplePastFragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_simple_past1, container, false);
        viewPager2 = getActivity().findViewById(R.id.viewPager);

        justifiedTextViewSimplePastExplain = view.findViewById(R.id.simple_past_explain);
        justifiedTextViewSimplePastFirstBullet = view.findViewById(R.id.simple_past_tense_example1);
        justifiedTextViewSimplePastSecondBullet = view.findViewById(R.id.simple_past_tense_example2);
        justifiedTextViewSimplePastThirdBullet = view.findViewById(R.id.simple_past_tense_example3);
        buttonNext = view.findViewById(R.id.nextSimplePast);

        SpannableString spannableString = new SpannableString(getActivity().getResources().getString(R.string.simple_past_explain));
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Simple Past Tense adalah salah satu dari 14 Tense (waktu) yang ada dalam Grammar Bahasa Inggris")
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

        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                AlertDialog.Builder alertDialogBuider = new AlertDialog.Builder(getActivity());
                //set title
                alertDialogBuider
                        .setTitle("Info");
                alertDialogBuider
                        .setMessage("Lihat Contoh nomor 3")
                        .setCancelable(false)
                        .setIcon(R.mipmap.ic_info_green)
                        .setPositiveButton("Sudah paham", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(getActivity(), "Saya sudah paham", Toast.LENGTH_SHORT).show();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuider.create();
                alertDialog.show();
            }
        };
        spannableString.setSpan(clickableSpan,0,17,0);
        spannableString.setSpan(clickableSpan2,284,291,0);
        // make text bold
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), 0, 136, 0);
        justifiedTextViewSimplePastExplain.setMovementMethod(LinkMovementMethod.getInstance());
        justifiedTextViewSimplePastExplain.setText(spannableString);

        SpannableString spannableString3 = new SpannableString(getActivity().getResources().getString(R.string.first_bullet));
        ClickableSpan clickableSpan3 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Lived adalah bentuk Verb 2 atau bentuk Simple Past yang artinya hidup/tinggal. Susunan bentuknya adalah Live (Verb 1) - Lived (Verb 2) - Lived (Verb 3). Live termasuk dalam bentuk Regular Verbs")
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

        spannableString3.setSpan(clickableSpan3,12,17,0);
        // make text bold
        spannableString3.setSpan(new StyleSpan(Typeface.BOLD), 12, 17, 0);
        justifiedTextViewSimplePastFirstBullet.setMovementMethod(LinkMovementMethod.getInstance());
        justifiedTextViewSimplePastFirstBullet.setText(spannableString3);

        SpannableString spannableString4 = new SpannableString(getActivity().getResources().getString(R.string.second_bullet));
        ClickableSpan clickableSpan4 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Bought adalah bentuk Verb 2 atau bentuk Simple Past yang artinya membeli/menyuap/menyogok. Susunan bentuknya adalah Buy (Verb 1) - Bought (Verb 2) - Bought (Verb 3). Buy termasuk dalam bentuk Irregular Verbs")
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

        spannableString4.setSpan(clickableSpan4,4,10,0);
        // make text bold
        spannableString4.setSpan(new StyleSpan(Typeface.BOLD), 4, 10, 0);
        justifiedTextViewSimplePastSecondBullet.setMovementMethod(LinkMovementMethod.getInstance());
        justifiedTextViewSimplePastSecondBullet.setText(spannableString4);

        SpannableString spannableString5 = new SpannableString(getActivity().getResources().getString(R.string.third_bullet));
        ClickableSpan clickableSpan5 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Grew adalah bentuk Verb 2 atau bentuk Simple Past yang artinya menanam/memelihara/tumbuh. Susunan bentuknya adalah Grow (Verb 1) - Grew (Verb 2) - Grown (Verb 3). Grow termasuk dalam bentuk Irregular Verbs")
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

        spannableString5.setSpan(clickableSpan5,19,23,0);
        // make text bold
        spannableString5.setSpan(new StyleSpan(Typeface.BOLD), 19, 23, 0);
        justifiedTextViewSimplePastThirdBullet.setMovementMethod(LinkMovementMethod.getInstance());
        justifiedTextViewSimplePastThirdBullet.setText(spannableString5);

        //Event button next fragment
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager2.setCurrentItem(1);

            }
        });




        return view;
    }
}