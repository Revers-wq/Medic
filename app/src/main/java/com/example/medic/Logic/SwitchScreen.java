package com.example.medic;

import java.util.ArrayList;
import java.util.Arrays;

public class SwitchScreen {
    ArrayList<ViewPagerItem> viewPagerItemArrayList;
    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    boolean finish;

    public void FillQueae()
    {
        viewPagerItemArrayList = new ArrayList<>();
        String[] mainText  = {"Анализы", "Уведомления", "Мониторинг"};
        String[] text = {"Экспресс сбор и получение проб", "Вы быстро узнаете о результатах", "Наши врачи всегда наблюдают за вашими показателями здоровья"};
        int[] imagId={R.drawable.screen1,R.drawable.screen2, R.drawable.screen3};
        for(int i =0;i<mainText.length;i++) {
            ViewPagerItem viewPagerItem = new ViewPagerItem(mainText[i], text[i], imagId[i]);
            viewPagerItemArrayList.add(viewPagerItem);
        }
    }
    public String[] getQueae()
    {
        ViewPagerItem viewPagerItem = viewPagerItemArrayList.get(0);
        String[] get = new String[]{viewPagerItem.mainText + "", viewPagerItem.text + "", viewPagerItem.imageId + ""};
        ViewPagerItem viewPagerItem1 = viewPagerItemArrayList.remove(0);
        return get;
    }
    public String getTextViewString(int size)
    {
        if(size>1){
            return "Пропустить";
        }
        else
        {
            return "Завершить";
        }
    }
    public boolean FinishActivity()
    {
        return finish;
    }
}