package com.lifeistech.android.tenji;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class BrailleFragment extends Fragment implements TextWatcher{

    //ImageViewの配列
    ImageView[] imageView;

    public Braille[] brailles;

    private char[] japaneses = {
            'あ','い','う','え','お',
            'か','き','く','け','こ',
            'さ','し','す','せ','そ',
            'た','ち','つ','て','と',
            'な','に','ぬ','ね','の',
            'は','ひ','ふ','へ','ほ',
            'ま','み','む','め','も',
            'や','ゆ','よ',
            'ら','り','る','れ','ろ',
            'わ','ゐ','ゑ','を',
            'ん','っ','ー',
            '。','、','・','？','！'
    };

    private int[] res = {
            R.drawable.a_1,R.drawable.i_3,R.drawable.u_9,R.drawable.e_11,R.drawable.o_10,
            R.drawable.ka_33,R.drawable.ki_35,R.drawable.ku_41,R.drawable.ke_43,R.drawable.ko_42,
            R.drawable.sa_49,R.drawable.shi_51,R.drawable.su_57,R.drawable.se_59,R.drawable.so_58,
            R.drawable.ta_21,R.drawable.chi_23,R.drawable.tsu_29,R.drawable.te_31,R.drawable.to_30,
            R.drawable.na_5,R.drawable.ni_7,R.drawable.nu_13,R.drawable.ne_15,R.drawable.no_14,
            R.drawable.ha_37,R.drawable.hi_39,R.drawable.hu_45,R.drawable.he_47,R.drawable.ho_46,
            R.drawable.ma_53,R.drawable.mi_55,R.drawable.mu_61,R.drawable.me_63,R.drawable.mo_62,
            R.drawable.ya_12,R.drawable.yu_44,R.drawable.yo_28,
            R.drawable.ra_17,R.drawable.ri_19,R.drawable.ru_25,R.drawable.re_27,R.drawable.ro_26,
            R.drawable.wa_4,R.drawable.wyi_6,R.drawable.wye_22,R.drawable.wo_20,
            R.drawable.n_52,R.drawable.ltu_2,R.drawable.haihun_18,
            R.drawable.kuten_50,R.drawable.touten_48,R.drawable.ten_16,R.drawable.question_34,R.drawable.exclamation_22
    };

    EditText editText; //翻訳する原文

    private InputMethodManager inputMethodManager;
    private LinearLayout linearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_braille, null);
    }

    // Viewが生成し終わった時に呼ばれるメソッド
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //画面全体のレイアウト
        linearLayout = (LinearLayout)view.findViewById(R.id.linearLayout);

        //キーボード表示を制御するためのオブジェクト
        inputMethodManager =  (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

        imageView = new ImageView[]{
                (ImageView) view.findViewById(R.id.imageView1),
                (ImageView) view.findViewById(R.id.imageView2),
                (ImageView) view.findViewById(R.id.imageView3),
                (ImageView) view.findViewById(R.id.imageView4),
                (ImageView) view.findViewById(R.id.imageView5),
                (ImageView) view.findViewById(R.id.imageView6),
                (ImageView) view.findViewById(R.id.imageView7),
                (ImageView) view.findViewById(R.id.imageView8),
                (ImageView) view.findViewById(R.id.imageView9),
                (ImageView) view.findViewById(R.id.imageView10),
                (ImageView) view.findViewById(R.id.imageView11),
                (ImageView) view.findViewById(R.id.imageView12),
                (ImageView) view.findViewById(R.id.imageView13),
                (ImageView) view.findViewById(R.id.imageView14),
                (ImageView) view.findViewById(R.id.imageView15),
                (ImageView) view.findViewById(R.id.imageView16)
        };

        //braillesの初期化
        brailles = new Braille[64];
        for(int i = 0;i<res.length;i++){
            Braille braille = new Braille(res[i],japaneses[i]);
            brailles[i] = braille;
        }

        editText = (EditText) view.findViewById(R.id.editText);

//        editText.setOnFocusChangeListener(new View.OnFocusChangeListener(){
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                // EditTextのフォーカスが外れた場合
//                if (hasFocus == false) {
//                    // ソフトキーボードを非表示にする
//                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
//                    imm.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
//                }
//            }
//        });


//        view.findViewById(R.id.translate).setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//
//
//                //EditTextから文字列取得
//                String str = editText.getText().toString().trim();
//
//                //文字列をchar型に変換
//                char[] charArray = str.toCharArray();
//
//                //Log.d("toBActivity:",str);
//
//                //char型からint型の画像データを検索
//
//                int[] res_data = new int[16]; //16画像の表示制限
//
//                for(int i = 0; i < charArray.length;i++){
//                    for(int j = 0; j < res.length;j++){
//                        if(charArray[i] == brailles[j].getC_japanese()){
//                            res_data[i] = brailles[j].getRes();
//                            break;
//                        }
//                    }
//                }
//
//                //画像データの表示
//
//                for(int k = 0;k < res_data.length;k++){
//                    imageView[k].setImageResource(res_data[k]);
//                }
//
//            }
//        });

        editText.addTextChangedListener(this);   //追加

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //イベントを取得するタイミングには、ボタンが押されてなおかつエンターキーだったときを指定
                if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){
                    //キーボードを閉じる
                    inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
                    return true;
                }
                return false;            }
        });

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        //操作前のEditTextの状態を取得する
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //操作中のEditTextの状態を取得する
    }

    @Override
    public void afterTextChanged(Editable s) {
        //操作後のEditTextの状態を取得する

        //文字列をchar型に変換
        char[] charArray = s.toString().toCharArray();

        //Log.d("toBActivity:",str);

        //char型からint型の画像データを検索

        int[] res_data = new int[16]; //16画像の表示制限

        for(int i = 0; i < charArray.length;i++){
            for(int j = 0; j < res.length;j++){
                if(charArray[i] == brailles[j].getJapanese()){
                    res_data[i] = brailles[j].getResId();
                    break;
                }
            }
        }

        //画像データの表示

        for(int k = 0;k < res_data.length;k++){
            imageView[k].setImageResource(res_data[k]);
        }

    }
}
