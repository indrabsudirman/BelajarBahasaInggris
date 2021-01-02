package id.indrasudirman.belajarbahasainggris.simplepresent;

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

import com.uncopt.android.widget.text.justify.JustifiedTextView;

import id.indrasudirman.belajarbahasainggris.R;


public class SimplePresentFragment1 extends Fragment {

    private View view;
    private JustifiedTextView simplePresentExplain;
    private JustifiedTextView simplePresentTenseExample1;
    private JustifiedTextView simplePresentTenseExample2;
    private JustifiedTextView simplePresentTenseExample3;
    private SpannableString spannableStringExplain;
    private SpannableString spannableStringExample1;
    private SpannableString spannableStringExample2;
    private SpannableString spannableStringExample3;


    public SimplePresentFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_simple_present1, container, false);

        initViews();

        mSpannableStringExplain();
        mSpannableStringExample1();
        mSpannableStringExample2();
        mSpannableStringExample3();



        return view;
    }

    private void initViews() {
        simplePresentExplain = view.findViewById(R.id.simplePresentExplain);
        simplePresentTenseExample1 = view.findViewById(R.id.simplePresentTenseExample1);
        simplePresentTenseExample2 = view.findViewById(R.id.simplePresentTenseExample2);
        simplePresentTenseExample3 = view.findViewById(R.id.simplePresentTenseExample3);
    }

    private void mSpannableStringExplain() {
        spannableStringExplain = new SpannableString(getActivity().getResources().getString(R.string.simple_present_explain));
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {

                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Simple Present Tense adalah salah satu dari 16 Tense (waktu) yang ada dalam Grammar Bahasa Inggris")
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

        spannableStringExplain.setSpan(clickableSpan,0,20,0);
        // make text bold
        spannableStringExplain.setSpan(new StyleSpan(Typeface.BOLD), 0, 214, 0);
        simplePresentExplain.setMovementMethod(LinkMovementMethod.getInstance());
        simplePresentExplain.setText(spannableStringExplain);
    }

    private void mSpannableStringExample1() {

        spannableStringExample1 = new SpannableString(getActivity().getResources().getString(R.string.first_bullet_simple_present));
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {

                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Eats atau eat kata kerja yang artinya makan. Penambahan 's' karena dalam Simple Present Tense untuk He (dia laki-laki) kata kerja harus ditambahkan 's' atau 'es'")
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

        spannableStringExample1.setSpan(clickableSpan,5,9,0);
        spannableStringExample1.setSpan(new StyleSpan(Typeface.BOLD), 5, 9, 0);
        simplePresentTenseExample1.setMovementMethod(LinkMovementMethod.getInstance());
        simplePresentTenseExample1.setText(spannableStringExample1);

    }

    private void mSpannableStringExample2() {

        spannableStringExample2 = new SpannableString(getActivity().getResources().getString(R.string.second_bullet_simple_present));
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {

                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Go atau goes (jika ditambahkan 'es') kata kerja yang artinya pergi. Tidak ditambahkan 's' karena dalam Simple Present Tense untuk I (saya) kata kerja tidak ditambahkan 's' atau 'es'")
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

        spannableStringExample2.setSpan(clickableSpan,4,6,0);
        spannableStringExample2.setSpan(new StyleSpan(Typeface.BOLD), 4, 6, 0);
        simplePresentTenseExample2.setMovementMethod(LinkMovementMethod.getInstance());
        simplePresentTenseExample2.setText(spannableStringExample2);

    }

    private void mSpannableStringExample3() {

        spannableStringExample3 = new SpannableString(getActivity().getResources().getString(R.string.third_bullet_simple_present));
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {

                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Rise atau rises (jika ditambahkan 'es') kata kerja yang artinya terbit. Penambahan 's' karena dalam Simple Present Tense untuk It (itu benda, matahari dalam contoh ini) kata kerja harus ditambahkan 's' atau 'es'")
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

        spannableStringExample3.setSpan(clickableSpan,10,15,0);
        spannableStringExample3.setSpan(new StyleSpan(Typeface.BOLD), 10, 15, 0);
        simplePresentTenseExample3.setMovementMethod(LinkMovementMethod.getInstance());
        simplePresentTenseExample3.setText(spannableStringExample3);

    }
}