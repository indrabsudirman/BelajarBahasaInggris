package id.indrasudirman.belajarbahasainggris.simplefuture;

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


public class SimpleFutureFragment1 extends Fragment {

    private View view;
    private JustifiedTextView simpleFutureExplain;
    private JustifiedTextView simpleFutureExample1;
    private JustifiedTextView simpleFutureExample2;


    public SimpleFutureFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_simple_future1, container, false);

        initView();
        mSpannableString();

        return view;
    }

    private void initView() {

        simpleFutureExplain = view.findViewById(R.id.simpleFutureExplain);
        simpleFutureExample1 = view.findViewById(R.id.simpleFutureExample1);
        simpleFutureExample2 = view.findViewById(R.id.simpleFutureExample2);
    }

    private void mSpannableString() {
        SpannableString[] spannableString = new SpannableString[]{
                new SpannableString((getActivity().getResources().getString(R.string.simple_future_explain))),
                new SpannableString((getActivity().getResources().getString(R.string.second_bullet_simple_future))),
                new SpannableString((getActivity().getResources().getString(R.string.third_bullet_simple_future)))};

        ClickableSpan clickableSpan0 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Simple Future Tense adalah salah satu dari 16 Tense (waktu) yang ada dalam Grammar Bahasa Inggris.")
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

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Conditonal sentence tipe satu digunakan untuk menyatakan sesuatu yang mungkin akan terjadi di masa yang akan datang (sangat mungkin terjadi). \nContoh: \nI will buy that book if I have enough money (Saya akan membeli buku itu, jika saya punya cukup uang).")
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
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Will artinya akan/mau. Will digunakan dalam bentuk Simple Future Tense. Selain Will bisa juga menggunakan Shall yang artinya sama dengan Will")
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

        ClickableSpan clickableSpan3 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("Will artinya akan/mau. Will digunakan dalam bentuk Simple Future Tense. Selain Will bisa juga menggunakan Shall yang artinya sama dengan Will")
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

        ClickableSpan clickableSpan4 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("if I have enough money, adalah contoh dari conditional sentence type satu")
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

        ClickableSpan clickableSpan5 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogSimplePast = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogSimplePast.setTitle("Info");
                alertDialogSimplePast.setMessage("next week, contoh dari time signal yang digunakan di Simple Future Tense.")
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
        spannableString[0].setSpan(clickableSpan0,0,19,0);
        // make text bold
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 0, 114, 0);
        //conditional sentences type satu
        spannableString[0].setSpan(clickableSpan1,259,290,0);
        spannableString[0].setSpan(new StyleSpan(Typeface.BOLD), 259, 290, 0);
        simpleFutureExplain.setMovementMethod(LinkMovementMethod.getInstance());
        simpleFutureExplain.setText(spannableString[0]);

        // simpleFutureExample1
        spannableString[1].setSpan(clickableSpan2,4,8,0);
        // make text bold
        spannableString[1].setSpan(new StyleSpan(Typeface.BOLD), 4, 8, 0);
        // Time Signal
        spannableString[1].setSpan(clickableSpan5,28,38,0);
        // make text bold
        spannableString[1].setSpan(new StyleSpan(Typeface.BOLD), 28, 38, 0);
        simpleFutureExample1.setMovementMethod(LinkMovementMethod.getInstance());
        simpleFutureExample1.setText(spannableString[1]);

        // simpleFutureExample2
        spannableString[2].setSpan(clickableSpan3,4,8,0);
        // make text bold
        spannableString[2].setSpan(new StyleSpan(Typeface.BOLD), 4, 8, 0);
        // conditional sentence
        spannableString[2].setSpan(clickableSpan4,23,46,0);
        // make text bold
        spannableString[2].setSpan(new StyleSpan(Typeface.BOLD), 23, 46, 0);
        simpleFutureExample2.setMovementMethod(LinkMovementMethod.getInstance());
        simpleFutureExample2.setText(spannableString[2]);
    }
}